package com.tomas.test.controller;

import com.tomas.test.entity.Usuarios;
import com.tomas.test.services.UsuarioServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "Usuarios Rest Controller", tags = {"API USUARIOS"})
@RequestMapping("/v1/")
public class UsuarioRestController
{
    private static final Logger logger = LoggerFactory.getLogger(UsuarioRestController.class);
    @Autowired
    private UsuarioServices usuarioServices;

    @ApiOperation(value = "", response = Usuarios.class,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            tags = {"API USUARIOS"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Error del servidor")})
    @GetMapping(value= "usuarios",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserById(@RequestParam(value = "id") String id)
    {
        logger.info("Controller");
        return new ResponseEntity<>(this.usuarioServices.getUsuariosById(id), HttpStatus.OK);
    }
}
