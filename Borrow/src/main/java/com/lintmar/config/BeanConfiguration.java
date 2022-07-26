package com.lintmar.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author LintMar
 * @date 2022/7/25
 **/
@Configuration
@LoadBalancerClient(value = "userservice", configuration = LoadBalancerConfiguration.class)
public class BeanConfiguration {
    @Bean
    @LoadBalanced
    public RestTemplate template() {
        return new RestTemplate();
    }
}
