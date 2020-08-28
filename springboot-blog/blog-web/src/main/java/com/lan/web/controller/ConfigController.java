package com.lan.web.controller;

import com.lan.domain.Menu;
import com.lan.domain.User;
import com.lan.service.MenuService;
import com.lan.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 这是一个只要登录就能访问的Controller
 * 主要用来获取一些配置信息
 */
@RestController
@RequestMapping("/config")
public class ConfigController {
    @Autowired
    MenuService menuService;

    @RequestMapping("/sysmenu")
    public List<Menu> sysmenu() {
        return menuService.getMenusByUserId();
    }

    @RequestMapping("/user")
    public User currentUser() {
        return UserUtils.getCurrentUser();
    }
}
