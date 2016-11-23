package com.ctsig.test.service.jdbc.impl;

import com.ctsig.test.service.jdbc.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @version： V1.0.0
 * @des：
 * @author: Shen
 * @email: shenzhaoxiang@gmail.com
 * @date: 2016/11/19
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    @Override
    public void create(String name, Integer age) {
        jdbcTemplate.update("insert into USER(NAME, AGE) values(?, ?)", name, age);
    }
    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("delete from USER where NAME = ?", name);
    }
    @Override
    public Integer getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from USER", Integer.class);
    }
    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("delete from USER");
    }
}
