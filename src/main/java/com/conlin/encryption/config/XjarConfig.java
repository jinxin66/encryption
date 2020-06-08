package com.conlin.encryption.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;

/**
 * @Description XjarConfig
 * @Date 2020/6/3 14:52
 * @Created by R:jinxin
 */
@Data
@Configuration
//@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "xjar")
public class XjarConfig {
    private String filePath;
    private String toFilePath;
    private String toFileToPath;
    private String fileName;
    private String password;
    private String algorithm;
    private Integer keysize;
    private Integer ivsize;
}
