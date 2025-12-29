package com.fnx.fnxtest.user.repository;

import com.fnx.fnxtest.user.dto.User;

public interface UserRepository {
    User findById(String id);
    User save(User user);
}
