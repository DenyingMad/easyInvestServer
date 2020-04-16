package com.cgpanda.EasyInvestServer.service;

import com.cgpanda.EasyInvestServer.entity.Equity;
import com.cgpanda.EasyInvestServer.repository.EquityRepository;
import com.cgpanda.EasyInvestServer.repository.StoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EquityServiceImpl implements EquityService {

    @Autowired
    private EquityRepository repository;

    @Override
    public List<Equity> getAll() {
        return repository.findAll();
    }
}
