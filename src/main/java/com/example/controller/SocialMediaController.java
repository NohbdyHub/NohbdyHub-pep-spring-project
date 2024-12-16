package com.example.controller;

import java.util.List;

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
import com.example.exception.UnauthorizedException;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
@RestController
public class SocialMediaController {
    
    @PostMapping("/register")
    public Account register(@RequestBody Account newAccount) {
        return null;
    }

    @PostMapping("/login")
    public Account login(@RequestBody Account loggingIn) {
        return null;
    }

    @PostMapping("/messages")
    public Message addMessage(@RequestBody Message toPost) {
        return null;
    }

    @GetMapping("/messages")
    public List<Message> getMessages() {
        return null;
    }

    @GetMapping("/messages/{message_id}")
    public List<Message> getMessageByID(@PathVariable long message_id) {
        return null;
    }

    @DeleteMapping("/messages/{message_id}")
    public Message deleteMessageByID(@PathVariable long message_id) {
        return null;
    }

    @PatchMapping("/messages/{message_id}")
    public int patchMessageByID(@PathVariable long message_id) {
        return 0;
    }

    @GetMapping("/accounts/{account_id}/messages")
    public List<Message> getMessagesByUser(@PathVariable long account_id) {
        return null;
    }

    @ExceptionHandler(UsernameExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public void handleConflict() { }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public void handleUnauthorized() { }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleBadRequest() { }
}
