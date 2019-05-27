package com.tomas.test.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection ="DataTravels")
public class DataTravels
{
    /**
     *
     */
    @Id
    private String idImageType;
    /**
     *
     */
    private String image1;

    /**
     *
     */
    private String image2;
    /**
     *
     */
    private String image3;
    /**
     *
     */
    private String image4;
    /**
     *
     */
    private String descriptionImage;

}
