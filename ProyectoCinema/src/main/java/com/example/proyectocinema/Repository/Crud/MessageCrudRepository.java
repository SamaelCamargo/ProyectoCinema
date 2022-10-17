package com.example.proyectocinema.Repository.Crud;

import com.example.proyectocinema.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
