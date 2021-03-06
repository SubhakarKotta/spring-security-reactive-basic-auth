package com.security.reactive.basic.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.reactive.basic.auth.dataaccess.User;
import com.security.reactive.basic.auth.dataaccess.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Mono<User> findOneByEmail(String email) {
		return userRepository.findOneByEmail(email);
	}

	public Mono<Void> create(Mono<User> user) {
		return userRepository.insert(user).then();
	}

	public Mono<User> update(User user) {
		return userRepository.save(user);
	}

	public Mono<User> findById(UUID uuid) {
		return userRepository.findById(uuid);
	}

	public Flux<User> findAll() {
		return userRepository.findAll();
	}

	public Mono<Void> deleteById(UUID uuid) {
		return userRepository.deleteById(uuid);
	}
}
