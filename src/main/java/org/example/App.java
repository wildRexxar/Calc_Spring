package org.example;

import org.example.configuration.RootConfiguration;
import org.example.controller.AccountMenuController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main( String[] args ){
        ApplicationContext context = new AnnotationConfigApplicationContext(RootConfiguration.class);
        AccountMenuController application = (AccountMenuController) context.getBean("accountMenuController");
        application.run();
    }
}