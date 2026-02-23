package com.javaprograma.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "centros")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Centro {

    @Id
    private Long codigo;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String direccion;

    @OneToMany(mappedBy = "centro")
    private Set<Instructor> instructores = new HashSet<>();
}
