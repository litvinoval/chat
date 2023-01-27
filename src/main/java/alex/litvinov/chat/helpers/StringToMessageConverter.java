package alex.litvinov.chat.helpers;

import alex.litvinov.chat.broker.Message;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToMessageConverter implements Converter<String, Message> {
    @Override
    public Message convert(String str) {
        return new Message(str);
    }
}
