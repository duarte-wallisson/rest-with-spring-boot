package br.com.duarte.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "person")
@Data
public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = -6491131592662625774L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 40)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 40)
    private String lastName;

    @Column(length = 20)
    private String gender;

    @Column(length = 100)
    private String address;

}
