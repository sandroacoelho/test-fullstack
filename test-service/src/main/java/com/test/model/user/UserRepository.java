package com.test.model.user;

import com.test.model.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
}
