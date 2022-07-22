package Controller;

import entity.Chat;
import entity.Message;

public class ChatController {
    static public void newMessage(Chat t, Message m){
        t.getMessages().add(m);
    }
    static public void deleteMessage(Chat t, Message m){
        t.getMessages().remove(m);
    }
}
