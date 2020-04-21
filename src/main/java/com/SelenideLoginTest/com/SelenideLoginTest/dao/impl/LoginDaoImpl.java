package com.SelenideLoginTest.com.SelenideLoginTest.dao.impl;

import com.SelenideLoginTest.com.SelenideLoginTest.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class LoginDaoImpl implements LoginDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public boolean LoginLogInsert(int loginLogId, String login, LocalDateTime loginDate) {
        String query="insert into public.login_log values ('"+loginLogId+"','"+login+"','"+loginDate+"')";
        int result = jdbcTemplate.update(query);
        if (result == 0) {
        return false;
        }
        return true;
    }

    @Override
    public int LoginIDSequance() {
        String query="select nextval('log_id_seq')";
        return jdbcTemplate.queryForObject(query,Integer.class);
    }
}
