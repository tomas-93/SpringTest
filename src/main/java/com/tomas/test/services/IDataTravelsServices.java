package com.tomas.test.services;

import com.tomas.test.entity.DataTravels;

public interface IDataTravelsServices
{
    /**
     * Add new entity
     * @param entity
     */
    void add(DataTravels entity);

    /**
     * Get data for id
     * @param _id
     */
    DataTravels get(String _id);

    /**
     * Edit data for entity
     * @param entity
     */
    void put(DataTravels entity);

    /**
     * Delete for entity
     * @param entity
     */
    void delete(DataTravels entity);
}