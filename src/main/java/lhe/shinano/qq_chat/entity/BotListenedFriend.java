package lhe.shinano.qq_chat.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
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

    private Long friendQq;
}
