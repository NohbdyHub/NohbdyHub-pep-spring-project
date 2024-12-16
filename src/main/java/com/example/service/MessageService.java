package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Message;
import com.example.repository.AccountRepository;
import com.example.repository.MessageRepository;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private AccountRepository accountRepository;

    public Message insertMessage(Message message) {
        if (message.getMessageText().isBlank() || message.getMessageText().length() > 255 || !accountRepository.existsById(message.getPostedBy())) {
            throw new RuntimeException("Invalid message!");
        }
        return messageRepository.save(message);
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Message getMessageByID(int message_id) {
        return messageRepository.findById(message_id).orElse(null);
    }

    public Integer deleteMessageByID(int message_id) {
        if (!messageRepository.existsById(message_id)) {
            return null;
        }
        messageRepository.deleteById(message_id);
        return 1;
    }
    
    public Integer patchMessageByID(int message_id, String message_text) {
        if (message_text.isBlank() || message_text.length() > 255 || !messageRepository.existsById(message_id)) {
            throw new RuntimeException("Invalid message!");
        }

        messageRepository.updateMessage(message_text, message_id);
        return 1;      
    }

    public List<Message> getAllMessagesByUserID(int user_id) {
        return messageRepository.findAllByPostedBy(user_id);
    }
}
