package com.afiefafian.userservice.controller;

import com.afiefafian.userservice.VO.ResponseTemplateVo;
import com.afiefafian.userservice.entity.User;
import com.afiefafian.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("inside of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVo getUserWithDepartment(@PathVariable("id") Long userId) {
        return userService.getUserWithDepartment(userId);
    }
}
