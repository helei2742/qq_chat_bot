package lhe.shinano.qq_chat.dto.request;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class AddBotListenedFriendRequest {

    private Integer botId;

    private List<Long> singleFriendQQList;

    private Map<Long, List<Long>> groupListenedMap;
}
