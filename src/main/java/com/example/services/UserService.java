package com.example.services;

import com.example.models.UserTable;
import com.example.repository.UserRepository;
import jakarta.inject.Singleton;
import java.util.List;
import com.example.exception.UserNotFoundException;
@Singleton
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    

    // get users ✅
    public List<UserTable> getAllUsers() {
        return userRepository.findAll();
    }

    // get one user ✅
    public UserTable getUser(int id) {
        return userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }

    // post one user ✅
    public UserTable createUser(UserTable userTable) {
        return userRepository.save(userTable);
    }


    // update user


    //delete user


}
