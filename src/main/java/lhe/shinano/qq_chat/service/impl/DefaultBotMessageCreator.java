package lhe.shinano.qq_chat.service.impl;

import lhe.shinano.qq_chat.service.BotMessageCreator;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Slf4j
public class DefaultBotMessageCreator implements BotMessageCreator {
    private static final List<String> DEFAULT_RESPONSE_ARRAY = Arrays.asList(".", "昂", "...");

    private static final List<String> DEFAULT_HELLO_ARRAY = Arrays.asList("hello", "在吗", "mua");

    private static final Random random = new Random();

    @Override
    public String getDefaultResponse() {
        return DEFAULT_RESPONSE_ARRAY.get(random.nextInt(DEFAULT_RESPONSE_ARRAY.size()));
    }

    @Override
    public String getHelloMessage() {
        return DEFAULT_HELLO_ARRAY.get(random.nextInt(DEFAULT_HELLO_ARRAY.size()));
    }
}
