package com.tka.smartbazaar.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tka.smartbazaar.dao.UserDao;
import com.tka.smartbazaar.entity.User;
import com.tka.smartbazaar.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao dao;

    public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public User create(User u) {
        dao.save(u);
        return u;
    }

    @Override
    public User getById(Long id) {
        return dao.getById(id.intValue());
    }

    @Override
    public List<User> listAll() {
        return dao.getAll();
    }
    
    @Override
    public User findByEmail(String email) {
        return dao.findByEmail(email);
    }

}
