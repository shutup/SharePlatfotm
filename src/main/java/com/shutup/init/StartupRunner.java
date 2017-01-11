package com.shutup.init;

import com.shutup.common.Constants;
import com.shutup.model.Role;
import com.shutup.model.SystemUser;
import com.shutup.repo.RoleRepo;
import com.shutup.repo.SystemUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom on 1/11/17.
 */
public class StartupRunner implements CommandLineRunner , Constants{
    @Autowired
    RoleRepo roleRepo;
    @Autowired
    SystemUserRepo userRepo;

    @Override
    public void run(String... args) throws Exception {
        Role adminRole = new Role(Role_Administrator);
        roleRepo.save(adminRole);
        Role ownerRole = new Role(Role_Club_Owner);
        roleRepo.save(ownerRole);
        Role salesRole = new Role(Role_SalesMan);
        roleRepo.save(salesRole);

        List<Role> roleList = new ArrayList<>();
        Role aRole = roleRepo.findByRole_Name(Role_Administrator);

        SystemUser admin = new SystemUser("admin","password",roleList);
        userRepo.save(admin);

        roleList.clear();
        Role oRole = roleRepo.findByRole_Name(Role_Club_Owner);
        roleList.add(oRole);

        SystemUser owner = new SystemUser("club","club",roleList);
        userRepo.save(owner);
    }
}
