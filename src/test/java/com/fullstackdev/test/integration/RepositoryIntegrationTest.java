package com.fullstackdev.test.integration;

import com.fullstackdev.FullStackDevApplication;
import com.fullstackdev.backend.persistence.domain.backend.Plan;
import com.fullstackdev.backend.persistence.domain.backend.Role;
import com.fullstackdev.backend.persistence.domain.backend.User;
import com.fullstackdev.backend.persistence.domain.backend.UserRole;
import com.fullstackdev.backend.persistence.repositories.PlanRepository;
import com.fullstackdev.backend.persistence.repositories.RoleRepository;
import com.fullstackdev.backend.persistence.repositories.UserRepository;
import com.fullstackdev.enums.PlansEnum;
import com.fullstackdev.enums.RolesEnum;
import com.fullstackdev.utils.UsersUtils;
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

    private static final long BASIC_USER_ID = 1;

    @Before
    public void init() {
        Assert.assertNotNull(userRepository);
        Assert.assertNotNull(roleRepository);
        Assert.assertNotNull(planRepository);
    }

    @Test
    public void testCreateNewPlan() throws Exception {

        Plan basicPlan = createBasicPlan(PlansEnum.BASIC);
        planRepository.save(basicPlan);
        Plan retrievedPlan = planRepository.findOne(PlansEnum.BASIC.getId());
        Assert.assertNotNull(retrievedPlan);
    }

    public Plan createBasicPlan(PlansEnum plansEnum) {
        return new Plan(plansEnum);
    }

    @Test
    public void testCreateNewRole() throws Exception {

        Role basicRole = createBasicRole(RolesEnum.BASIC);
        roleRepository.save(basicRole);
        Role retrievedRole = roleRepository.findOne(RolesEnum.BASIC.getId());
        Assert.assertNotNull(retrievedRole);
    }

    public Role createBasicRole(RolesEnum rolesEnum) {
        return new Role(rolesEnum);
    }

    @Test
    public void testCreateNewUser() throws Exception {

        Plan basicPlan = createBasicPlan(PlansEnum.BASIC);
        planRepository.save(basicPlan);

        User basicUser = UsersUtils.createBasicUser();
        basicUser.setPlan(basicPlan);

        Role basicRole = createBasicRole(RolesEnum.BASIC);
        Set<UserRole> userRoles = new HashSet<>();
        UserRole userRole = new UserRole(basicUser,basicRole);
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



}
