package com.test.model.user;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.test.model.domain.user.BasicDataUser;
import com.test.model.domain.user.User;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


@Service
@Transactional
@RequiredArgsConstructor
public class UserFacade {


  private final UserService userService;

  private BasicDataUser from(User user) {

    BasicDataUser basicDataUser = new BasicDataUser();

    basicDataUser.setId(user.getId());
    basicDataUser.setName(user.getName());
    basicDataUser.setEmail(user.getEmail());
    basicDataUser.setPhone(user.getPhone());
    basicDataUser.setSex(user.getSex());

    return basicDataUser;

  }

  private List<BasicDataUser> from(List<User> users) {

    List<BasicDataUser> result = new ArrayList<>();

    if (users != null && !users.isEmpty()) {
      users.stream().forEach(user -> result.add(from(user)));
    }

    return result;
  }

  private User to(BasicDataUser basicDataUser) {

    User user = new User();

    user.setId(basicDataUser.getId());
    user.setName(basicDataUser.getName());
    user.setEmail(basicDataUser.getEmail());
    user.setPhone(basicDataUser.getPhone());
    user.setSex(basicDataUser.getSex());

    return user;

  }

  /**
   *  Recupera o usuário a partir do seu id.
   * @param id - id do usuário.
   * @return
   */
  public BasicDataUser get(Long id) {

    return from(userService.get(id));

  }

  /**
   * Recupera todos os usuários.
   * @return
   */
  public List<BasicDataUser> getAll() {

    return from(userService.getAll());

  }

  /**
   * Exclui o usuário do banco.
   * @param id - id do usuário.
   */
  public void delete(Long id) {

    userService.delete(id);

  }

  /**
   * Atualiza ou cria o usuário no banco.
   * @param basicDataUser - objeto que representa o usuário.
   * @return
   */
  public BasicDataUser persist(BasicDataUser basicDataUser) {

    return from(userService.persist(to(basicDataUser)));
  }

}
