package com.tomas.test.utils;

public enum CodigosRespuesta
{
    ERROR_EN_LA_OPERACION(-1, "Error en la operacion"),
    OPERACION_EXITOSA(0, "Operacion exitosa"),
    ERROR_GENERICO(1,"Error generico");

    private int codigoError;
    private String message;

    CodigosRespuesta(int codigoError, String message)
    {
        this.codigoError = codigoError;
        this.message = message;
    }

    public int getCodigoError()
    {
        return codigoError;
    }

    public String getMessage()
    {
        return message;
    }
}
