package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Message;
import com.example.repository.MessageRepository;

@Service
public class MessageService {
    @Autowired
    private MessageRepository repository;

    public Message insertMessage(Message message) {
        return null;
    }

    public List<Message> getAllMessages() {
        return null;
    }

    public Message getMessageByID(int message_id) {
        return null;
    }

    public Message deleteMessageByID(int message_id) {
        return null;
    }
    
    public Message patchMessageByID(int message_id, String message_text) {
        return null;      
    }

    public List<Message> getAllMessagesByUserID(int user_id) {
        return null;
    }
}
