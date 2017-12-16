package com.test.api.user;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.test.model.domain.user.BasicDataUser;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import utils.BasicDataUserMocks;
import utils.IntegrationTestBase;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserRestTest extends IntegrationTestBase {

  @Test
  public void return_400_after_persist_a_null_user() throws Exception{
    // Init
    Gson gson = new GsonBuilder().serializeNulls().create();
    String content = gson.toJson(null);

    //Act
    getMockMvc().perform(post("/api/user")
            .contentType(MediaType.APPLICATION_JSON_VALUE).content(content))
            .andExpect(status().isBadRequest());

  }

  @Test
  public void return_400_after_persist_an_user_without_name() throws Exception{
    // Init
    Gson gson = new GsonBuilder().serializeNulls().create();
    String content = gson.toJson(BasicDataUserMocks.getBasicDataUserWithoutName());

    //Act
    getMockMvc().perform(post("/api/user")
            .contentType(MediaType.APPLICATION_JSON_VALUE).content(content))
            .andExpect(status().isBadRequest());

  }

  @Test
  public void return_400_after_persist_an_user_without_email() throws Exception{
    // Init
    Gson gson = new GsonBuilder().serializeNulls().create();
    String content = gson.toJson(BasicDataUserMocks.getBasicDataUserWithoutMail());

    //Act
    getMockMvc().perform(post("/api/user")
            .contentType(MediaType.APPLICATION_JSON_VALUE).content(content))
            .andExpect(status().isBadRequest());

  }

  @Test
  public void return_400_after_persist_an_user_without_phone() throws Exception{
    // Init
    Gson gson = new GsonBuilder().serializeNulls().create();
    String content = gson.toJson(BasicDataUserMocks.getBasicDataUserWithoutPhone());

    //Act
    getMockMvc().perform(post("/api/user")
            .contentType(MediaType.APPLICATION_JSON_VALUE).content(content))
            .andExpect(status().isBadRequest());

  }

  @Test
  public void return_400_after_persist_an_user_without_sex() throws Exception{
    // Init
    Gson gson = new GsonBuilder().serializeNulls().create();
    String content = gson.toJson(BasicDataUserMocks.getBasicDataUserWithoutSex());

    //Act
    getMockMvc().perform(post("/api/user")
            .contentType(MediaType.APPLICATION_JSON_VALUE).content(content))
            .andExpect(status().isBadRequest());

  }

  @Test
  public void return_400_after_persist_an_user_with_an_invalid_mail() throws Exception{
    // Init
    Gson gson = new GsonBuilder().serializeNulls().create();
    String content = gson.toJson(BasicDataUserMocks.getBasicDataUserWithInvalidMail());

    //Act
    getMockMvc().perform(post("/api/user")
            .contentType(MediaType.APPLICATION_JSON_VALUE).content(content))
            .andExpect(status().isBadRequest());

  }

  @Test
  public void return_200_after_persist_a_valid_user() throws Exception{
    // Init
    BasicDataUser basicDataUser = BasicDataUserMocks.getNoErrorsBasicDataUser();
    Gson gson = new GsonBuilder().serializeNulls().create();
    String content = gson.toJson(basicDataUser);

    //Act
    getMockMvc().perform(post("/api/user")
            .contentType(MediaType.APPLICATION_JSON_VALUE).content(content))
            .andExpect(status().isOk());

  }

  @Test
  public void return_200_after_get_all_users() throws Exception{
    //Act
    getMockMvc().perform(get("/api/user")
            .contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(status().isOk());

  }

  @Test
  @Ignore
  @DatabaseSetup(value = "/datasets/com/test/model/domain/user/put/before_persist_user.xml", type = DatabaseOperation.CLEAN_INSERT)
  @ExpectedDatabase(value = "/datasets/com/test/model/domain/user/put/expected_user_persist.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
  @DatabaseTearDown(value = "/datasets/com/test/model/domain/user/put/after_persist_user.xml", type = DatabaseOperation.DELETE_ALL)
  public void return_200_after_update_user() throws Exception {
    // Init
    BasicDataUser basicDataUser = BasicDataUserMocks.getSandroBasicDataUser();
    Gson gson = new GsonBuilder().serializeNulls().create();
    String content = gson.toJson(basicDataUser);

    //Act
    getMockMvc().perform(put("/api/user/1")
            .contentType(MediaType.APPLICATION_JSON_VALUE).content(content))
            .andExpect(status().isOk());

  }


}
