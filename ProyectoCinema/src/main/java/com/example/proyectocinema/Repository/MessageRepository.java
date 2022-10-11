package com.example.proyectocinema.Repository;

import com.example.proyectocinema.Repository.Crud.MessageCrudRepository;
import com.example.proyectocinema.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {
    @Autowired
    private MessageCrudRepository messageCrudRepository;


    public List<Message> getAll(){
        return (List<Message>) messageCrudRepository.findAll();
    }

    public Optional<Message> getMessage(int id){
        return messageCrudRepository.findById(id);
    }

    public Message save (Message message){
        return messageCrudRepository.save(message);
    }

    public void delete (Message message){
        messageCrudRepository.delete(message);
    }

}
