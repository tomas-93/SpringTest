/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.tomas.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableAspectJAutoProxy
@EnableMongoRepositories
@SpringBootApplication(scanBasePackages = "com.tomas.test")
public class App
{
    public static void main(String[] args)
    {
        SpringApplication.run(App.class, args);
    }

}
