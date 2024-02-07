package lhe.shinano.qq_chat;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class QQChatStarter {

    public static void main(String[] args) {
        System.setProperty("java.awt.headless","false");
        SpringApplicationBuilder builder = new SpringApplicationBuilder(QQChatStarter.class);
        builder.headless(false).web(WebApplicationType.SERVLET).run(args);
    }
}