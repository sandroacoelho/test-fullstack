package com.test.api.user;

import com.test.model.domain.user.BasicDataUser;

import com.test.model.user.UserFacade;

import java.util.List;

import java.util.Objects;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
class UserRest {

  private final UserFacade userFacade;

  @RequestMapping(method = RequestMethod.POST)
  BasicDataUser persist(@RequestBody BasicDataUser basicDataUser) {

    return userFacade.persist(basicDataUser);

  }

  @RequestMapping(method = RequestMethod.GET)
  List<BasicDataUser> get() {

    return userFacade.getAll();

  }


  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  BasicDataUser get(@PathVariable("id") Long id) {

    return userFacade.get(id);

  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  void delete(@PathVariable("id") Long id) {

    userFacade.delete(id);

  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  ResponseEntity<BasicDataUser> update(@PathVariable Long id,
                                       @RequestBody BasicDataUser basicDataUser) {

    ResponseEntity<BasicDataUser> response = new ResponseEntity<BasicDataUser>(basicDataUser,
            HttpStatus.UNPROCESSABLE_ENTITY);

    if (Objects.equals(id, basicDataUser.getId())) {

      BasicDataUser result = userFacade.persist(basicDataUser);

      response = new ResponseEntity<BasicDataUser>(result, HttpStatus.OK);
    }

    return response;

  }

}


