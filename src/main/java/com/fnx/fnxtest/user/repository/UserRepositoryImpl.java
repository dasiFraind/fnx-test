package com.fnx.fnxtest.user.repository;

import com.fnx.fnxtest.user.dto.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final Map<String, User> users = new HashMap<>();

    public UserRepositoryImpl() {
        users.put("user1", new User("user1", "michal", "pass1"));
        users.put("user2", new User("user2", "yael", "pass2"));
        users.put("user3", new User("user3", "noam", "pass3"));
    }

    @Override
    public User findById(String id) {
        return users.get(id);
    }

    @Override
    public User save(User user) {
        users.put(user.getId(), user);
        return user;
    }
}

