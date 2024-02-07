package lhe.shinano.qq_chat.bot;

import cn.hutool.core.util.StrUtil;
import lhe.shinano.qq_chat.dto.MessageInfo;
import lhe.shinano.qq_chat.supprot.ChatBotInvocationHandler;
import lhe.shinano.qq_chat.interceptor.Interceptor;
import lombok.extern.slf4j.Slf4j;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.contact.Friend;
import net.mamoe.mirai.event.events.FriendMessageEvent;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public abstract class AbstractChatBot implements ChatBot {
    protected ChatBot proxy;

    protected Bot bot;

    private List<Interceptor> interceptors;

    public AbstractChatBot() {
        this.proxy = this;
        interceptors = new ArrayList<>();
    }

    @Override
    public void init(Bot bot) {
        this.bot = bot;
        proxy = ChatBotInvocationHandler.warp(proxy, interceptors);
        bot.login();
        bot.getEventChannel().subscribeAlways(FriendMessageEvent.class, proxy::gotFriendMessage);
        interceptors = null;
    }


    @Override
    public void gotFriendMessage(FriendMessageEvent event) {
        log.debug("got friend message [{}]", event);

        long id = event.getFriend().getId();
        String message = event.getMessage().contentToString();
        MessageInfo info = new MessageInfo();
        info.setSrcQQ(bot.getId());
        info.setTime(System.currentTimeMillis());
        info.setTargetQQ(id);
        info.setMessage(message);
        proxy.whenGotFriendMessage(info, event);

        if (StrUtil.isNotBlank(info.getResponse())) {
            event.getSubject().sendMessage(info.getResponse());
            log.debug("response friend message [{}]->[{}]", info.getSrcQQ(), info.getTargetQQ());
        }
    }


    public AbstractChatBot addInterceptor(Interceptor interceptor) {
        interceptors.add(interceptor);
        return this;
    }

    public Friend getFriend(Long friendQQ) {
        return bot.getFriend(friendQQ);
    }

}
