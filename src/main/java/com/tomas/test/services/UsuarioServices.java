package com.tomas.test.services;

import com.tomas.test.aspect.annotation.ServiceMC;
import com.tomas.test.entity.Usuarios;
import com.tomas.test.respository.UsuariosRepository;
import com.tomas.test.utils.CodigosRespuesta;
import com.tomas.test.utils.exception.MessageException;
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
    @Autowired
    private UsuariosRepository usuariosRepository;

    @ServiceMC
    public Usuarios getUsuariosById(@Valid @NotNull(message = "Id no Null")
                                        @NotEmpty(message = "Id no Empty") String id)
    {
        Optional<Usuarios> usuarios = this.usuariosRepository.findById(id);
        if (!usuarios.isPresent())
            throw new MessageException(HttpStatus.INTERNAL_SERVER_ERROR, CodigosRespuesta.ERROR_GENERICO);
        return usuarios.get();
    }

}
