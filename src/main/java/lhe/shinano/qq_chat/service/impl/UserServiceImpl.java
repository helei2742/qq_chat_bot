package lhe.shinano.qq_chat.service.impl;

import lhe.shinano.qq_chat.entity.User;
import lhe.shinano.qq_chat.mapper.UserMapper;
import lhe.shinano.qq_chat.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lhe.shinano
 * @since 2024-02-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
