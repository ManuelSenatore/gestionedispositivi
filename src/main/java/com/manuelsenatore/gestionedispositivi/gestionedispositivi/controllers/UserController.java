package com.manuelsenatore.gestionedispositivi.gestionedispositivi.controllers;

import com.manuelsenatore.gestionedispositivi.gestionedispositivi.entities.Role;
import com.manuelsenatore.gestionedispositivi.gestionedispositivi.entities.RoleType;
import com.manuelsenatore.gestionedispositivi.gestionedispositivi.entities.User;
import com.manuelsenatore.gestionedispositivi.gestionedispositivi.services.DispositivoService;
import com.manuelsenatore.gestionedispositivi.gestionedispositivi.services.RoleService;
import com.manuelsenatore.gestionedispositivi.gestionedispositivi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/app")
public class UserController {

    @Autowired
    UserService us;

    @Autowired
    DispositivoService ds;

    @Autowired
    RoleService rs;


    @GetMapping("/add-user")
    public String addUser(
            @RequestParam("name") String name,
            @RequestParam("lastName") String lastName,
            @RequestParam("password") String password,
            @RequestParam("email") String email,
            @RequestParam("username") String username
    ) {
        User user = new User();
        user.setFirstName(name);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        Set<Role> roles = new HashSet<Role>();
        Role admin = rs.getById(2).get();
        roles.add(admin);
        user.setRoles(roles);

        us.addUser(user);

        return "User added";
    }

    @GetMapping("/add-roles")
    public String addRoles() {
        Role roleAdmin = new Role();
        roleAdmin.setRoleType(RoleType.ROLE_ADMIN);
        rs.addRole(roleAdmin);

        Role roleUser = new Role();
        roleUser.setRoleType(RoleType.ROLE_USER);
        rs.addRole(roleUser);

        return "Roles added";
    }
}
