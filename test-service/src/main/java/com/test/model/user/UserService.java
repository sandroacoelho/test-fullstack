package com.test.model.user;

import java.util.List;

import com.test.model.domain.user.User;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
class UserService {

  private final UserRepository userRepository;

  public User get(Long id) {

    return userRepository.findOne(id);

  }

  public List<User> getAll() {

    return userRepository.findAll();

  }

  public void delete(Long id) {

    userRepository.delete(id);

  }

  public User persist(User user) {

    return userRepository.save(user);
  }

}
