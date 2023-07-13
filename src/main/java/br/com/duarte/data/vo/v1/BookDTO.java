package br.com.duarte.data.vo.v1;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;

@Data @EqualsAndHashCode(callSuper = true)
public class BookDTO extends RepresentationModel<BookDTO> implements Serializable {
    @Serial
    private static final long serialVersionUID = -6491131592662625774L;

    private Long id;
    private String author;
    private String launchDate;
    private Double price;
    private String title;

}
