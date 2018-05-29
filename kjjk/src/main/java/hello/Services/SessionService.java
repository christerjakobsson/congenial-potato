package hello.Services;

import hello.Models.Session;
import hello.Models.User;
import hello.Repositories.SessionRepository;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

@Service
public class SessionService extends EntityService<Session> {
    private final SessionRepository repository;

    public SessionService(SessionRepository sessionRepository) {
        super(sessionRepository);
        this.repository = sessionRepository;
    }

    public Boolean Validate(Session session) {
        Long diff = Date.from(Instant.now()).getTime() - session.AccessedAt.getTime();
        if(diff < session.SessionLifeTime.getTime()) {
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
        return repository.findByUserId(user.Id);
    }

    public Session generateSession(User user, boolean rememberMe) {
        Session session = new Session();
        session.UserId = user.Id;
        session.TokenId = UUID.randomUUID();

        if(rememberMe) {
            session.SessionLifeTime = Date.from(Instant.now().plus(30, ChronoUnit.DAYS));
        }

        session.AccessedAt = Time.from(Instant.now());

        //should it be saved here?
        repository.save(session);

        return session;

    }
}
