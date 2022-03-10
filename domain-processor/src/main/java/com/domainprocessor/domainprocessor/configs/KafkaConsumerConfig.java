// package com.domainprocessor.domainprocessor.configs;

// import java.util.HashMap;
// import java.util.Map;

// import com.domainprocessor.domainprocessor.models.Domain;

// import org.apache.kafka.clients.consumer.ConsumerConfig;
// import org.apache.kafka.common.serialization.StringDeserializer;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.kafka.annotation.EnableKafka;
// import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
// import org.springframework.kafka.core.ConsumerFactory;
// import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
// import org.springframework.kafka.support.serializer.JsonDeserializer;

// @EnableKafka
// @Configuration
// public class KafkaConsumerConfig {
//     @Bean
// 	public ConsumerFactory<String, String> consumingEventStringMessage() {
// 		Map<String, Object> configMap = new HashMap<>();
// 		configMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
// 		configMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
// 		configMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
// 		// configMap.put(ConsumerConfig.GROUP_ID_CONFIG, ApplicationConstant.GROUP_ID_STRING);
//         configMap.put(JsonDeserializer.TRUSTED_PACKAGES, "com.crawler.domaincrawler.models.Domain");
//         configMap.put(JsonDeserializer.USE_TYPE_INFO_HEADERS,false);
// 		return new DefaultKafkaConsumerFactory<>(configMap);
// 	}

// 	@Bean
// 	public ConcurrentKafkaListenerContainerFactory<String, String> listenerEventSendStringMessage() {
// 		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<String, String>();
// 		factory.setConsumerFactory(consumingEventStringMessage());
// 		return factory;
//     }
// }