package lhe.shinano.qq_chat.bot;

import lhe.shinano.qq_chat.dto.MessageInfo;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.event.events.FriendMessageEvent;

public interface ChatBot {

    void init(Bot bot);


    void gotFriendMessage(FriendMessageEvent event);


    void whenGotFriendMessage(MessageInfo messageInfo, FriendMessageEvent event);

}
