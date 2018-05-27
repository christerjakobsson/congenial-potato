package com.example.demo.Services;

import com.example.demo.Models.Session;
import com.example.demo.Models.User;
import com.example.demo.Repositories.SessionRepository;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

@Service
public class SessionService {
    private final SessionRepository repository;

    public SessionService(SessionRepository sessionRepository) {
        this.repository = sessionRepository;
    }

    public Boolean Validate(Session session) {
        Long diff = Date.from(Instant.now()).getTime() - session.getAccessedAt().getTime();
        if(diff < session.getSessionLifeTime().getTime()) {
            // INVALID
            return false;
        } else {
            //session.setAccessedAt(Date.from(Instant.now()));
            //session.setModifiedAt(Date.from(Instant.now()));
            //this.repository.save(session);
            return true;
        }
    }

    public Session findByUser(User user) {
        return repository.findByUserId(user.getId());
    }

    public Session generateSession(User user, boolean rememberMe) {
        Session session = new Session();
        session.setUserId(user.getId());
        session.setTokenId(UUID.randomUUID());

        if(rememberMe) {
            session.setSessionLifeTime(Date.from(Instant.now().plus(30, ChronoUnit.DAYS)));
        }

        session.setAccessedAt(Time.from(Instant.now()));

        //should it be saved here?
        repository.save(session);

        return session;

    }
}
