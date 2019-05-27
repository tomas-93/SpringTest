package com.tomas.test.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Document(collection = "Usuarios")
public class Usuarios extends ResponseTO
{
    @Id
    private String _id;
    @NotNull(message = "nombre")
    @NotEmpty(message = "nombre")
    private String nombre;
    @NotNull(message = "nombre")
    @NotEmpty(message = "nombre")
    private String apellidos;
    @NotNull(message = "fechaNacimiento")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaNacimiento;
    private boolean estatus;

}
