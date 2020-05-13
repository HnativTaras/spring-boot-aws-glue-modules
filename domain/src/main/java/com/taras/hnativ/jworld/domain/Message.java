package com.taras.hnativ.jworld.domain;


import java.util.Objects;

public class Message {
    private String id;
    private String content;
    private String dateTime;

    public Message(){}

    public Message(String id, String content, String dateTime) {
        this.id = id;
        this.content = content;
        this.dateTime = dateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, dateTime);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Message message = (Message) obj;
        return Objects.equals(this.getId(), message.getId()) && Objects
                .equals(this.getContent(), message.getContent()) && Objects
                .equals(this.getDateTime(), message.getDateTime());
    }
}
