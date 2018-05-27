package hello.Models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Document(collection = "sessions")
public class Session extends EntityBase {
    public UUID TokenId;
    public Date AccessedAt;
    public Date SessionLifeTime;
    public UUID UserId;
}
