package alex.litvinov.chat.helpers;


import alex.litvinov.chat.broker.Message;

import java.util.ArrayList;
import java.util.List;

public class SessionMessages {

    private List<Message> messages;
    private static SessionMessages sessionMessages;

    private SessionMessages(List<Message> messages){
        this.messages = messages;
    }

    public static synchronized SessionMessages getSessionMessages(){
        if(sessionMessages == null) {
            sessionMessages = new SessionMessages(new ArrayList<>());
        }
        return sessionMessages;
    }

    public List<Message> getMessages(){
        return this.messages;
    }

    public void addMessage(Message message){
        messages.add(message);
    }

}
