package com.lintmar.client;

import com.lintmar.client.fallback.UserFallbackClient;
import com.lintmar.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LintMar
 * @date 2022/7/25
 **/
@FeignClient(value = "userservice", fallback = UserFallbackClient.class)
public interface UserClient {
    @RequestMapping("/user/{uid}")
    User getUserByUid(@PathVariable("uid") Integer uid);
}
