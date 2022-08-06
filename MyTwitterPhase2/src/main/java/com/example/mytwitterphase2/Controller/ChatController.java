package com.example.mytwitterphase2.Controller;

import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.entity.Chat;
import com.example.mytwitterphase2.entity.Message;

public class ChatController {
    static public void newMessage(Chat t, Message m){
        t.getMessages().add(m);
    }
    static public void deleteMessage(Chat t, Message m){
        t.getMessages().remove(m);
        DataBase.getMessages().remove(m);
    }
}
