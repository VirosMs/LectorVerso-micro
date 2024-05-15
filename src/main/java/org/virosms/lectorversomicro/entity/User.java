package org.virosms.lectorversomicro.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "usuarios")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre" ,unique = true)
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "contrasena")
    private String password;

    @CreationTimestamp
    @Column(name = "fecha_registro")
    private LocalDateTime registrationDate;
}
