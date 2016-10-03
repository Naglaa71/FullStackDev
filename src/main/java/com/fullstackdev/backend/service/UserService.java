package com.fullstackdev.backend.service;

import com.fullstackdev.backend.persistence.domain.backend.Plan;
import com.fullstackdev.backend.persistence.domain.backend.User;
import com.fullstackdev.backend.persistence.domain.backend.UserRole;
import com.fullstackdev.backend.persistence.repositories.PlanRepository;
import com.fullstackdev.backend.persistence.repositories.RoleRepository;
import com.fullstackdev.backend.persistence.repositories.UserRepository;
import com.fullstackdev.enums.PlansEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by nagla on 10/3/2016.
 */
@Service
@Transactional(readOnly = true)
public class UserService {
    @Autowired
    private PlanRepository planRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User createUser(User user, PlansEnum plansEnum , Set<UserRole> userRoles) {
        Plan plan = new Plan(plansEnum);
        if (!planRepository.exists(plansEnum.getId())) {
            planRepository.save(plan);
        }
        user.setPlan(plan);
        for (UserRole ur : userRoles) {
            roleRepository.save(ur.getRole());
        }
        user.getUserRoles().addAll(userRoles);
        user = userRepository.save(user);

        return user;
    }



}
