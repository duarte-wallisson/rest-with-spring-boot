package br.com.duarte.data.dto.v1.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;

@Data @EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class AccountCredentialsDTO extends RepresentationModel<AccountCredentialsDTO> implements Serializable {
    @Serial
    private static final long serialVersionUID = -6491131592662625774L;

    private String username;
    private String password;

}
