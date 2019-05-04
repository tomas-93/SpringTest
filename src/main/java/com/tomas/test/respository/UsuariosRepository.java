package com.tomas.test.respository;

import com.tomas.test.entity.Usuarios;
import org.springframework.data.repository.CrudRepository;

public interface UsuariosRepository extends CrudRepository<Usuarios, String>
{
}
