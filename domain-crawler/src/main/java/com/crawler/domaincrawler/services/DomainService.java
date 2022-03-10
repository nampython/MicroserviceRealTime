package com.crawler.domaincrawler.services;

import com.crawler.domaincrawler.models.Domain;
import com.crawler.domaincrawler.models.DomainList;

import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class DomainService {

  private KafkaTemplate<String, Domain> kafkaTemplate;
  private final String KAFKA_TOPIC = "web-domains";

  public DomainService(KafkaTemplate<String, Domain> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void crawl(String name) {

    Mono<DomainList> domainListMono = WebClient.create()
        .get()
        .uri("https://api.domainsdb.info/v1/domains/search?domain=" + name)
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .bodyToMono(DomainList.class);


    domainListMono.subscribe(domainList -> {
      domainList.domains
          .forEach(domain -> {
            kafkaTemplate.send(KAFKA_TOPIC, domain);
            System.out.println("Domain message" + domain.getDomain());
          });
    });

  }
}
