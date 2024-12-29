package com.example.photo_clone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;

import java.util.UUID;

public class Photo {
    private String id;
    @NotEmpty
    private String fileName;
    private byte[] data;
    private String contentType;

    public Photo() {
        this.id = UUID.randomUUID().toString();
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @JsonIgnore
    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getId() {
        return id;
    }

}