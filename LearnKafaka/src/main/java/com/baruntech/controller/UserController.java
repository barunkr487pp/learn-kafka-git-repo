package com.baruntech.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baruntech.model.User;

@RestController
@RequestMapping("kafka")
public class UserController {
	
	private static List<User>users=new ArrayList<>();
	private static int id=0;
	
	@Autowired
	private KafkaTemplate<String, User>kafkaTemplate;
	
	private final String TOPIC="FIRST_TOPIC";
	
	@GetMapping("/USERS")
	public List<User> fetchAll() {
		
	    return users;
	}
	
	@PostMapping("/USERS/")
	public String create(@RequestBody User user) {
		users.add(user);
		kafkaTemplate.send(TOPIC,user);
	    return "message sent successfully!";	
	}
	
	@GetMapping("/USERS/{id}")
	public User fetch(@PathVariable("id")final Long id) {
		Optional<User>user=users.stream().filter(u->u.getId()==id).findAny();
	    return user.get();
	}
	
	
	
	
	@DeleteMapping("/USERS/{id}")
	public void remove(@PathVariable("id")final Long id) {
		ListIterator<User>itrIterator=users.listIterator();
		while (itrIterator.hasNext()) {
			if(itrIterator.next().getId()==id)
			itrIterator.remove();
		}
	   
	}
	

}
