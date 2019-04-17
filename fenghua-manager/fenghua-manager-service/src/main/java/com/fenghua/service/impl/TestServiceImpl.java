package com.fenghua.service.impl;

import com.fenghua.mapper.TestMapper;
import com.fenghua.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    public String queryNow() {
        //1:注入mapper
        //2:调用mapper并返回
        return testMapper.queryNow();
    }
}
