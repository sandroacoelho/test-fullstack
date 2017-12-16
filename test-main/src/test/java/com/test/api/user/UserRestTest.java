package com.test.api.user;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import utils.IntegrationTestBase;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserRestTest extends IntegrationTestBase {


  @Test
  public void return_200_after_persist_an_user() throws Exception{
    //Act
    getMockMvc().perform(get("/api/user")
            .contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(status().isOk());

  }



  @Test
  public void return_200_after_get_all_users() throws Exception{
    //Act
    getMockMvc().perform(get("/api/user")
            .contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(status().isOk());

  }




}
