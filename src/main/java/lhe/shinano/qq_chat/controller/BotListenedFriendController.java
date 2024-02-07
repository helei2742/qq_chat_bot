package lhe.shinano.qq_chat.controller;

import lhe.shinano.qq_chat.dto.Result;
import lhe.shinano.qq_chat.dto.request.AddBotListenedFriendRequest;
import lhe.shinano.qq_chat.service.IBotListenedFriendService;
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
@RequestMapping("/botListenedFriend")
public class BotListenedFriendController {


    @Autowired
    private IBotListenedFriendService botListenedFriendService;


    @PostMapping("/addListenedFriend")
    public Result addBotListenedFriend(@RequestBody AddBotListenedFriendRequest request) {
        return botListenedFriendService.addBotListenedFriend(request);
    }
}
