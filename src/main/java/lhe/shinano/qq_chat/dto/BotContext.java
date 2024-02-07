package lhe.shinano.qq_chat.dto;

import lombok.Data;

@Data
public class BotContext {
    private Long qq;
    private String pwd;

    public BotContext(String s) {
        String[] split = s.split("@");
        this.qq = Long.valueOf(split[0]);
        this.pwd = split[1];
    }
}
