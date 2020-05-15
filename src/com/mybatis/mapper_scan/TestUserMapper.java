package com.mybatis.mapper_scan;

import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author XueYing.Cao
 * @date 2020/5/14
 */
public interface TestUserMapper {

    @Select("select * from t_user")
    List<TestUser> getUsers();
}
