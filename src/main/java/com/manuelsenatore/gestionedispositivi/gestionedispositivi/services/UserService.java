package com.manuelsenatore.gestionedispositivi.gestionedispositivi.services;

import com.manuelsenatore.gestionedispositivi.gestionedispositivi.entities.User;
import com.manuelsenatore.gestionedispositivi.gestionedispositivi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository ur;

    public Iterable<User> getAll() {
        return ur.findAll();
    }

    public void addUser(User u) {
        ur.save(u);
    }

    public Optional<User> getById(Long id) {
        return ur.findById(id);
    }

    public void deleteById(Long id) {
        ur.deleteById(id);
    }

    public Optional<User> getByName(String u){
        return ur.findByUsername(u);
    }
}
