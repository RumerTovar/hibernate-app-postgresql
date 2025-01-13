package com.posgre.posgredbapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Dueño {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    Long id_dueño;
    Long dni;
    String nombre;
    String apellido;
    int celular;
    @OneToOne
    @JoinColumn(name = "id_mascota",
    referencedColumnName = "id_mascota")
    Mascota mascota;

    public Dueño() {
    }

    public Dueño(Long id_dueño, Long dni, String nombre, String apellido, int celular, Mascota mascota) {
        this.id_dueño = id_dueño;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.mascota = mascota;
    }
}
