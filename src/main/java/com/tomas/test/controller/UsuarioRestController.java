package com.tomas.test.controller;

import com.tomas.test.entity.Usuarios;
import com.tomas.test.services.UsuarioServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
=======
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
>>>>>>> 7c0dc2044d8e59a4fcc810caf76a3ae9760be9c4

@CrossOrigin
@RestController
@Api(value = "Usuarios Rest Controller", tags = {"API USUARIOS"})
@RequestMapping(value = "/v1/usuarios")
public class UsuarioRestController
{
    @Autowired
    private UsuarioServices usuarioServices;

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "", response = Usuarios.class,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            tags = {"API USUARIOS"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Error del servidor")})
    @GetMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Usuarios getUserById(@RequestParam(value = "id") String id)
    {
        return this.usuarioServices.getUsuariosById(id);
    }
}
