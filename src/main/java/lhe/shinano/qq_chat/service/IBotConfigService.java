package lhe.shinano.qq_chat.service;

import lhe.shinano.qq_chat.dto.Result;
import lhe.shinano.qq_chat.entity.BotConfig;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lhe.shinano
 * @since 2024-02-07
 */
public interface IBotConfigService extends IService<BotConfig> {

    /**
     * 添加机器人配置
     * @param config 配置
     * @return Result
     */
    Result addBotConfig(BotConfig config);
}
