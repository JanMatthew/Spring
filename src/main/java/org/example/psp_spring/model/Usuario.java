package org.example.psp_spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.processing.Generated;

@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    @Column(nullable = false)
    private String foto;
    //Ruta al archivo

    @ManyToOne
    @JoinColumn(name = "departamentos", nullable = false)
    private Departamento departamento;


}
