package lhe.shinano.qq_chat.controller;

import lhe.shinano.qq_chat.dto.request.CreateBotRequest;
import lhe.shinano.qq_chat.dto.Result;
import lhe.shinano.qq_chat.service.IBotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lhe.shinano
 * @since 2024-02-07
 */
@RestController
@RequestMapping("/bot")
public class BotController {

    @Autowired
    private IBotService botService;


    @PostMapping("/create")
    public Result createBot(@RequestBody CreateBotRequest request) {
        return botService.createBot(request);
    }
}
