package br.com.duarte.data.vo.v2;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class PersonDTOV2 implements Serializable {
    @Serial
    private static final long serialVersionUID = -6491131592662625774L;

    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String address;
    private String birthday;

}
