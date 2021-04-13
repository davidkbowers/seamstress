package com.bowerstechnologies.seamstress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication 
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.bowerstechnologies.seamstress"})
@EnableJpaRepositories(basePackages="com.bowerstechnologies.seamstress.repositories")
@EnableTransactionManagement
@EntityScan(basePackages="com.bowerstechnologies.seamstress.entities")
public class SeamstressApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeamstressApplication.class, args);
    }
    
}

