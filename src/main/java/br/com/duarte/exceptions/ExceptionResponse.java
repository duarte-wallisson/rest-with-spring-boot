package br.com.duarte.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Builder
@AllArgsConstructor
public class ExceptionResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = 4710755493591316137L;

    @Getter @Setter
    private Date timestamp;
    @Getter @Setter
    private String message;
    @Getter @Setter
    private String details;

}
