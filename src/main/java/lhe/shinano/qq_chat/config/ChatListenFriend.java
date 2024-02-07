package lhe.shinano.qq_chat.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "lhe.shinano.qq-chat.listen-friend")
public class ChatListenFriend {
    private List<Long> qqList;
}
