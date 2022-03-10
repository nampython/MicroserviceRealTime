package com.service.domainservice.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

import com.service.domainservice.models.Domain;

import org.apache.kafka.streams.kstream.KStream;



@Configuration
public class DomainKStreamConfig {

    @Bean
    public Consumer<KStream<String, Domain>> domainService(){
        return kstream -> kstream.foreach( (key, domain) -> {
            System.out.println(String.format("Domain consumed [%s] Status[%s]", domain.getDomain(), domain.isDead()));
        });
    }
}
