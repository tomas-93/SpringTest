package com.tomas.test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tomas.test.aspect.annotation.Algoritmo;
import com.tomas.test.aspect.annotation.Cifrado;
import lombok.Data;

@Data
public class ChatBoot
{
    @Cifrado(value = Algoritmo.MASTER_CARD)
    private String message;


}
