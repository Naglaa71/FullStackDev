package com.fullstackdev;

import com.fullstackdev.backend.persistence.domain.backend.Role;
import com.fullstackdev.backend.persistence.domain.backend.User;
import com.fullstackdev.backend.persistence.domain.backend.UserRole;
import com.fullstackdev.backend.service.UserService;
import com.fullstackdev.enums.PlansEnum;
import com.fullstackdev.enums.RolesEnum;
import com.fullstackdev.utils.UsersUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class FullStackDevApplication implements CommandLineRunner{

	// The application logger
	private static final Logger LOG = LoggerFactory.getLogger(FullStackDevApplication.class);
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(FullStackDevApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		Set<UserRole> userRoles = new HashSet<>();
		User user = UsersUtils.createBasicUser();
		userRoles.add(new UserRole(user,new Role(RolesEnum.BASIC)));
		LOG.debug("Creating a user with user name {}", user.getUsername());
		userService.createUser(user, PlansEnum.PRO,userRoles);
		LOG.info("User Created {}", user.getUsername());
	}
}
