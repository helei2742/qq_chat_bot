package lhe.shinano.qq_chat.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * 表示机器人监听的好友或群
 * groupNumber与friendQq同时只有一个不为null，表示这个botId 监听的一个好友或群聊。
 * 当groupNumber不为空，监听群聊时：
 * 1. groupListenList为null时表示监听整个群
 * 2. groupListenList不为空表示监听群里好友的qq号码，用 , 拼接，如 123456,55351351
 * @author lhe.shinano
 * @since 2024-02-07
 */
@Getter
@Setter
@TableName("t_bot_listened_friend")
public class BotListenedFriend implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer botId;

    private Long groupNumber;

    private String groupListenList;

    private Long friendQq;
}
