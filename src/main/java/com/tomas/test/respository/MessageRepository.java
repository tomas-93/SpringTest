package com.tomas.test.respository;


import com.tomas.test.entity.MessageResponse;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<MessageResponse, String>
{
    MessageResponse findByApi(String api);
}
