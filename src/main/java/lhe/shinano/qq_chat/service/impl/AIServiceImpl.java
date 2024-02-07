package lhe.shinano.qq_chat.service.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lhe.shinano.qq_chat.config.ChatAIConfig;
import lhe.shinano.qq_chat.constant.AIBotConstants;
import lhe.shinano.qq_chat.service.AIService;
import lhe.shinano.qq_chat.service.PromptService;
import lhe.shinano.qq_chat.util.GPTInvokeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class AIServiceImpl implements AIService {

    private final static Map<String, JSONArray> histroyMap = new ConcurrentHashMap<>();

    @Autowired
    private ChatAIConfig chatAIConfig;

    @Autowired
    private PromptService promptService;

    @Override
    public JSONArray queryHistory(long srcQQ, long targetQQ) {
        String key = generateHistoryKey(srcQQ, targetQQ);
        return histroyMap.compute(key, (k, v) -> {
            if (v == null) {
                v = new JSONArray();
                v.add(promptService.getSystem(srcQQ));
            }

            return v;
        });
    }

    private String generateHistoryKey(long srcQQ, long targetQQ) {
        return srcQQ + "@->" + targetQQ;
    }

    @Override
    public String gotAIResponse(long srcQQ, long targetQQ, String question) throws IOException {
        JSONArray history = queryHistory(srcQQ, targetQQ);
        String response = GPTInvokeUtil.sendQuestion(chatAIConfig.getApiUrl(), history, question);

        String responseContent = selectResponseContent(response);

        addHistory(question, history, responseContent);

        return responseContent;
    }

    private static void addHistory(String question, JSONArray history, String responseContent) {
        if (StrUtil.isBlank(responseContent)) return;

        JSONObject jb = new JSONObject();
        jb.put(AIBotConstants.PROMPT_ROLE, AIBotConstants.PROMPT_ROLE_USER);
        jb.put(AIBotConstants.PROMPT_CONTENT, question);
        history.add(jb);
        JSONObject jb2 = new JSONObject();
        jb2.put(AIBotConstants.PROMPT_ROLE, AIBotConstants.PROMPT_ROLE_ASSISTANT);
        jb2.put(AIBotConstants.PROMPT_CONTENT, responseContent);
        history.add(jb2);
    }

    private String selectResponseContent(String response) {
        return JSONObject.parseObject(response).getString("response");
    }
}
