package com.webzworldtask.service;

import com.webzworldtask.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User updateUser(User user,Long id);

    List<User> getAll();

    User getOneUser(Long id);

    void deleteUser(Long id);
}
