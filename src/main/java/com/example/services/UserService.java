package com.example.services;

import com.example.models.UserTable;
import com.example.repository.UserRepository;
import jakarta.inject.Singleton;
import java.util.List;
import java.util.Optional;

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


    // update user ✅
    public UserTable updateUser(int id, UserTable user) {
        UserTable prevUser = getUser(id);
        prevUser.setFirstName(user.getFirstName());
        prevUser.setEmail(user.getEmail());

        return userRepository.update(prevUser);
    }

    //delete user ✅
    public void deleteUser(int id) {
        UserTable User = userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
            userRepository.delete(User);
    }

}
