package com.shutup.repo;

import com.shutup.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Tom on 1/11/17.
 */
public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findByRole_Name(String roleName);
}
