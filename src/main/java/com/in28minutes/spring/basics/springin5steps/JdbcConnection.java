package com.in28minutes.spring.basics.springin5steps;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class JdbcConnection {

    public JdbcConnection() {
        System.out.println(String.format("JdbcConnection: %s", this.hashCode()));
    }
}

/*
    Without the additional `proxyMode = ScopedProxyMode.TARGET_CLASS`, personDao would get autowired with only one instance of JdbcConnection
    And even though JdbcConnection class has Prototype scope, we will only have one instance to work with.

    But, with `proxyMode = ScopedProxyMode.TARGET_CLASS`, each personDao.getJdbcConnection() method would trigger a new JdbcConnection
    as evident from the hashCode values printed in logs

 */