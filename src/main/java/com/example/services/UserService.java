package com.example.services;

import com.example.models.UserTable;
import com.example.repository.UserRepository;
import jakarta.inject.Singleton;
import java.util.List;

@Singleton
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    // post one user ✅
    public UserTable createUser(UserTable userTable) {
        return userRepository.save(userTable);
    }

    // post users from dummy API


    // get one user


    // get users ✅
    public List<UserTable> getAllUsers() {
        return userRepository.findAll();
    }

    // update user


    //delete user


}
