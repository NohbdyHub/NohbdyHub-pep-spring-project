package com.example.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Account;
import com.example.entity.Message;
import com.example.exception.UsernameExistsException;
import com.example.service.AccountService;
import com.example.service.MessageService;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
@RestController
public class SocialMediaController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private AccountService accountService;
    
    @PostMapping("/register")
    public Account register(@RequestBody Account newAccount) {
        return accountService.insertAccount(newAccount.getUsername(), newAccount.getPassword());
    }

    @PostMapping("/login")
    public Account login(@RequestBody Account loggingIn) {
        return accountService.getAccountByCredentials(loggingIn.getUsername(), loggingIn.getPassword());
    }

    @PostMapping("/messages")
    public Message addMessage(@RequestBody Message toPost) {
        return messageService.insertMessage(toPost);
    }

    @GetMapping("/messages")
    public List<Message> getMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/messages/{message_id}")
    public List<Message> getMessageByID(@PathVariable int message_id) {
        return messageService.getAllMessagesByUserID(message_id);
    }

    @DeleteMapping("/messages/{message_id}")
    public Message deleteMessageByID(@PathVariable int message_id) {
        return messageService.deleteMessageByID(message_id);
    }

    @PatchMapping("/messages/{message_id}")
    public Message patchMessageByID(@PathVariable int message_id, @RequestBody Message updatedMessage) {
        return messageService.patchMessageByID(message_id, updatedMessage.getMessageText());
    }

    @GetMapping("/accounts/{account_id}/messages")
    public List<Message> getMessagesByUser(@PathVariable int account_id) {
        return messageService.getAllMessagesByUserID(account_id);
    }

    @ExceptionHandler(UsernameExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public void handleConflict() { }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public void handleUnauthorized() { }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleBadRequest() { }
}
