package com.javaprograma.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ambientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ambiente {

    @Id
    private Long codigo;

    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "ambiente")
    private Set<ProgramaFormacion> programasFormacion = new HashSet<>();

    @OneToOne(mappedBy = "ambiente")
    private HorarioAmbiente horarioAmbiente;
}
