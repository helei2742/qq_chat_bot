package lhe.shinano.qq_chat.service.impl;

import com.alibaba.fastjson.JSONObject;
import lhe.shinano.qq_chat.constant.AIBotConstants;
import lhe.shinano.qq_chat.service.PromptService;
import org.springframework.stereotype.Component;


@Component
public class DefaultPromptService implements PromptService {
    private static final JSONObject SYSTEM;
    static {
        SYSTEM = new JSONObject();
        SYSTEM.put("role", "system");
        SYSTEM.put("content", AIBotConstants.SYSTEM);
    }
    @Override
    public JSONObject getSystem(long srcQQ) {
        return SYSTEM;
    }
}
