package com.JOffre.Model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Message implements Serializable {
    String senderId;
    String receiverId;
    Long messageId;
    Timestamp dateMessage;
    String message;

    public Message(){super();}

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public Long getMessageId() { return messageId; }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Timestamp getDateMessage() {
        return dateMessage;
    }

    public void setDateMessage(Timestamp dateMessage) {
        this.dateMessage = dateMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
