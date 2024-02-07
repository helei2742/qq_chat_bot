package lhe.shinano.qq_chat.dto.request;

import lombok.Data;

@Data
public class CreateBotRequest {
    private Integer createUserId;
    private String name;
    private Integer configId;
}
