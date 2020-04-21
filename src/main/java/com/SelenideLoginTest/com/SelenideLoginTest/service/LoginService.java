package com.SelenideLoginTest.com.SelenideLoginTest.service;


import com.SelenideLoginTest.com.SelenideLoginTest.dao.LoginDao;
import com.codeborne.selenide.SelenideElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

@Service
public class LoginService {

    @Autowired
    LoginDao loginDao;

    private String username = "Dismas";
    private String password = "123qweASD";

    @Autowired
    Environment environment;

    public void openPage() {
        System.setProperty("selenide.browser","Firefox");
        open("http://18.225.33.158/");
    }

    public void getLoginToWebSite() throws InterruptedException{
        SelenideElement selenideElement = element(byId("navbarSupportedContent"));
        String loginName = selenideElement.find(byXpath("div[contains(@class,'navbar-text mr-3')]")).text();
        if(loginName.equals("unknown")) {
            selenideElement.find("form").find("button").click();
            SelenideElement loginContainer = element(byXpath("//div[contains(@class,'container mt-5')]"));
            if(loginContainer.toString().contains("Зарегистрироваться")) {
                SelenideElement loginField = loginContainer.find(byName("username")).setValue(username);
                System.out.println(loginField.toString());
                SelenideElement passField = loginContainer.find(byName("password")).setValue(password);
                System.out.println(passField.toString());
                loginContainer.find("button").click();
                System.out.println("Запишем в БД время входа в ЛК");
                loginDao.LoginLogInsert(loginDao.LoginIDSequance(),username,LocalDateTime.now());
            }else {
                System.out.println("А мы уже залогинились");
            }
        }else {
            System.out.println("Раз залогинились - будем манипулировать");
        }
    }
}
