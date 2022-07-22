package Controller;

import entity.Message;
import entity.User;

import java.time.Clock;
import java.time.LocalDateTime;

public class MessageController {
    static public void editText(Message m,String text){
        m.setEdited(true);
        m.setText(text);
    }
    static public void seen(Message m){
        m.setSeen(true);
    }
    static public void replyOn(Message m,Message a){
        m.getReplyOn().add(a);
    }
    static public Message forwarded(User u, Message m){
        Message f;
        if(m.isType()){
            f = new Message(m.getUser(), m.getText(), m.isType(), m.getGroup(), false, m.getMessage(), false, false,  Clock.systemUTC().millis());
        } else {
            f = new Message(m.getUser(), m.getText(), m.isType(), m.getChat(), false, m.getMessage(), false, false,  Clock.systemUTC().millis());
        }
        f.setForwarder(u);
        f.setForwarded(true);
        f.setDate(LocalDateTime.now().toString());
        return f;
    }
    static public void setTime(Message m){
        m.setTime(Clock.systemUTC().millis());
        m.setDate(LocalDateTime.now().toString());
    }
}
