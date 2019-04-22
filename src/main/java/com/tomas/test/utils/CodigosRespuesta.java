package com.tomas.test.utils;

public enum CodigosRespuesta
{
    ERROR_GENERICO(1,"Error generico");

    private int estatus;
    private String message;

    CodigosRespuesta(int estatus, String message)
    {
        this.estatus = estatus;
        this.message = message;
    }

    public int getEstatus()
    {
        return estatus;
    }

    public String getMessage()
    {
        return message;
    }
}
