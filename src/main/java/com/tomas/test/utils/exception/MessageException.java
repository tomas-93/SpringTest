package com.tomas.test.utils.exception;

import org.springframework.http.HttpStatus;

public class MessageException extends Exception
{
    private HttpStatus estatus;
    private int codeError;

    public MessageException(int codeError)
    {
        this.codeError = codeError;
    }
    public MessageException(HttpStatus estatus, int codeError)
    {
        this.estatus = estatus;
        this.codeError = codeError;
    }

    public HttpStatus getEstatus()
    {
        return estatus;
    }

    public int getCodeError()
    {
        return codeError;
    }
}
