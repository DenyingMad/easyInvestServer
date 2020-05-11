package com.cgpanda.EasyInvestServer.repository;

import com.cgpanda.EasyInvestServer.entity.Users.ApiKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiRepository extends JpaRepository<ApiKey, Long> {

    @Query("update ApiKey a set a.apiKey = :newApi where a.id = :id")
    void updateApiKey(@Param("id") Long id, @Param("newApi") String newApi);
}
