package lhe.shinano.qq_chat.interceptor;

import lhe.shinano.qq_chat.dto.MessageInfo;
import lhe.shinano.qq_chat.service.AIService;
import lombok.extern.slf4j.Slf4j;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class GotAIResponseInterceptor implements Interceptor{

    @Autowired
    private AIService aiService;

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
        log.debug("got ai response, before got friend message, [{}]->[{}]", messageInfo.getTargetQQ(), messageInfo.getSrcQQ());

        try {
            String response = aiService.gotAIResponse(messageInfo.getSrcQQ(), messageInfo.getTargetQQ(), messageInfo.getMessage());
            messageInfo.setResponse(response);
        } catch (IOException e) {
            log.error("try invoke ai interface to get response error, [{}]", messageInfo, e);
        }
        return true;
    }

    @Override
    public boolean afterGotFriendMessage(MessageInfo messageInfo, FriendMessageEvent event) {
        log.debug("got ai response, fater got friend message, [{}]->[{}]", messageInfo.getTargetQQ(), messageInfo.getSrcQQ());
        return true;
    }
}
