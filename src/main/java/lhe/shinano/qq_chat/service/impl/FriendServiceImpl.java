package lhe.shinano.qq_chat.service.impl;

import lhe.shinano.qq_chat.service.FriendService;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class FriendServiceImpl implements FriendService {
    private static final Map<Long, Set<Long>> FRIEND_QQ_MAP = new HashMap<>();

    static {
        FRIEND_QQ_MAP.put(914577981L, new HashSet<>(Arrays.asList(1786934054L, 123456798L)));
    }


    @Override
    public boolean isQQFriend(long myQQ, long otherQQ) {
        return FRIEND_QQ_MAP.getOrDefault(myQQ, Collections.emptySet()).contains(otherQQ);
    }
}
