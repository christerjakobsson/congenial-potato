package com.example.demo.Models;

import java.util.Date;
import java.util.UUID;

public class EntityBase {
    private Date CreatedAt;
    private Date ModifiedAt;
    private UUID Id;
    private String CreatedBy;

    private UUID ModifiedById;

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }

    public Date getModifiedAt() {
        return ModifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        ModifiedAt = modifiedAt;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }

    public UUID getModifiedById() {
        return ModifiedById;
    }

    public void setModifiedById(UUID modifiedById) { ModifiedById = modifiedById; }
}
