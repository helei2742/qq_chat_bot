package lhe.shinano.qq_chat.service.impl;

import cn.hutool.core.util.StrUtil;
import lhe.shinano.qq_chat.constant.ExceptionMsg;
import lhe.shinano.qq_chat.dto.request.CreateBotRequest;
import lhe.shinano.qq_chat.dto.Result;
import lhe.shinano.qq_chat.entity.Bot;
import lhe.shinano.qq_chat.mapper.BotMapper;
import lhe.shinano.qq_chat.service.IBotConfigService;
import lhe.shinano.qq_chat.service.IBotService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lhe.shinano.qq_chat.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class BotServiceImpl extends ServiceImpl<BotMapper, Bot> implements IBotService {

    @Autowired
    private IBotConfigService botConfigService;

    @Autowired
    private IUserService userService;

    @Override
    public Result createBot(CreateBotRequest request) {
        if (request.getCreateUserId() == null || StrUtil.isBlank(request.getName()) || request.getConfigId() == null) {
            return Result.fail(ExceptionMsg.PARAM_ERROR);
        }
        if (!userService.query().eq("id", request.getCreateUserId()).exists()) {
            return Result.fail(ExceptionMsg.USER_NOT_FOUNT);
        }

        Bot bot = new Bot();
        bot.setCreateUserId(request.getCreateUserId());
        bot.setName(request.getName());

        if (query().eq("create_user_id", bot.getCreateUserId()).eq("name", bot.getName()).exists()) {
            return Result.fail(ExceptionMsg.BOT_EXIST_ERROR);
        }

        bot.setBotConfigId(request.getConfigId());
        save(bot);

        log.debug("success save bot request [{}]", request);
        return Result.success();
    }
}
