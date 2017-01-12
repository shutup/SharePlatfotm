package com.shutup.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Tom on 1/11/17.
 */
@Entity
public class Role implements GrantedAuthority{
    private String roleName;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @OneToMany(targetEntity = SystemUser.class, cascade = CascadeType.ALL)
//    @JoinTable(name = "system_user_role",
//            joinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "system_user_id",referencedColumnName = "id")})
//    private Collection<SystemUser> systemUsers;
    @ManyToMany(mappedBy = "roles")
    private Collection<SystemUser> systemUsers;

    protected Role(){}

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getAuthority() {
        return roleName;
    }
}
