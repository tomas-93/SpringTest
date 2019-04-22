package com.tomas.test.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Util
{
    static Logger logger = LoggerFactory.getLogger(Util.class);
    public static <T> T jsonObject(String json, T clazz)
    {
        T object = null;
        try
        {
            object = (T) new ObjectMapper().readValue(json, clazz.getClass());

        } catch (IOException e)
        {
            logger.error("Message ::: {}",e);
        }
        return object;
    }

    public static <T>String objectJson(T object)
    {
        String json = "";
        try
        {
            ObjectMapper mapper = new ObjectMapper();
            json = mapper.writeValueAsString(object);

        } catch (JsonProcessingException e)
        {
            logger.error("Message :: {}",e);

        }
        return json;
    }
}
