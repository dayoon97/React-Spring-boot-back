package com.mycom;

import java.awt.TrayIcon.MessageType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
	
	private MessageType type;
    private String content;
    private String sender;

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }	
}
