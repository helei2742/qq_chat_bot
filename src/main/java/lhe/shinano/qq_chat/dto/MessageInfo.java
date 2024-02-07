package lhe.shinano.qq_chat.dto;

import lombok.Data;

@Data
public class MessageInfo {
    private long targetQQ;
    private long srcQQ;

    private long time;
    private String message;

    private String response;

    private Throwable exception;
}
