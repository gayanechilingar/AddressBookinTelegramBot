package io.project.app.addressbook.domain;

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;


public class Address {
    
    @Id
    private String id;
    private Integer chatId;
    private Long contactId = System.currentTimeMillis();
    private String contactName;    
    private String email;  
    private int phoneNumber;  
    private int zoomId;  
    private LocalDateTime record_date = LocalDateTime.now();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getZoomId() {
        return zoomId;
    }

    public void setZoomId(int zoomId) {
        this.zoomId = zoomId;
    }

    public LocalDateTime getRecord_date() {
        return record_date;
    }

    public void setRecord_date(LocalDateTime record_date) {
        this.record_date = record_date;
    }
    
}
