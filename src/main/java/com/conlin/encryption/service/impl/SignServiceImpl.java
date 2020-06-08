package com.conlin.encryption.service.impl;

import com.conlin.encryption.config.XjarConfig;
import com.conlin.encryption.service.SignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

/**
 * @Description SignServiceImpl
 * @Date 2020/6/3 14:44
 * @Created by R:jinxin
 */
@Slf4j
public class SignServiceImpl implements SignService {
    @Autowired
    XjarConfig config;

    @Override
    public String say() {
        log.info("{} Hello World! {}",LocalDateTime.now(),config);
        return LocalDateTime.now() + "Hello World!";
    }

}
