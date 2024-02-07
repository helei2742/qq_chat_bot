package lhe.shinano.qq_chat.constant;


import java.util.HashMap;
import java.util.Map;

public enum BaseBotType {

    AI_CHAT_BOT("ai_bot"),
    IMG_SAVE_BOT("img_save_bot")
    ;


    public static boolean exist(String value) {
        String[] split = value.split(SPLIT_SIMPLE);
        for (String s : split) {
            if (!Inner.map.containsKey(s)) {
                return false;
            }
        }
        return true;
    }

    public static final String SPLIT_SIMPLE = ",";

    public final String value;

    BaseBotType(String value) {
        this.value = value;
        Inner.map.put(value, this);
    }


    private static class Inner {
        private static final Map<String, BaseBotType> map = new HashMap<>();
    }
}
