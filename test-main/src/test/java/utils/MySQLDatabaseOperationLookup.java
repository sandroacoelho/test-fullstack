package utils;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.operation.DefaultDatabaseOperationLookup;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.AbstractOperation;
import org.dbunit.operation.CompositeOperation;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MySQLDatabaseOperationLookup extends DefaultDatabaseOperationLookup {

  private static Map<DatabaseOperation, org.dbunit.operation.DatabaseOperation> mysqlLookup;

  static {
    mysqlLookup = new HashMap<>();
    /*mysqlLookup.put(DatabaseOperation.CLEAN_INSERT,
            new CompositeOperation(
                    new TruncateWithRestartSequences(),
                    org.dbunit.operation.DatabaseOperation.INSERT
            ));
    mysqlLookup.put(DatabaseOperation.DELETE_ALL, new TruncateWithRestartSequences());
    */
  }

  @Override
  public org.dbunit.operation.DatabaseOperation get(DatabaseOperation operation) {
    if (mysqlLookup.containsKey(operation)) {
      return mysqlLookup.get(operation);
    }

    return super.get(operation);
  }

  private static class TruncateWithRestartSequences extends AbstractOperation {
    @Override
    public void execute(final IDatabaseConnection connection, final IDataSet dataSet) throws DatabaseUnitException, SQLException {
      connection.getConfig().setProperty(DatabaseConfig.FEATURE_QUALIFIED_TABLE_NAMES, true);
      try (final Statement statement = connection.getConnection().createStatement()) {
        final String tables = Arrays.stream(dataSet.getTableNames()).collect(Collectors.joining(", "));
        if (!"DATABASECHANGELOG".equalsIgnoreCase(tables) && !"DATABASECHANGELOGLOCK".equalsIgnoreCase(tables)) {
        //  statement.execute("DELETE FROM " + tables);
        }
      }
    }
  }
}
