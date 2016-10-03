package com.fullstackdev.test.integration;

import com.fullstackdev.FullStackDevApplication;
import com.fullstackdev.backend.persistence.domain.backend.Plan;
import com.fullstackdev.backend.persistence.domain.backend.Role;
import com.fullstackdev.backend.persistence.domain.backend.User;
import com.fullstackdev.backend.persistence.domain.backend.UserRole;
import com.fullstackdev.backend.persistence.repositories.PlanRepository;
import com.fullstackdev.backend.persistence.repositories.RoleRepository;
import com.fullstackdev.backend.persistence.repositories.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nagla on 9/28/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FullStackDevApplication.class)
public class RepositoryIntegrationTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PlanRepository planRepository;

    private static final int BASIC_PLAN_ID = 1;
    private static final int BASIC_ROLE_ID = 1;
    private static final long BASIC_USER_ID = 1;

    @Before
    public void init() {
        Assert.assertNotNull(userRepository);
        Assert.assertNotNull(roleRepository);
        Assert.assertNotNull(planRepository);
    }

    @Test
    public void testCreateNewPlan() throws Exception {

        Plan basicPlan = createBasicPlan();
        planRepository.save(basicPlan);
        Plan retrievedPlan = planRepository.findOne(BASIC_PLAN_ID);
        Assert.assertNotNull(retrievedPlan);
    }

    public Plan createBasicPlan() {
        Plan plan = new Plan();
        plan.setId(BASIC_PLAN_ID);
        plan.setName("Basic Plan");
        return plan;
    }

    @Test
    public void testCreateNewRole() throws Exception {

        Role basicRole = createBasicRole();
        roleRepository.save(basicRole);
        Role retrievedRole = roleRepository.findOne(BASIC_ROLE_ID);
        Assert.assertNotNull(retrievedRole);
    }

    public Role createBasicRole() {
        Role role = new Role();
        role.setId(BASIC_ROLE_ID);
        role.setName("User_Role");
        return role;
    }

    @Test
    public void testCreateNewUser() throws Exception {

        Plan basicPlan = createBasicPlan();
        planRepository.save(basicPlan);

        User basicUser = createBasicUser();
        basicUser.setPlan(basicPlan);

        Role basicRole = createBasicRole();
        Set<UserRole> userRoles = new HashSet<>();
        UserRole userRole = new UserRole();
        userRole.setRole(basicRole);
        userRole.setUser(basicUser);
        userRoles.add(userRole);

        basicUser.getUserRoles().addAll(userRoles);

        for (UserRole ur : userRoles) {
            roleRepository.save(ur.getRole());
        }

        basicUser = userRepository.save(basicUser);
        User newlyCreatedUser = userRepository.findOne(basicUser.getId());
        Assert.assertNotNull(newlyCreatedUser);
        Assert.assertTrue(newlyCreatedUser.getId() != 0);
        Assert.assertNotNull(newlyCreatedUser.getPlan());
        Assert.assertNotNull(newlyCreatedUser.getPlan().getId());
        Set<UserRole> newlyCreatedUserRoles = newlyCreatedUser.getUserRoles();
        for (UserRole ur : newlyCreatedUserRoles) {
            Assert.assertNotNull(ur.getRole());
            Assert.assertNotNull(ur.getRole().getId());
        }
    }

    public User createBasicUser() {
        User user = new User();
        user.setUsername("Basic User");
        user.setFirstName("Naglaa");
        user.setLastName("Awad");
        user.setPhoneNumber("5715240356");
        user.setEmail("naglaaawad71@gmail.com");
        user.setCountry("USA");
        user.setDescription("Resposible for registering customers data");
        user.setPassword("secretword");
        user.setEnabled(true);
        return user;
    }
}
