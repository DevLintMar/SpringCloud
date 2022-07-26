package com.lintmar.client.fallback;

import com.lintmar.client.UserClient;
import com.lintmar.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author LintMar
 * @date 2022/7/26
 **/
@Slf4j
@Component
public class UserFallbackClient implements UserClient {
    @Override
    public User getUserByUid(Integer uid) {
        log.warn("User Service Error");
        User user = new User();
        user.setUid(uid);
        user.setName("服务器异常");
        user.setAge(-1);
        user.setSex("未知");
        return user;
    }
}
