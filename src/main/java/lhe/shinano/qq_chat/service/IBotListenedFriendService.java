package lhe.shinano.qq_chat.service;

import lhe.shinano.qq_chat.dto.Result;
import lhe.shinano.qq_chat.dto.request.AddBotListenedFriendRequest;
import lhe.shinano.qq_chat.entity.BotListenedFriend;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lhe.shinano
 * @since 2024-02-07
 */
public interface IBotListenedFriendService extends IService<BotListenedFriend> {

    Result addBotListenedFriend(AddBotListenedFriendRequest request);
}
