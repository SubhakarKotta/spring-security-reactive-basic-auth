package com.security.reactive.basic.auth;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.security.reactive.basic.auth.common.Role;
import com.security.reactive.basic.auth.dataaccess.User;

public class UserBuilder {

	private UUID id = UUID.randomUUID();

	private String email = "john.doe@example.com";

	private String password = "secret";

	private String firstName = "John";

	private String lastName = "Doe";

	private List<Role> roles = new ArrayList<>();

	private UserBuilder() {
		roles.add(Role.ADMIN_USER);
	}

	public static UserBuilder user() {
		return new UserBuilder();
	}

	public UserBuilder withId(UUID id) {
		this.id = id;
		return this;
	}

	public UserBuilder withEmail(String email) {
		this.email = email;
		return this;
	}

	public UserBuilder withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public UserBuilder withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public UserBuilder withRoles(List<Role> roles) {
		this.roles = roles;
		return this;
	}

	public UserBuilder withPassword(String password) {
		this.password = password;
		return this;
	}

	public User build() {
		return new User(this.id, this.email, this.password, this.firstName, this.lastName, this.roles);
	}
}
