package br.com.duarte.integrantiontests.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

@Data @EqualsAndHashCode()
public class PersonDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -6491131592662625774L;

    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String address;

}
