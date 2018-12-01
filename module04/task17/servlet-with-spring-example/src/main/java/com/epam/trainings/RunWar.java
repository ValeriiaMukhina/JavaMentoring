package com.epam.trainings;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;

public class RunWar {
    public static void main(String[] args) throws ServletException, LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir("temp");
        tomcat.setPort(8090);

        String contextPath = "/";
        String warFilePath = "/Users/valeriia/Documents/Valeriia/GitLab/JavaMentoring/module04/task17/servlet-with-spring-example/target/servlet-with-spring.war";

        tomcat.getHost().setAppBase(".");

        tomcat.addWebapp(contextPath, warFilePath);

        tomcat.start();
        tomcat.getServer().await();
    }
}
