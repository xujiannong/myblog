package com.lan.utils;

import com.lan.domain.User;
import org.springframework.security.core.context.SecurityContextHolder;


public class UserUtils {
    public static User getCurrentHr() {
        return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
