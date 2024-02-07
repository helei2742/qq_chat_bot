package lhe.shinano.qq_chat.util;

import cn.hutool.core.util.StrUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class ListenedFriendUtil {

    public static Set<Long> generateListenedFriendtoSet(String listStr) {
        if(StrUtil.isBlank(listStr)) return Collections.emptySet();
        return Arrays.stream(listStr.split(",")).map(Long::parseLong).collect(Collectors.toSet());
    }

    public static String generateListenedFriendToStr(Set<Long> newPeoples) {
        return newPeoples == null ? "" :
                newPeoples.stream().map(String::valueOf).collect(Collectors.joining(","));
    }
}
