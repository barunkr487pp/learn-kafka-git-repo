package com.baruntech.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.baruntech.model.User;

@Service
public class MessageReciverService {
	
	@KafkaListener(topics = "${topic.name}",groupId = "${group.id}")
	public void receiveMsg(User user) {
		System.out.println(user.toString());
	}

}
