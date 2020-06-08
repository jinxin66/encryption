package com.conlin.encryption;

import com.conlin.encryption.config.XjarConfig;
import com.conlin.encryption.loader.ClazzLoader;
import com.conlin.encryption.service.SignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Classname ImplEnableAutoConfiguration
 * @Description TODO
 * @Date 2020/6/3 15:17
 * @Created by R:jinxin
 */
@Slf4j
@Configuration
@ConditionalOnClass(SignService.class)
@EnableConfigurationProperties(value = XjarConfig.class)
public class ImplEnableAutoConfiguration {
    @Autowired
    XjarConfig config;

    @Bean(name = "defSignServiceImpl")
    @ConditionalOnMissingBean(name = "defSignServiceImpl")
    public SignService defSignServiceImpl(){
        log.info("自定义自动装配ImplEnableAutoConfiguration... {}",config);
        SignService signService= null;
        try {
            Class<?> clazz = new ClazzLoader(config).findClass("com.conlin.encryption.service.impl.SignServiceImpl");
            signService = (SignService) clazz.newInstance();
        } catch (Exception e) {
            log.error("类装配失败{}",e.getMessage(),e);
        }
        return signService;
    }
}