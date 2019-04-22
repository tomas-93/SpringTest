package com.tomas.test.controller;

import com.tomas.test.entity.Usuarios;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@Api("suarioRestController")
@RequestMapping(value = "/v1/usuarios")
public class UsuarioRestController
{

    public ResponseEntity<Usuarios> getUserById()
    {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
