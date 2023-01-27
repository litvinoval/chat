package alex.litvinov.chat.broker;

import alex.litvinov.chat.domain.Message;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JmsMessagingSender {
    private JmsTemplate jmsTemplate;
    public JmsMessagingSender(JmsTemplate jmsTemplate){
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(Message message){
        jmsTemplate.send(session -> session.createObjectMessage(message));
    }

}
