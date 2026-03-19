package com.grupo3.bibliotecavirtual.model.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class Usuario extends BaseEntity {


    private String email;

    private String password;

    @OneToOne(cascade = CascadeType.ALL) // Si guardo usuario, se guarda perfil
    @JoinColumn(name = "perfil_id", referencedColumnName = "id")
    private Perfil perfil;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rol_id")
    @JsonBackReference
    private Rol rol;

}
