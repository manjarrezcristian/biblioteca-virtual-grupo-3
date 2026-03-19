package com.grupo3.bibliotecavirtual.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autores")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Autor extends BaseEntity {

    @Column(nullable = false, length = 120)
    private String nombre;

    // Relación 1 (Autor) -> N (Libro)
    // mappedBy apunta al nombre del atributo en Libro que referencia a Autor
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Libro> libros = new ArrayList<>();

    // Timestamps (requerimiento)
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;


}