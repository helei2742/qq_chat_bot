package lhe.shinano.qq_chat.util;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;

public class GPTInvokeUtil {


    public static String sendQuestion(String apiUrl, JSONArray history, String content) throws IOException {
        JSONObject request = new JSONObject();
        request.put("question", content);
        request.put("history", history);
        return HttpClientUtils.post(apiUrl, request.toJSONString());
    }
}
