package com.example.demo.Models;

import com.example.demo.Authentication.PasswordHelper;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User extends EntityBase {
    private String Password;
    private String Email;
    private String Username;
    private Profile Profile;

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = new PasswordHelper().hash(password);
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public com.example.demo.Models.Profile getProfile() {
        return Profile;
    }

    public void setProfile(com.example.demo.Models.Profile profile) {
        Profile = profile;
    }
}
