package org.learnspringboot.users.repository;

import org.learnspringboot.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
