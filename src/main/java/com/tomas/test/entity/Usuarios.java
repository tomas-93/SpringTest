package com.tomas.test.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Document(value = "Usuarios")
public class Usuarios
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

    public String get_id()
    {
        return _id;
    }

    public void set_id(String _id)
    {
        this._id = _id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getApellidos()
    {
        return apellidos;
    }

    public void setApellidos(String apellidos)
    {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNacimiento()
    {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento)
    {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isEstatus()
    {
        return estatus;
    }

    public void setEstatus(boolean estatus)
    {
        this.estatus = estatus;
    }
}
