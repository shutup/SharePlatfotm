package com.shutup.repo;

import com.shutup.model.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Tom on 1/11/17.
 */
public interface SystemUserRepo extends JpaRepository<SystemUser,Long> {
    SystemUser findByUsername(String username);
}
