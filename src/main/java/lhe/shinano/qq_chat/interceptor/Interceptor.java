package lhe.shinano.qq_chat.interceptor;


import lhe.shinano.qq_chat.dto.MessageInfo;
import net.mamoe.mirai.event.events.FriendMessageEvent;

public interface Interceptor {
    boolean beforeBotInit();

    boolean afterBotInit();

    boolean beforeGotFriendMessage(MessageInfo messageInfo, FriendMessageEvent event);

    boolean afterGotFriendMessage(MessageInfo messageInfo, FriendMessageEvent event);

}
