package com.SelenideLoginTest.com.SelenideLoginTest;

import com.SelenideLoginTest.com.SelenideLoginTest.service.LoginService;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import static com.codeborne.selenide.Selenide.*;


@SpringBootApplication
public class Application implements CommandLineRunner {

	int count = 0;

	@Autowired
	LoginService loginService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		loginService.openPage();
		for(;;) {
			if(count  == 60) {
				count = call(count);
				closeWebDriver();
				loginService.openPage();
			}
			count++;
			loginService.getLoginToWebSite();
			Thread.sleep(1000);
		}
	}

	private static int call(int count) {
		count = 0;
		return count;
	}
}
