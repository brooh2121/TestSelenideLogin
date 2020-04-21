package com.SelenideLoginTest.com.SelenideLoginTest.dao;


import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;


public interface LoginDao {

   boolean LoginLogInsert(int loginLogId,String login, LocalDateTime loginDate);

   int LoginIDSequance();

}
