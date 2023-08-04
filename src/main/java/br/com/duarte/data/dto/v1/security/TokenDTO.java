package br.com.duarte.data.dto.v1.security;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data @EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class TokenDTO extends RepresentationModel<TokenDTO> implements Serializable {
    @Serial
    private static final long serialVersionUID = -6491131592662625774L;

    private String username;
    private Boolean authenticated;
    private Date created;
    private Date expiration;
    private String accessToken;
    private String refreshToken;

}
