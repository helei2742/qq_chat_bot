package lhe.shinano.qq_chat.service.impl;

import lhe.shinano.qq_chat.constant.ExceptionMsg;
import lhe.shinano.qq_chat.dto.Result;
import lhe.shinano.qq_chat.dto.request.AddBotListenedFriendRequest;
import lhe.shinano.qq_chat.entity.BotListenedFriend;
import lhe.shinano.qq_chat.mapper.BotListenedFriendMapper;
import lhe.shinano.qq_chat.service.IBotListenedFriendService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lhe.shinano.qq_chat.service.IBotService;
import lhe.shinano.qq_chat.util.ListenedFriendUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lhe.shinano
 * @since 2024-02-07
 */
@Slf4j
@Service
public class BotListenedFriendServiceImpl extends ServiceImpl<BotListenedFriendMapper, BotListenedFriend> implements IBotListenedFriendService {

    @Autowired
    private IBotService botService;

    @Override
    @Transactional
    public Result addBotListenedFriend(AddBotListenedFriendRequest request) {
        Integer botId = request.getBotId();
        Map<Long, List<Long>> groupListenedMap = request.getGroupListenedMap();
        if (botId == null ||
                (request.getSingleFriendQQList() == null &&
                        (groupListenedMap == null || groupListenedMap.isEmpty()))) {
            return Result.fail(ExceptionMsg.PARAM_ERROR);
        }
        if (!botService.query().eq("id", botId).exists()) {
            return Result.fail(ExceptionMsg.BOT_NOT_EXIST_ERROR);
        }

        baseMapper.batchInsertIgnore(botId, request.getSingleFriendQQList());
        log.info("bind bot[{}] listened friend count [{}]", botId, request.getSingleFriendQQList().size());

        for (Map.Entry<Long, List<Long>> entry : groupListenedMap.entrySet()) {
            Long groupNumber = entry.getKey();
            //要添加的
            List<Long> peoples = entry.getValue();

            Set<Long> newPeoples = null;
            if(peoples == null || peoples.isEmpty()) {
            } else {
                BotListenedFriend one = query().eq("bot_id", botId).eq("group_number", groupNumber).one();
                if(one != null) {
                    newPeoples = ListenedFriendUtil.generateListenedFriendtoSet(one.getGroupListenList());
                } else {
                    newPeoples = new HashSet<>();
                }
                newPeoples.addAll(peoples);
            }
            baseMapper.insertOrUpdate(botId, groupNumber, ListenedFriendUtil.generateListenedFriendToStr(newPeoples));
        }

        return Result.success();
    }
}
