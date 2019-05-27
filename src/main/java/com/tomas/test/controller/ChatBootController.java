package com.tomas.test.controller;

import com.tomas.test.aspect.annotation.Algoritmo;
import com.tomas.test.aspect.annotation.Cifrado;
import com.tomas.test.entity.ChatBoot;
import com.tomas.test.entity.ResponseTO;
import com.tomas.test.entity.Usuarios;
import com.tomas.test.utils.Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "Chat boot", tags = {"API CHAT BOOT"})
@RequestMapping(value = "chat/boot/")
public class ChatBootController
{
    private static final Logger logger = LoggerFactory.getLogger(ChatBootController.class);
    @ApiOperation(value = "", response = ResponseTO.class,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            tags = {"API CHAT BOOT"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Error del servidor")})
    @PostMapping(value= "messages",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void getUserById(@RequestBody ChatBoot chatBoot)
    {
        chatBoot.getMessage();
        ChatBoot chatBoot1 = new ChatBoot();
        chatBoot1.getMessage();
    }
}
