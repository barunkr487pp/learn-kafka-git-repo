package com.baruntech.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.baruntech.model.User;

@Configuration
public class KafkaProducerCionfig {
	
	@Value("${bootstrap_servers_config}")
	private List<String> BOOTSTRAP_SERVERS_CONFIG;
	
	@Bean
	public ProducerFactory<String,User> producerConfig() {
		
		Map<String, Object> map=new HashMap<>();
		map.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS_CONFIG.get(0));
		map.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		map.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		
		return new DefaultKafkaProducerFactory<>(map);
	}

	@Bean
	public KafkaTemplate<String, User> createTemplate(){
		return new KafkaTemplate<>(producerConfig());
		
	}
}
