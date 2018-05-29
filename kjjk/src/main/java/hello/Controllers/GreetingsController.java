package hello.Controllers;

import hello.Authentication.PasswordHelper;
import hello.Models.User;
import hello.Services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;


@RestController
public class GreetingsController {

    private final UserService userService;

    public GreetingsController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public ModelAndView Hello() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Hej");
        list.add("På");
        list.add("Dig");
        ModelAndView model = new ModelAndView("hello");
        model.addObject("greetings", list);

        return model;
    }

    @GetMapping("/")
    public String HelloStirng() {
        return "hello";
    }

    @GetMapping("/person")
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