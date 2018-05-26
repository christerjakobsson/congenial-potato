package com.example.demo.Controllers;

import com.example.demo.Authentication.PasswordHelper;
import com.example.demo.Controllers.Requests.LoginRequest;
import com.example.demo.Models.Session;
import com.example.demo.Models.User;
import com.example.demo.Repositories.UserRepository;
import com.example.demo.Services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    private PasswordHelper passwordHelper;
    @Autowired
    //private SessionService sessionService;

    public SecurityController(/*SessionService sessionService*/PasswordHelper passwordHelper/* UserRepository userRepository*/) {
      //  this.sessionService = sessionService;
        this.passwordHelper = passwordHelper;
        //this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public ResponseEntity Login(@RequestBody LoginRequest dto) {
        // username is email, validate email and check for uniqueness
    //    User user = userRepository.findByEmail(dto.Username.toLowerCase());

      //  if (user == null) {
        //    return new ResponseEntity(HttpStatus.UNAUTHORIZED);
       // }

        //password needs to be atleast 6 characters long
        if (dto.Password.length() < 6) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        // try to login user
        //boolean valid = passwordHelper.verifyHash(dto.Password, user.getPassword());
        //if (!valid)
        //    return new ResponseEntity(HttpStatus.UNAUTHORIZED);

        // create session and return it
        //Session session = sessionService.findByUser(user);
        //if (session != null)
        //    return new ResponseEntity(session, HttpStatus.OK);

        //sessionService.generateSession(user, dto.RememberMe);

        return null;
    }
}
