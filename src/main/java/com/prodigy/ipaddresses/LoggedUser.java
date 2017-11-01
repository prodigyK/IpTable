package com.prodigy.ipaddresses;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class LoggedUser {

    private Integer id;

    private String name;

    public static String getName(){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }
}
