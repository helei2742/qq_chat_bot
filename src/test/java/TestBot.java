import com.qrcode.QRCodeBot;
import lhe.shinano.qq_chat.QQChatStarter;
import lhe.shinano.qq_chat.config.ChatBotConfig;
import lhe.shinano.qq_chat.util.GPTInvokeUtil;
import lombok.extern.slf4j.Slf4j;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.contact.Friend;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Slf4j
@SpringBootTest(classes = {QQChatStarter.class})
@RunWith(SpringRunner.class)
public class TestBot {

    @Autowired
    private ChatBotConfig chatBotConfig;


    @Test
    public void testQRCode() throws InterruptedException {
        long listenQQ = 1786934054L;
        String apiUtl = "http://0.0.0.0:6667/chat";

        Bot bot = QRCodeBot.getQRCodeBot(914577981L);
        bot.login();
        Friend friend = bot.getFriend(listenQQ);
        friend.sendMessage("mua");

        bot.getEventChannel().subscribeAlways(FriendMessageEvent.class, event -> {
            long id = event.getFriend().getId();
            if (id == listenQQ) {
                String question = event.getMessage().contentToString();
                String response;

                try {
                    response = GPTInvokeUtil.sendQuestion(apiUtl, null, question);
                    event.getSubject().sendMessage(response);

                    log.info("question [{}], response [{}]", question, response);
                } catch (IOException e) {
                    log.error("got qq[{}] message [{}] but response gpt result error",  id, question, e);
                }
            }
        });

        TimeUnit.HOURS.sleep (1);
    }


//    @Test
//    public void TestBotLogin() {
//        for (BotContext botContext : chatBotConfig.getBotList()) {
//            Bot bot = BotFactory.INSTANCE.newBot(botContext.getQq(),
//                    botContext.getPwd(),
//                    new BotConfiguration() {{
//                        fileBasedDeviceInfo("device.json");
//                        setProtocol(MiraiProtocol.ANDROID_WATCH);
//                    }});
//            bot.login();
//            break;
//        }
//    }


}
