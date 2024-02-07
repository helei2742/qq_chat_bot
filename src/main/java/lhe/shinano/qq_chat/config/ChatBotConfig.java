package lhe.shinano.qq_chat.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "lhe.shinano.qq-chat.bot")
public class ChatBotConfig {

    private Long qq;

    private String password;

    private String deviceJSONLocation;
}
