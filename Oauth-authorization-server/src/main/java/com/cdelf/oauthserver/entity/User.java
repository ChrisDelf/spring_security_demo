package com.cdelf.oauthserver.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(nullable = false,
            unique = true)
    private String username;

    @Column(nullable = true)
    private String email;

    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

//    @OneToMany(mappedBy = "user",
//            cascade = CascadeType.ALL)
//    @JsonIgnore
//    private List<UserRoles> user_roles = new ArrayList<>();


    public User() {
    }

//    public User(String username, String password, List<UserRoles> userRoles)

    public User(String username, String password) {
        setUsername(username);
        setPassword(password);
//        for (UserRoles ur : userRoles)
//        {
//            ur.setUser(this);
//        }
//        this.user_roles = userRoles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public List<UserRoles> getUser_roles() {
//        return user_roles;
//    }
//
//    public void setUser_roles(List<UserRoles> user_roles) {
//        this.user_roles = user_roles;
//    }

    public long getId() {
        return id;
    }

}

