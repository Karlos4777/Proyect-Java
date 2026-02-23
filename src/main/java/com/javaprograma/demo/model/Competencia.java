package com.javaprograma.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "competencias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Competencia {

    @Id
    private Long codigo;

    @Column(nullable = false)
    private String nombre;

    @ManyToMany(mappedBy = "competencias")
    private Set<ProgramaFormacion> programasFormacion = new HashSet<>();
}
