package br.com.duarte.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "book")
@Data
public class Book implements Serializable {
    @Serial
    private static final long serialVersionUID = -6491131592662625774L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String author;

    @Column(name = "launch_date", nullable = false, length = 40)
    private String launchDate;

    @Column(precision = 65, scale = 2, nullable = false)
    private Double price;

    @Column(length = 100)
    private String title;

}
