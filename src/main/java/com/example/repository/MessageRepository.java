package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE Message m set m.messageText = :text WHERE m.messageId = :id")
    public void updateMessage(@Param("text") String text, @Param("id") int id);

    public List<Message> findAllByPostedBy(int postedBy);
}
