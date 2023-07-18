package br.com.duarte.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "permission")
@Data
public class Permission implements GrantedAuthority, Serializable {
    @Serial
    private static final long serialVersionUID = -6491131592662625774L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String description;

    @Override
    public String getAuthority() {
        return this.description;
    }
}
