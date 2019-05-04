package com.tomas.test.entity;

import org.springframework.data.annotation.Transient;
import org.springframework.http.HttpStatus;

public class ResponseTO<T>
{
    @Transient
    private int estatus;
    @Transient
    private String mensaje;
    @Transient
    private T body;
    @Transient
    private HttpStatus httpStatus;


    public int getEstatus()
    {
        return estatus;
    }

    public void setEstatus(int estatus)
    {
        this.estatus = estatus;
    }

    public String getMensaje()
    {
        return mensaje;
    }

    public void setMensaje(String mensaje)
    {
        this.mensaje = mensaje;
    }

    public T getBody()
    {
        return body;
    }

    public void setBody(T body)
    {
        this.body = body;
    }

    public HttpStatus getHttpStatus()
    {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus)
    {
        this.httpStatus = httpStatus;
    }
}
