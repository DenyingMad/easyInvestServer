package com.cgpanda.EasyInvestServer.repository;

import com.cgpanda.EasyInvestServer.entity.Users.ApiKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiRepository extends JpaRepository<ApiKey, Long> {
}
