package com.mybatis.mapper_scan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author XueYing.Cao
 * @date 2020/5/14
 */
@Service
public class TestService {


    @Autowired
    private TestUserMapper testUserMapper;

    public List<TestUser> getUsers() {
        return testUserMapper.getUsers();
    }
}
