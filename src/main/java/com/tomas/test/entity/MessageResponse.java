package com.tomas.test.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection ="MessageResponse")
public class MessageResponse
{
    @Id
    private String _id;
    private String api;
    private List<CodigosMessage> codigosMessageList;
}
