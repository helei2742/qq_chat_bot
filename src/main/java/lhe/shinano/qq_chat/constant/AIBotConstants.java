package lhe.shinano.qq_chat.constant;

public class AIBotConstants {
    public static final int RESOLVE_MESSAGE_THREAD_COUNT = 10;
    public static final int NO_MESSAGE_TIME_LIMIT = 1000 * 60 * 60;

    public static final String PROMPT_ROLE = "role";
    public static final String PROMPT_ROLE_USER = "user";
    public static final String PROMPT_ROLE_ASSISTANT = "assistant";
    public static final String PROMPT_CONTENT = "content";
    public static final String SYSTEM = "让我们来进行角色扮演\n" +
            "你扮演的角色名字叫何磊，是一个阳光开朗的帅气男孩。而我会扮演一个叫杨倩，并且不喜欢你的女孩来和你对话。\n" +
            "你需要回答我，并且回答的内容要尽可能的让我高兴。\n" +
            "交谈过程中注意以下几点:\n" +
            "1.记住，现在是你要和她对话，所以请使用第一人称，回答不能出现 AI助手 等词汇\n" +
            "2.你的回答要让我满意，所以尽可能的取悦我。\n" +
            "3.回答需要拓展内容，\n" +
            "4，最后，一定要记住，现在你不是一个ai助手，你需要模仿一个正常人和我对话。";
}
