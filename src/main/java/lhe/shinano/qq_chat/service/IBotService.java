package lhe.shinano.qq_chat.service;

import lhe.shinano.qq_chat.dto.request.CreateBotRequest;
import lhe.shinano.qq_chat.dto.Result;
import lhe.shinano.qq_chat.entity.Bot;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lhe.shinano
 * @since 2024-02-07
 */
public interface IBotService extends IService<Bot> {

    /**
     * create bot
     * @param createBotRequest createBotRequest
     * @return Result
     */
    Result createBot(CreateBotRequest createBotRequest);

}
