package com.tomas.test;

import com.tomas.test.entity.CodigosMessage;
import com.tomas.test.entity.MessageResponse;
import com.tomas.test.respository.MessageRepository;
import com.tomas.test.utils.Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@DataMongoTest
@RunWith(SpringRunner.class)
@SpringJUnitConfig(App.class)
public class CodigoResponseTest
{
    private Logger logger = LoggerFactory.getLogger(CodigoResponseTest.class);

    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void buscar_api_codigo_error()
    {
        MessageResponse message = this.messageRepository.findByApi("ApiUsuarios");
        logger.info("data:: {}",Util.objectJson(message));
        Assert.notNull(message, "No es nullo");
    }
}

