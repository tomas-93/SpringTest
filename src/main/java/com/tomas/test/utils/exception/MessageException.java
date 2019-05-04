package com.tomas.test.utils.exception;

import com.tomas.test.utils.CodigosRespuesta;
import org.springframework.http.HttpStatus;

public class MessageException extends RuntimeException
{
    private HttpStatus estatus;
    private CodigosRespuesta codeError;

    public MessageException(CodigosRespuesta codeError)
    {
        this.codeError = codeError;
    }
    public MessageException(HttpStatus estatus, CodigosRespuesta codeError)
    {
        this.estatus = estatus;
        this.codeError = codeError;
    }

    public HttpStatus getEstatus()
    {
        return estatus;
    }

    public CodigosRespuesta getCodeError()
    {
        return codeError;
    }
}
