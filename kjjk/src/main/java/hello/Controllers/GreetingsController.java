package hello.Controllers;

import hello.Authentication.PasswordHelper;
import hello.Models.User;
import hello.Services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    private final UserService userService;

    public GreetingsController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("hello")
    public String Hello() {
        return "Hello world";
    }

    @RequestMapping("/person")
    public User doWork() {
        User user = new User();

        user.username = "shinowa";
        user.email = "jakobsson.christer@gmail.com";
        user.password = new PasswordHelper().hash("123456");
        this.userService.Save(user);

        //this.setupService.createUser();
        return user;
    }
}