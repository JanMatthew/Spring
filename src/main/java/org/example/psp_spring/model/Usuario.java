package org.example.psp_spring.model;

import jakarta.persistence.*;
import lombok.Data;

import javax.annotation.processing.Generated;

@Data
@Entity(name = "usuarios")
public class Usuario extends TimeStampedPersistableObject{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @ManyToOne
    @JoinColumn(name = "departamentos", nullable = false)
    private Departamento departamento;


}
