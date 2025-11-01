package com.tka.smartbazaar.service;

import java.util.List;

import com.tka.smartbazaar.entity.User;

public interface UserService {
    User create(User u);
    User getById(Long id);
    List<User> listAll();
}
