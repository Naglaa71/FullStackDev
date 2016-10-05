package com.fullstackdev.test.integration;

import com.fullstackdev.FullStackDevApplication;
import com.fullstackdev.backend.persistence.domain.backend.Role;
import com.fullstackdev.backend.persistence.domain.backend.User;
import com.fullstackdev.backend.persistence.domain.backend.UserRole;
import com.fullstackdev.backend.service.UserService;
import com.fullstackdev.enums.PlansEnum;
import com.fullstackdev.enums.RolesEnum;
import com.fullstackdev.utils.UserUtils;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nagla on 10/3/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FullStackDevApplication.class)
public class UserServiceIntegrationTest {
    @Rule public TestName testName = new TestName();
    @Autowired
    private UserService userService;

    @Test
    public void createNewUser() throws Exception {
        Set<UserRole> userRoles = new HashSet<>();
        String username = testName.getMethodName();
        String email = testName.getMethodName() + "@devops.com";

        User basicUser = UserUtils.createBasicUser(username,email);
        userRoles.add(new UserRole(basicUser,new Role(RolesEnum.BASIC)));

        User user = userService.createUser(basicUser,PlansEnum.BASIC,userRoles);
        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getId());
    }
}
