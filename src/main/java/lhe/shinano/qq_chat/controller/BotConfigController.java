package lhe.shinano.qq_chat.controller;

import lhe.shinano.qq_chat.dto.Result;
import lhe.shinano.qq_chat.entity.BotConfig;
import lhe.shinano.qq_chat.service.IBotConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lhe.shinano
 * @since 2024-02-07
 */
@RestController
@RequestMapping("/botConfig")
public class BotConfigController {

    @Autowired
    private IBotConfigService botConfigService;

    @PostMapping("/addBotConfig")
    public Result addBotConfig(@RequestBody BotConfig config) {
        return botConfigService.addBotConfig(config);
    }
}
