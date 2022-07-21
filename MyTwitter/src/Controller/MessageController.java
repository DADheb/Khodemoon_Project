package Controller;

import entity.Message;

public class MessageController {
    static public void editText(Message m,String text){
        m.setEdited(true);
        m.setText(text);
    }
    static public void seen(Message m){
        m.setSeen(true);
    }
}
