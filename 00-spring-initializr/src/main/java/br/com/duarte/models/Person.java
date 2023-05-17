package br.com.duarte.models;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = -6491131592662625774L;

    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;
}