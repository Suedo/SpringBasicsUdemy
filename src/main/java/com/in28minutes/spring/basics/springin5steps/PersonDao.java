package com.in28minutes.spring.basics.springin5steps;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter @Setter
@Component
public class PersonDao {
    @Autowired
    JdbcConnection jdbcConnection;
}
