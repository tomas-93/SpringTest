package com.tomas.test.respository;

import com.tomas.test.entity.Usuarios;
import org.springframework.data.repository.CrudRepository;

import javax.validation.Valid;

public interface UsuariosRepository extends CrudRepository<@Valid Usuarios, String>
{
}
