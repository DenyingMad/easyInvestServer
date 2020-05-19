package com.cgpanda.EasyInvestServer.repository;

import com.cgpanda.EasyInvestServer.entity.Users.ApiKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ApiRepository extends JpaRepository<ApiKey, Long> {

    @Modifying
    @Transactional
    @Query("update ApiKey a set a.apiKey = ?2 where a.id = ?1")
    void updateApiKey(@Param("id") Long id, @Param("api") String newApi);

    Optional<ApiKey> findByApiKey(String apiKey);
}
