package com.javaprograma.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "horarios_ambiente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HorarioAmbiente {

    @Id
    private Long codigo;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private LocalTime horaInicio;

    @Column(nullable = false)
    private LocalTime horaFin;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ambiente_id", nullable = false, unique = true)
    private Ambiente ambiente;
}
