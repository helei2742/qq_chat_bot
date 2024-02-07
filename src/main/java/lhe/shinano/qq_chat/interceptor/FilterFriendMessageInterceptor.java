package lhe.shinano.qq_chat.interceptor;

import lhe.shinano.qq_chat.dto.MessageInfo;
import lhe.shinano.qq_chat.service.FriendService;
import lombok.extern.slf4j.Slf4j;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class FilterFriendMessageInterceptor implements Interceptor{

    @Autowired
    private FriendService friendService;

    @Override
    public boolean beforeBotInit() {
        return true;
    }

    @Override
    public boolean afterBotInit() {
        return true;
    }

    @Override
    public boolean beforeGotFriendMessage(MessageInfo messageInfo, FriendMessageEvent event) {
        log.debug("filer friend message, before got friend message, [{}]->[{}]", messageInfo.getTargetQQ(), messageInfo.getSrcQQ());
        return friendService.isQQFriend(messageInfo.getSrcQQ(), messageInfo.getTargetQQ());
    }

    @Override
    public boolean afterGotFriendMessage(MessageInfo messageInfo, FriendMessageEvent event) {
        log.debug("filer friend message, after got friend message, [{}]->[{}]", messageInfo.getTargetQQ(), messageInfo.getSrcQQ());
        return true;
    }
}
