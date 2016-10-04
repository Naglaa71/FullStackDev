package com.fullstackdev.backend.persistence.domain.backend;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by nagla on 10/4/2016.
 */
public class Authority implements GrantedAuthority {
    private final String authority;

    public Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
