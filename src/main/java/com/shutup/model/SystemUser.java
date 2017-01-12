package com.shutup.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Tom on 1/11/17.
 */
@Entity
public class SystemUser {
    private String username;
    private String password;
//    @OneToMany(targetEntity = Role.class, cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    @JoinTable(name = "system_user_role",
//            joinColumns = {@JoinColumn(name = "system_user_id",referencedColumnName = "id")},
//    inverseJoinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "id")})
//    private Collection<Role> roles = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "system_user_role",
            joinColumns = {@JoinColumn(name = "system_user_id",referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "id")})
    private Collection<Role> roles = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    protected SystemUser() {
    }

    public SystemUser(String username, String password) {
        this.username = username;
        this.password = password;
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

    public Collection<Role> getRoles() {
        return roles;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }
    public void addRoles(List<Role> roles) {
        this.roles.addAll(roles);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
