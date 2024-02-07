package lhe.shinano.qq_chat.config;

import com.qrcode.QRCodeBot;
import lhe.shinano.qq_chat.bot.AbstractChatBot;
import lhe.shinano.qq_chat.dto.MessageInfo;
import lhe.shinano.qq_chat.interceptor.FilterFriendMessageInterceptor;
import lhe.shinano.qq_chat.interceptor.GotAIResponseInterceptor;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(value = "lhe.shinano.qq-chat.start", havingValue = "true", matchIfMissing = true)
public class ChatAIBotRunner {

    @Autowired
    private ChatBotConfig chatBotConfig;

    @Autowired
    private FilterFriendMessageInterceptor filterFriendMessageInterceptor;

    @Autowired
    private GotAIResponseInterceptor gotAIResponseInterceptor;


//    @Bean
    public AbstractChatBot aiChatBot() {
//        Bot bot = BotFactory.INSTANCE.newBot(chatBotConfig.getQq(),
//                chatBotConfig.getPassword(),
//                new BotConfiguration() {{
//                    fileBasedDeviceInfo("device.json");
//                    setProtocol(MiraiProtocol.ANDROID_WATCH);
//                    setLoginSolver(new StandardCharImageLoginSolver());
//                }});
        Bot bot = QRCodeBot.getQRCodeBot(914577981L);

        AbstractChatBot abstractChatBot = new AbstractChatBot() {
            @Override
            public void whenGotFriendMessage(MessageInfo messageInfo, FriendMessageEvent event) {

            }
        };

        abstractChatBot.addInterceptor(gotAIResponseInterceptor)
                .addInterceptor(filterFriendMessageInterceptor)
                .init(bot);
        return abstractChatBot;
    }
}
