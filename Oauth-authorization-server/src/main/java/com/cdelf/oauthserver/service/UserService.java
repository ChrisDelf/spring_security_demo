package com.cdelf.oauthserver.service;

import com.cdelf.oauthserver.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    public User addUser(User user);
    public List<User> getAllUser();
    public User getUserById(long id);
    public void deleteUser(long id);
    public User updateUser(long id, User user);

    public UserDetails findByUserName(String username);

}