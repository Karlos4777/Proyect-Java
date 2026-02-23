package com.javaprograma.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "programas_formacion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProgramaFormacion {

    @Id
    private Long codigo;

    @Column(nullable = false)
    private String nombre;

    @ManyToMany(mappedBy = "programasFormacion")
    private Set<Instructor> instructores = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "programa_competencia",
            joinColumns = @JoinColumn(name = "programa_id"),
            inverseJoinColumns = @JoinColumn(name = "competencia_id")
    )
    private Set<Competencia> competencias = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ambiente_id", nullable = false)
    private Ambiente ambiente;

    @OneToMany(mappedBy = "programaFormacion")
    private Set<Aprendiz> aprendices = new HashSet<>();
}
