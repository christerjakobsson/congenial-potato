package com.example.demo.Controllers;

import com.example.demo.Services.SetupService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    private SetupService setupService;

    public GreetingsController(/*SetupService setupService*/) {
        this.setupService = setupService;
    }

   @RequestMapping("/person")
   public String doWork() {
        this.setupService.createUser();
        return "DONE";
   }
}