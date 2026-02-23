package com.javaprograma.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contratos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contrato {

    @Id
    private Long codigo;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal valor;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private String tipo;

    @OneToOne(mappedBy = "contrato")
    private ActaInicio actaInicio;

    @OneToMany(mappedBy = "contrato")
    private Set<Instructor> instructores = new HashSet<>();
}
