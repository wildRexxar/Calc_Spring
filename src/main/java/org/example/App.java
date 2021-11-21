package org.example;

import org.example.configuration.RootConfiguration;
import org.example.controller.CalcController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main( String[] args ){
        ApplicationContext context = new AnnotationConfigApplicationContext(RootConfiguration.class);
        CalcController application = (CalcController) context.getBean("calcController");
        application.run();
    }
}
