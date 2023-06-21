package com.webzworldtask.service.impl;

import com.webzworldtask.entity.User;
import com.webzworldtask.exception.ResourceNotFoundException;
import com.webzworldtask.repository.UserRepository;
import com.webzworldtask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public User createUser(User user) {
        User user1=this.userRepo.save(user);
        return user1;
    }

    @Override
    public User updateUser(User user, Long id) {
        User user1=userRepo.findById(id).orElseThrow(
                ()->  new ResourceNotFoundException("UserId Not Found with", "id", id)
        );
        user1.setId(user.getId());
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        User updateUser=userRepo.save(user1);
        return updateUser;
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public User getOneUser(Long id) {
        User user1=userRepo.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("UserId Not Found with","Id",id)
        );
        return user1;
    }

    @Override
    public void deleteUser(Long id) {
        User user1=userRepo.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("UserId Not Found with", "id", id)
        );
        userRepo.delete(user1);
    }
}
