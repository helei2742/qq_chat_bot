package lhe.shinano.qq_chat.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "lhe.shinano.qq-chat.ai")
public class ChatAIConfig {

    private String apiUrl;

}
