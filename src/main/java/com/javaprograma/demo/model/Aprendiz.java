package com.javaprograma.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "aprendices")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aprendiz {

    @Id
    @Column(length = 20)
    private String cedula;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String telefono;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "programa_id", nullable = false)
    private ProgramaFormacion programaFormacion;

    @ManyToMany
    @JoinTable(
            name = "aprendiz_curso_complementario",
            joinColumns = @JoinColumn(name = "aprendiz_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private Set<CursoComplementario> cursosComplementarios = new HashSet<>();
}
