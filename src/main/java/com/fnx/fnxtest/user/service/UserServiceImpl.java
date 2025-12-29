package com.fnx.fnxtest.user.service;

import com.fnx.fnxtest.exception.AppException;
import com.fnx.fnxtest.exception.enums.ErrorCode;
import com.fnx.fnxtest.user.dto.User;
import com.fnx.fnxtest.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User findByIdAndPassword(String userId, String password) {
        User user = userRepository.findById(userId);
        if (user != null && password.equals(user.getPassword())) {
            return user;
        }
        throw new AppException(ErrorCode.USER_NOT_FOUND);
    }

    @Override
    public User save(User user) {
        if (userRepository.findById(user.getId()) == null) {
            return userRepository.save(user);
        }
        throw new AppException(ErrorCode.USER_ALREADY_EXISTS);
    }
}
