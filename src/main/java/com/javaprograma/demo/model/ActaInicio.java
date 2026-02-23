package com.javaprograma.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "actas_inicio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActaInicio {

    @Id
    private Long codigo;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private String descripcion;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contrato_id", nullable = false, unique = true)
    private Contrato contrato;
}
