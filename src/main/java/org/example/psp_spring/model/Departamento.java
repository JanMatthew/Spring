package org.example.psp_spring.model;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name="departamentos")
public class Departamento extends TimeStampedPersistableObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descripcion;


}
