package br.com.duarte.data.dto.v1;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;

@Data @EqualsAndHashCode(callSuper = true)
public class PersonDTO extends RepresentationModel<PersonDTO> implements Serializable {
    @Serial
    private static final long serialVersionUID = -6491131592662625774L;

    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String address;

}
