package com.tomas.test.config;

import com.tomas.test.entity.ResponseTO;
import com.tomas.test.utils.exception.MessageException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControladorErrores
{
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseTO> controlarException(Exception ex, WebRequest webRequest)
    {
        return null;
    }

    @ExceptionHandler(MessageException.class)
    public ResponseEntity<ResponseTO> controlarMessageEx(MessageException mEx, WebRequest webRequest)
    {
        return null;
    }
}
