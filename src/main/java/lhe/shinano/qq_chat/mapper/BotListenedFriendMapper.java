package lhe.shinano.qq_chat.mapper;

import lhe.shinano.qq_chat.entity.BotListenedFriend;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lhe.shinano
 * @since 2024-02-07
 */
public interface BotListenedFriendMapper extends BaseMapper<BotListenedFriend> {

    void batchInsertIgnore(@Param("botId") Integer botId,
                              @Param("list") List<Long> friendQQList);

    void insertOrUpdate(@Param("botId") Integer botId,
                        @Param("groupNumber") Long groupNumber,
                        @Param("friendQQListStr")String friendQQListStr);
}
