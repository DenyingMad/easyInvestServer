package com.cgpanda.EasyInvestServer.repository;

import com.cgpanda.EasyInvestServer.entity.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String email);
}
