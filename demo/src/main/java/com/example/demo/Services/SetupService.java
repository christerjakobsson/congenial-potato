package com.example.demo.Services;

import com.example.demo.Models.Session;
import com.example.demo.Models.User;
import com.example.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetupService {

    private final UserRepository repository;

    public SetupService(UserRepository repository) {
        this.repository = repository;
    }

    public void createUser() {

        repository.deleteAll();

        User user = new User();
        user.setUsername("crille_cool");
        user.setEmail("jakobsson.christer@gmail.com");
        user.setPassword("1234");

        user.getProfile().setFirstName("Christer");
        user.getProfile().setLastName("Jakobsson");
        user.getProfile().setAddress("Ängsvägen 3");
        user.getProfile().setPostalCode("92273");
        user.getProfile().setCountry("Sweden");
        user.getProfile().setPhone("0723083772");
        user.getProfile().setMobilePhone("0723083772");

        repository.save(user);
    }
}