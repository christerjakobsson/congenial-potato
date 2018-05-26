package com.example.demo.Models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Document(collection = "sessions")
public class Session extends EntityBase {
    private UUID TokenId;
    private Date AccessedAt;
    private Date SessionLifeTime;
    private UUID UserId;

    public UUID getUserId() {
        return UserId;
    }

    public void setUserId(UUID userId) {
        UserId = userId;
    }

    public UUID getTokenId() {
        return TokenId;
    }

    public void setTokenId(UUID tokenId) {
        TokenId = tokenId;
    }

    public Date getAccessedAt() {
        return AccessedAt;
    }

    public void setAccessedAt(Date accessedAt) {
        AccessedAt = accessedAt;
    }

    public Date getSessionLifeTime() {
        return SessionLifeTime;
    }

    public void setSessionLifeTime(Date sessionLifeTime) {
        SessionLifeTime = sessionLifeTime;
    }
}
