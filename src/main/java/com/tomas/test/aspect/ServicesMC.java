package com.tomas.test.aspect;

import com.tomas.test.entity.ResponseTO;
import com.tomas.test.utils.exception.MessageException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServicesMC
{
    private static Logger logger = LoggerFactory.getLogger(ServicesMC.class);

    @Around("@annotation(com.tomas.test.aspect.annotation.ServiceMC)")
    public Object aroundApect(ProceedingJoinPoint proceedingJoinPoint)
    {
        String messageOk = "Ok", message500 = "Error Inesperado";
        logger.info("Time Init :: {}", System.currentTimeMillis());
        ResponseTO response = new ResponseTO();
        try
        {
            response = ResponseTO.class.cast(proceedingJoinPoint.proceed());
            response.setEstatus(0);
        }catch (MessageException ex)
        {
            response.setEstatus(ex.getCodeError().getCodigoError());
        }catch (Throwable throwable)
        {
            response.setEstatus(-1);
        }
        logger.info("Time end :: {}", System.currentTimeMillis());
        return response;
    }

}
