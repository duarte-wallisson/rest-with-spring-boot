package br.com.duarte.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@JsonPropertyOrder({"id", "address", "first_name", "last_name", "gender"})
@Data
public class PersonDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -6491131592662625774L;

    private Long id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonIgnore
    private String gender;

    private String address;

}
