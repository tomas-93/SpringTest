package com.tomas.test.aspect;

import com.tomas.test.aspect.annotation.Cifrado;
import com.tomas.test.utils.Util;
import jdk.nashorn.internal.ir.JoinPredecessor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;

@Aspect
@Component
public class CifradoAspect
{
    private static final Logger logger = LoggerFactory.getLogger(CifradoAspect.class);

    @Around("execution(* *.*(..)) && @annotation(org.springframework.web.bind.annotation.PostMapping)")
    public Object aspectDecifrado(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
    {
        Object objectArgs[] = proceedingJoinPoint.getArgs();
        Arrays.asList(objectArgs)
                .forEach(object ->{
                    logger.info(Util.objectJson(object));
                    logger.info(object.getClass().getName());
                    logger.info(Util.objectJson(object.getClass().getFields()));
                    if(object.getClass().isAnnotationPresent(Cifrado.class)){
                        logger.info("Cifrado presente");
                    }

                    Arrays.asList(object.getClass().getFields())
                            .forEach(field -> {
                                logger.info(field.getName());
                            });
                });
        return new Object();
    }
}
