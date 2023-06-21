package com.webzworldtask.controller;

import com.webzworldtask.entity.User;
import com.webzworldtask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    //http://localhost:8080/api/registration
    @PostMapping("/registration")
    public ResponseEntity<String> saveAllUser(@Valid @RequestBody User user){
        userService.createUser(user);
        return new ResponseEntity<>("User save Successfully", HttpStatus.CREATED);
    }

    //http://localhost:8080/api/getAll
    @GetMapping("/getAll")
    public List<User> getAllUserController(){
        List<User> user1=userService.getAll();
        return user1;
    }

    //http://localhost:8080/api/user/id
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        User user=userService.getOneUser(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    //http://localhost:8080/api/update/id
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateAllUser(@Valid @RequestBody User user,@PathVariable("id") Long id){
        User user1=userService.updateUser(user,id);
        return new ResponseEntity<>(user1,HttpStatus.ACCEPTED);
    }

    //http://localhost:8080/api/delete/id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOneUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>("User delete successfully",HttpStatus.OK);
    }

}
