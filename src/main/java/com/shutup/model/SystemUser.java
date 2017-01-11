package com.shutup.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Tom on 1/11/17.
 */
@Entity
public class SystemUser {
    private String username;
    private String password;
    @OneToMany(targetEntity = Role.class, cascade = CascadeType.ALL)
    private List<Role> roles;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    protected SystemUser() {
    }

    public SystemUser(String username, String password, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
