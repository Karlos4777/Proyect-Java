package com.javaprograma.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "instructores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Instructor {

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

    @Column(nullable = false)
    private String direccion;

    @OneToOne(mappedBy = "instructor")
    private Horario horario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "centro_id", nullable = false)
    private Centro centro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contrato_id", nullable = false)
    private Contrato contrato;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_contrato_id", nullable = false)
    private TipoContrato tipoContrato;

    @ManyToMany
    @JoinTable(
            name = "instructor_programa",
            joinColumns = @JoinColumn(name = "instructor_id"),
            inverseJoinColumns = @JoinColumn(name = "programa_id")
    )
    private Set<ProgramaFormacion> programasFormacion = new HashSet<>();
}
