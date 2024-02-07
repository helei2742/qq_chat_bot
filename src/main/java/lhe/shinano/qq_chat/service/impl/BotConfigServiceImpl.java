package lhe.shinano.qq_chat.service.impl;

import cn.hutool.core.util.StrUtil;
import lhe.shinano.qq_chat.constant.BaseBotType;
import lhe.shinano.qq_chat.constant.ExceptionMsg;
import lhe.shinano.qq_chat.dto.Result;
import lhe.shinano.qq_chat.entity.BotConfig;
import lhe.shinano.qq_chat.mapper.BotConfigMapper;
import lhe.shinano.qq_chat.service.IBotConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lhe.shinano
 * @since 2024-02-07
 */
@Service
public class BotConfigServiceImpl extends ServiceImpl<BotConfigMapper, BotConfig> implements IBotConfigService {

    @Override
    public Result addBotConfig(BotConfig config) {
        String type = config.getType();
        if (config.getCreateUserId() == null || StrUtil.isBlank(config.getName()) ||
                StrUtil.isBlank(type) || !BaseBotType.exist(type)) {
            return Result.fail(ExceptionMsg.PARAM_ERROR);
        }

        if (save(config)) {
            return Result.success();
        }

        return Result.fail(ExceptionMsg.UNKNOWN_ERROR);
    }
}
