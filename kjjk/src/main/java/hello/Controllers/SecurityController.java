package hello.Controllers;

import hello.Authentication.PasswordHelper;
import hello.Controllers.Requests.LoginRequest;
import hello.Controllers.Requests.SignupRequest;
import hello.Models.Session;
import hello.Models.User;
import hello.Repositories.UserRepository;
import hello.Services.SessionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    private SessionService sessionService;
    private UserRepository userRepository;
    private PasswordHelper passwordHelper;

    public SecurityController(SessionService sessionService, PasswordHelper passwordHelper, UserRepository userRepository) {
        this.sessionService = sessionService;
        this.passwordHelper = passwordHelper;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity Login(@RequestBody LoginRequest dto) {
        //username is email, validate email and check for uniqueness
        User user = userRepository.findByEmail(dto.Username.toLowerCase());

        if (user == null) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        //password needs to be atleast 6 characters long
        if (dto.Password.length() < 6) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        // try to login user
        boolean valid = passwordHelper.verifyHash(dto.Password, user.password);
        if (!valid)
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);

        // create session and return it
        Session session = sessionService.findByUser(user);
        if (session != null)
            return new ResponseEntity(session, HttpStatus.OK);

        sessionService.generateSession(user, dto.RememberMe);

        return null;
    }

    @PostMapping("/signup")
    public ResponseEntity Signup(@RequestBody SignupRequest dto) {
        User byEmail = userRepository.findByEmail(dto.Email);

        if(byEmail != null) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }

        if(dto.Password.length() <= 6) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        User newUser = new User();
        newUser.email = dto.Email;
        newUser.username = dto.Username;
        newUser.password = passwordHelper.hash(dto.Password);

        User save = userRepository.save(newUser);

        if(save == null) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity(HttpStatus.OK);
    }
    //validate token
}
