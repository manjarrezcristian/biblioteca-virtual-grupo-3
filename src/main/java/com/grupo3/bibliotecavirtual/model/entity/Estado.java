package com.grupo3.bibliotecavirtual.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "estado")
@Getter
@Setter
public class Estado extends BaseEntity {

    private String detalle;

    // Un estado tiene muchos libros
    @OneToMany(mappedBy = "estado")
    private List<Libro> libros;
}