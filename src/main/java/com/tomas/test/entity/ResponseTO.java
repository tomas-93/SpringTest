package com.tomas.test.entity;

import lombok.Data;
import org.springframework.data.annotation.Transient;
import org.springframework.http.HttpStatus;

@Data
public class ResponseTO
{
    @Transient
    private int codigoRespuesta;
    @Transient
    private int codigoHttp;
    @Transient
    private String mensaje;
    @Transient
    private HttpStatus httpStatus;
    @Transient
    private String folio;
}
