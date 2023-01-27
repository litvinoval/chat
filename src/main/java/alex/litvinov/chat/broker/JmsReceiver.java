package alex.litvinov.chat.broker;

import alex.litvinov.chat.helpers.SessionMessages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JmsReceiver {

    @JmsListener(destination = "chat.message")
    public void receiveMessage(Message message){
        SessionMessages.getSessionMessages().addMessage(message);
    }

}
