package lhe.shinano.qq_chat.service;

import com.alibaba.fastjson.JSONArray;

import java.io.IOException;

public interface AIService {

    JSONArray queryHistory(long srcQQ, long targetQQ);
    String gotAIResponse(long srcQQ, long targetQQ, String question) throws IOException;

}
