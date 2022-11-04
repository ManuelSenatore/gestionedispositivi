package com.manuelsenatore.gestionedispositivi.gestionedispositivi.repositories;

import com.manuelsenatore.gestionedispositivi.gestionedispositivi.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
