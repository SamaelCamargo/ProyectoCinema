package com.cinema.usaCiclo3.repository.crud;

import com.cinema.usaCiclo3.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository <Message, Integer> {
}
