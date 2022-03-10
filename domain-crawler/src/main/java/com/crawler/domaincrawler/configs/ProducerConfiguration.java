package com.crawler.domaincrawler.configs;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

import com.crawler.domaincrawler.constants.KafkaConstants;
import com.crawler.domaincrawler.models.Domain;

@Configuration
public class ProducerConfiguration {

  @Bean
  public KafkaTemplate<String, Domain> kafkaTemplate() {
    return new KafkaTemplate<>(producerFactory());
  }

  @Bean
  public ProducerFactory<String, Domain> producerFactory() {
    Map<String, Object> configs = new HashMap<>();
    configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.KAFKA_BROKER);
    configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
    // configs.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);
    configs.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);
    // configs.put(JsonSerializer.TRUSTED_PACKAGES, "*");
    return new DefaultKafkaProducerFactory<>(configs);
  }
}