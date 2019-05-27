package com.tomas.test.services;

import com.tomas.test.aspect.annotation.Apis;
import com.tomas.test.aspect.annotation.ServiceMC;
import com.tomas.test.entity.Usuarios;
import com.tomas.test.respository.UsuariosRepository;
import com.tomas.test.utils.CodigosRespuesta;
import com.tomas.test.utils.exception.MessageException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Service
public class UsuarioServices
{
    private static final Logger logger = LoggerFactory.getLogger(UsuarioServices.class);
    @Autowired
    private UsuariosRepository usuariosRepository;

    @ServiceMC(Apis.ApiUsuarios)
    public Usuarios getUsuariosById(@Valid @NotNull(message = "Id no Null")
                                        @NotEmpty(message = "Id no Empty") String id)
    {
        logger.info("Services");
        Optional<Usuarios> usuarios = this.usuariosRepository.findById(id);
        if (!usuarios.isPresent())
            throw new MessageException(HttpStatus.INTERNAL_SERVER_ERROR, CodigosRespuesta.ERROR_GENERICO);
        return usuarios.get();

    }

}
