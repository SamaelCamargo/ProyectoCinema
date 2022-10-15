package Services;

import Repository.MessageRepository;
import model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    public Optional <Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }
    public Message save (Message message){
        if (message.getIdMessage()==null){
            return messageRepository.save(message);
        }else {
            Optional<Message>message1 = messageRepository.getMessage(message.getIdMessage());
            if (message1.isEmpty()){
                return messageRepository.save(message);
            }else {
                return message;
            }
        }
    }
    //RETO 4
    public Message update (Message message){
        if (message.getIdMessage()!=null){
            Optional<Message>message1=messageRepository.getMessage(message.getIdMessage());
            if(message1.isEmpty()){
                if (message.getMessageText()!=null){
                    message1.get().setMessageText(message.getMessageText());
                }
                messageRepository.save(message1.get());
                return message1.get();
            }else {
                return message;
            }
        }else {
            return message;
        }
    }
    public boolean deleteMessage (int id){
        Boolean delete=getMessage(id).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return delete;
    }
}
