package com.in28minutes.spring.basics.springin5steps;

import compscan.SomeDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.in28minutes.spring.basics.springin5steps", "compscan"})
public class SpringIn5StepsApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext =
                SpringApplication.run(SpringIn5StepsApplication.class, args);

        PersonDao pd1 = applicationContext.getBean(PersonDao.class);
        PersonDao pd2 = applicationContext.getBean(PersonDao.class);

        System.out.println(String.format("Person: %s, JdbcConn: %s", pd1, pd1.getJdbcConnection()));
        System.out.println(String.format("Person: %s, JdbcConn: %s", pd2, pd2.getJdbcConnection()));

        SomeDao sd = applicationContext.getBean(SomeDao.class);
        System.out.println(sd.getJdbcConnection().hashCode());
    }
}

/*
To use `SomeDao` , we need to specify it's package, as it resides outside the package in which SpringIn5StepsApplication resides
But if we specify just "compscan", then it wont scan the home package (which is taken by default) of "com.in28minutes.spring.basics.springin5steps"
Thus we need to specify both: "com.in28minutes.spring.basics.springin5steps" and "compscan"
 */