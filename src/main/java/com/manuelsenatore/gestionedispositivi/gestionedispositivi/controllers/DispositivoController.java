package com.manuelsenatore.gestionedispositivi.gestionedispositivi.controllers;

import com.manuelsenatore.gestionedispositivi.gestionedispositivi.entities.Dispositivo;
import com.manuelsenatore.gestionedispositivi.gestionedispositivi.entities.Stato;
import com.manuelsenatore.gestionedispositivi.gestionedispositivi.entities.User;
import com.manuelsenatore.gestionedispositivi.gestionedispositivi.services.DispositivoService;
import com.manuelsenatore.gestionedispositivi.gestionedispositivi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/app")
public class DispositivoController {
    @Autowired
    UserService us;

    @Autowired
    DispositivoService ds;

    @GetMapping("/add-dispositivo")
    @PreAuthorize("hasRole('ADMIN')")
    public Dispositivo addDispositivo(
            @RequestParam("tipologia") String tipologia,
            @RequestParam("stato") Stato stato,
            @RequestParam(name="user_id", required = false) Long user_id
    ){
        if(user_id != null){
            Optional<User> u = us.getById(user_id);

            if(u.isPresent()){
                Dispositivo d = Dispositivo.builder()
                        .tipologia(tipologia)
                        .stato(stato)
                        .user(u.get())
                        .build();
                ds.addDispositivo(d);
                return d;
            }
        }
        Dispositivo d = Dispositivo.builder()
                .tipologia(tipologia)
                .stato(stato)
                .build();
        ds.addDispositivo(d);
        return d;

    }
}
