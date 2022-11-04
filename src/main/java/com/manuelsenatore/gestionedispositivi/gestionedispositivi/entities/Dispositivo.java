package com.manuelsenatore.gestionedispositivi.gestionedispositivi.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "dispositivi")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder

public class Dispositivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String tipologia;
    @Enumerated(EnumType.STRING)
    private Stato stato;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;




}
