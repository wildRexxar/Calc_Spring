package org.example.console;

import org.example.configuration.RootConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(RootConfiguration.class);
        Application application = (Application) context.getBean("application");
        application.run();
    }
}