package com.fnx.fnxtest.user.service;

import com.fnx.fnxtest.user.dto.User;

public interface UserService {
    User findByIdAndPassword(String userId, String password);
    User save(User user);
}
