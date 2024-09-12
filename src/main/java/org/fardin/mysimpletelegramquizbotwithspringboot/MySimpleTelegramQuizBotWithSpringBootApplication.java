package org.fardin.mysimpletelegramquizbotwithspringboot;

import org.fardin.mysimpletelegramquizbotwithspringboot.telegrambot.TelegramBot;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class MySimpleTelegramQuizBotWithSpringBootApplication{

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(MySimpleTelegramQuizBotWithSpringBootApplication.class, args);
	}


}
