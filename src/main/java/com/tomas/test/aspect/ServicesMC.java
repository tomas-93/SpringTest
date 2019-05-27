package com.tomas.test.aspect;

import com.tomas.test.aspect.annotation.ServiceMC;
import com.tomas.test.entity.CodigosMessage;
import com.tomas.test.entity.MessageResponse;
import com.tomas.test.entity.ResponseTO;
import com.tomas.test.respository.MessageRepository;
import com.tomas.test.utils.Util;
import com.tomas.test.utils.exception.MessageException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Optional;


@Aspect
@Component
public class ServicesMC
{
    private static Logger logger = LoggerFactory.getLogger(ServicesMC.class);

    @Autowired
    private MessageRepository messageRepository;

    @Around("@annotation(com.tomas.test.aspect.annotation.ServiceMC)")
    public Object aroundApect(ProceedingJoinPoint proceedingJoinPoint)
    {
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        ServiceMC serviceMC =  method.getAnnotation(ServiceMC.class);
        ResponseTO response = new ResponseTO();
        try
        {
            logger.info("Time Init :: {}", System.currentTimeMillis());
            logger.info("API::{}",serviceMC.value());
            response = ResponseTO.class.cast(proceedingJoinPoint.proceed());
            response = this.llenarResponseOK(response, serviceMC.value().name());

        }catch (MessageException ex)
        {
           response = this.llenarCodigoMessageEx(ex,response, serviceMC.value().name());
        }catch (Throwable throwable)
        {
            response = this.llenarResponseError(response, serviceMC.value().name());
        }
        logger.info("Time end :: {}", System.currentTimeMillis());
        return response;
    }

    private CodigosMessage getCodigoMessage(String api, int code)
    {
        MessageResponse response = this.messageRepository.findByApi(api);
        Optional<CodigosMessage> optCodigo = response.getCodigosMessageList()
                .stream()
                .filter(p -> p.getCodigo() == code)
                .findFirst();

        if(optCodigo.isPresent())
            return optCodigo.get();
        else {
            CodigosMessage codigosMessage = new CodigosMessage();
            codigosMessage.setCodigo(-1);
            codigosMessage.setMessage("Error en la operacion");
            return codigosMessage;
        }
    }

    private ResponseTO llenarCodigoMessageEx(MessageException ex, ResponseTO response, String api)
    {
        CodigosMessage codigosMessage = this.getCodigoMessage("", ex.getCodeError().getCodigoError());
        response.setCodigoHttp(ex.getEstatus().value());
        response.setHttpStatus(ex.getEstatus());
        response.setFolio(Util.getTimeServer());
        response.setMensaje(codigosMessage.getMessage());
        return response;
    }

    private ResponseTO llenarResponseError(ResponseTO response, String api)
    {
        CodigosMessage codigosMessage = getCodigoMessage(api, 1);
        response.setCodigoHttp(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        response.setMensaje(codigosMessage.getMessage());
        response.setFolio(Util.getTimeServer());
        response.setCodigoRespuesta(codigosMessage.getCodigo());
        return response;
    }
    private ResponseTO llenarResponseOK(ResponseTO response, String api)
    {
        CodigosMessage codigosMessage = getCodigoMessage(api, 0);
        response.setCodigoHttp(HttpStatus.OK.value());
        response.setHttpStatus(HttpStatus.OK);
        response.setMensaje(codigosMessage.getMessage());
        response.setFolio(Util.getTimeServer());
        response.setCodigoRespuesta(codigosMessage.getCodigo());
        return response;
    }


}
