package lhe.shinano.qq_chat.service.impl;

import lhe.shinano.qq_chat.constant.ExceptionMsg;
import lhe.shinano.qq_chat.dto.Result;
import lhe.shinano.qq_chat.dto.request.AddBotListenedFriendRequest;
import lhe.shinano.qq_chat.entity.BotListenedFriend;
import lhe.shinano.qq_chat.mapper.BotListenedFriendMapper;
import lhe.shinano.qq_chat.service.IBotListenedFriendService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lhe.shinano.qq_chat.service.IBotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lhe.shinano
 * @since 2024-02-07
 */
@Service
public class BotListenedFriendServiceImpl extends ServiceImpl<BotListenedFriendMapper, BotListenedFriend> implements IBotListenedFriendService {

    @Autowired
    private IBotService botService;

    @Override
    public Result addBotListenedFriend(AddBotListenedFriendRequest request) {
        if(request.getBotId() == null ||
                (request.getSingleFriendQQList() == null &&
                        (request.getGroupListenedMap() == null || request.getGroupListenedMap().isEmpty()))) {
            return Result.fail(ExceptionMsg.PARAM_ERROR);
        }
        if (!botService.query().eq("id", request.getBotId()).exists()) {
            return Result.fail(ExceptionMsg.BOT_NOT_EXIST_ERROR);
        }

        return null;
    }
}
