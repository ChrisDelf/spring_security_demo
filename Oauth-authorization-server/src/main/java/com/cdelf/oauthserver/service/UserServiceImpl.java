package com.cdelf.oauthserver.service;

import com.cdelf.oauthserver.Repository.UserRepository;
import com.cdelf.oauthserver.entity.User;
import com.cdelf.oauthserver.exceptions.ResourceFoundException;
import com.cdelf.oauthserver.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;


    @Override
    public User addUser(User user) {

        if (userRepo.findByusername(user.getUsername()) != null) {
            throw new ResourceFoundException(user.getUsername() + "is already taken!");
        }


        User newUser = new User(user.getUsername(), user.getPassword());
        newUser.setPassword(user.getPassword());

        return userRepo.save(newUser);
    }

    @Override
    public List<User> getAllUser() {
        List<User> list = new ArrayList<>();
        userRepo.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Transactional
    @Override
    public User getUserById(long id) throws ResourceNotFoundException {
        return Optional.ofNullable(userRepo.findById(id))
                .orElseThrow(() -> new ResourceNotFoundException("User id " + id + "not found!"));

    }

    @Transactional
    @Override
    public void deleteUser(long id) {
        Optional.ofNullable(userRepo.findById(id))
                .orElseThrow(() -> new ResourceNotFoundException("User id " + id + "not found!"));
        userRepo.deleteById(id);
    }

    @Transactional
    @Override
    public User updateUser(long id, User user) {
        User currentUser = userRepo.findById(id);
        if (id == currentUser.getId()) {
            if (user.getUsername() != null) {
                currentUser.setUsername(user.getUsername());
            }

            if (user.getPassword() != null) {
                currentUser.setPassword(user.getPassword());
            }

            return userRepo.save(currentUser);
        } else {
            throw new ResourceNotFoundException(id + " Not current user");
        }

    }
}
