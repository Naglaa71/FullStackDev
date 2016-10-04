package com.fullstackdev.utils;

import com.fullstackdev.backend.persistence.domain.backend.User;

/**
 * Created by nagla on 10/3/2016.
 */
public class UserUtils {

    private UserUtils() {
        throw new AssertionError("Not Instantiable!!!");
    }

    public static User createBasicUser() {
        User user = new User();
        user.setUsername("basicuser");
        user.setFirstName("Naglaa");
        user.setLastName("Awad");
        user.setPhoneNumber("5715240356");
        user.setEmail("naglaaawad71@gmail.com");
        user.setCountry("USA");
        user.setDescription("Resposible for registering customers data");
        user.setPassword("secret");
        user.setEnabled(true);
        return user;
    }
}
