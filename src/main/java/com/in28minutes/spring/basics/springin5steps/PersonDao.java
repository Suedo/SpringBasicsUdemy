package com.in28minutes.spring.basics.springin5steps;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Getter @Setter @Log4j2
@Component
public class PersonDao {
    @Autowired
    JdbcConnection jdbcConnection;

    @PostConstruct
    public void postConstruct() {
        log.info(">> This is logged just after PersonDao is created. #beanlifecyle");
    }

    @PreDestroy
    public void preDestroy() {
        log.info(">> This is logged just before PersonDao is removed. #beanlifecyle");
    }
}
