package com.manuelsenatore.gestionedispositivi.gestionedispositivi.repositories;

import com.manuelsenatore.gestionedispositivi.gestionedispositivi.entities.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DispositivoRepository extends JpaRepository<Dispositivo, Long> {

}
