package com.how2do.subsciption.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = { "com.how2do.subsciption" })
@EnableScheduling
public class SubscriptionMangementApplication 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(SubscriptionMangementApplication.class, args);
    }
}
