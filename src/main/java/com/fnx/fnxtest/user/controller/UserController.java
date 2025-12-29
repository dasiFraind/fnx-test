package com.fnx.fnxtest.user.controller;

import com.fnx.fnxtest.user.dto.User;
import com.fnx.fnxtest.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<User> register(@RequestParam String id,
                         @RequestParam String name,
                         @RequestParam String password) {

        return new ResponseEntity<User>(userService.save(new User(id, name, password)), HttpStatus.OK);
    }

    @GetMapping("/login")
    public ResponseEntity<User> login(@RequestParam String id,
                      @RequestParam String password) {

        return new ResponseEntity<User>(userService.findByIdAndPassword(id, password), HttpStatus.OK);
    }
}

