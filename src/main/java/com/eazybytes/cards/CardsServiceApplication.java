package com.eazybytes.cards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableJpaRepositories("com.eazybytes.cards.repository")
@EntityScan({ "com.eazybytes.cards.entity" })
public class CardsServiceApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(CardsServiceApplication.class, args);
    }

}
