package alex.litvinov.chat.controllers;

import alex.litvinov.chat.domain.User;
import alex.litvinov.chat.helpers.RegistrationUser;
import alex.litvinov.chat.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private PasswordEncoder pw;
    private UserRepo userRepo;
    @Autowired
    public RegistrationController(PasswordEncoder pw, UserRepo userRepo){
        this.pw = pw;
        this.userRepo = userRepo;
    }

    @ModelAttribute(name = "registration")
    public RegistrationUser registrationUser(){
        return new RegistrationUser();
    }
    @GetMapping
    public String register(){
        return "register";
    }

    @PostMapping()
    public String saveUser(@Valid @ModelAttribute("registration") RegistrationUser registration,
                           Errors errors){
        if(errors.hasErrors()){
            return "register";
        }
        User user = registration.convertToUser(pw);
        userRepo.save(user);
        return "redirect:/login";
    }



}
