package com.manuelsenatore.gestionedispositivi.gestionedispositivi.services;

import com.manuelsenatore.gestionedispositivi.gestionedispositivi.entities.Dispositivo;
import com.manuelsenatore.gestionedispositivi.gestionedispositivi.entities.User;
import com.manuelsenatore.gestionedispositivi.gestionedispositivi.repositories.DispositivoRepository;
import com.manuelsenatore.gestionedispositivi.gestionedispositivi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DispositivoService {

    @Autowired
    DispositivoRepository dr;

    public Iterable<Dispositivo> getAll() {
        return dr.findAll();
    }
    public void addDispositivo(Dispositivo d) {
        dr.save(d);
    }
    public Optional<Dispositivo> getById(Long id) {
        return dr.findById(id);
    }
    public void deleteById(Long id) {
        dr.deleteById(id);
    }
}
