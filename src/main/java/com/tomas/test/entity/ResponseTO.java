package com.tomas.test.entity;

import org.springframework.data.annotation.Transient;

public class ResponseTO
{
    @Transient
    private int estatus;
    @Transient
    private String message;

    public int getEstatus()
    {
        return estatus;
    }

    public void setEstatus(int estatus)
    {
        this.estatus = estatus;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}
