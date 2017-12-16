package utils;

import com.test.model.domain.user.BasicDataUser;

public final class BasicDataUserMocks {

  public static BasicDataUser getNoErrorsBasicDataUser() {

    BasicDataUser basicDataUser = new BasicDataUser();

    basicDataUser.setId(1l);
    basicDataUser.setName("Jonh Doe");
    basicDataUser.setEmail("jonh.doe@gmail.com");
    basicDataUser.setPhone("551132654144");
    basicDataUser.setSex("M");

    return basicDataUser;

  }


  public static BasicDataUser getSandroBasicDataUser() {

    BasicDataUser basicDataUser = new BasicDataUser();

    basicDataUser.setId(2l);
    basicDataUser.setName("Sandro Athaide Coelho");
    basicDataUser.setEmail("sandroacoelho@gmail.com");
    basicDataUser.setPhone("32991230608");
    basicDataUser.setSex("M");

    return basicDataUser;

  }

  public static BasicDataUser getBasicDataUserWithInvalidMail() {

    BasicDataUser basicDataUser = getNoErrorsBasicDataUser();

    basicDataUser.setEmail("john.doe-invalidmail.com");

    return null;

  }

  public static BasicDataUser getBasicDataUserWithoutSex() {

    BasicDataUser basicDataUser = getNoErrorsBasicDataUser();

    basicDataUser.setSex(null);

    return null;

  }

  public static BasicDataUser getBasicDataUserWithoutPhone() {

    BasicDataUser basicDataUser = getNoErrorsBasicDataUser();

    basicDataUser.setPhone(null);

    return null;

  }

  public static BasicDataUser getBasicDataUserWithoutMail() {

    BasicDataUser basicDataUser = getNoErrorsBasicDataUser();

    basicDataUser.setEmail(null);

    return null;

  }

  public static BasicDataUser getBasicDataUserWithoutName() {

    BasicDataUser basicDataUser = getNoErrorsBasicDataUser();

    basicDataUser.setName(null);

    return null;

  }

}
