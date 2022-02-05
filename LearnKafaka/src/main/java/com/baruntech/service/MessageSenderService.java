package com.baruntech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.baruntech.model.User;

@Service
public class MessageSenderService {
	
	@Value("${topic.name}")
	private String TOPIC;
	
	@Autowired
	private KafkaTemplate<String, User>kafkaTemplate;
	
	public void sendMessags(User user) {
		kafkaTemplate.send(TOPIC, user);
	}

}
