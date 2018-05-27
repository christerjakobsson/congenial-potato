package hello.Models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User extends EntityBase {
    public String password;
    public String email;
    public String username;
    public Profile profile;


}
