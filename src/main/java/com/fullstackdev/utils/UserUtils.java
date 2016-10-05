package com.fullstackdev.utils;

import com.fullstackdev.backend.persistence.domain.backend.User;

/**
 * Created by nagla on 10/3/2016.
 */
public class UserUtils {

    private UserUtils() {
        throw new AssertionError("Not Instantiable!!!");
    }

    public static User createBasicUser(String username , String email) {
        User user = new User();
        user.setUsername(username);
        user.setFirstName("Naglaa");
        user.setLastName("Awad");
        user.setPhoneNumber("5715240356");
        user.setEmail(email);
        user.setCountry("USA");
        user.setDescription("Resposible for registering customers data");
        user.setPassword("secret");
        user.setEnabled(true);
        return user;
    }
}
