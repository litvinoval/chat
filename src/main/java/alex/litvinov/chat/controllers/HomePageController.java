package alex.litvinov.chat.controllers;


import alex.litvinov.chat.helpers.SessionMessages;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/main")
@SessionAttributes("chatHistory")
public class HomePageController {


    @GetMapping
    public String homePage(){
        return "main";
    }

    @ModelAttribute(name = "chatHistory")
    public SessionMessages getSessionMessages(){
        return SessionMessages.getSessionMessages();
    }

}
