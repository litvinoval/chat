package alex.litvinov.chat.controllers;

import alex.litvinov.chat.broker.JmsMessagingSender;
import alex.litvinov.chat.broker.Message;
import alex.litvinov.chat.helpers.SessionMessages;
import alex.litvinov.chat.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Slf4j
@Controller
@RequestMapping("/chat")
@SessionAttributes("chatHistory")
public class ChatController {

    private JmsMessagingSender jms;
    private SessionMessages sessionMessages;

    @Autowired
    public ChatController(JmsMessagingSender jms){
        this.jms = jms;
    }

    @GetMapping()
    public String update(){
        this.sessionMessages = SessionMessages.getSessionMessages();
        return "messageForm";
    }

    @PostMapping
    public String receive(@AuthenticationPrincipal User user,
                          Message message){

        message.setNick(user.getLogin());
        log.info("message: {}", message);
        jms.sendMessage(message);
        return "messageForm";
    }



}
