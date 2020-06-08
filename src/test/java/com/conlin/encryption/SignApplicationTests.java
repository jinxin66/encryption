package com.conlin.encryption;

import com.conlin.encryption.config.XjarConfig;
import io.xjar.XCryptos;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SignApplication.class)
class SignApplicationTests {
    @Autowired
    XjarConfig config;

    @Test
    void xjar() throws Exception {
        log.info("{}", config);
        XCryptos.encryption()
                .from(new File(config.getFilePath() + config.getFileName()))
                .use(config.getAlgorithm(), config.getKeysize(), config.getIvsize(), config.getPassword())
                .include("com/conlin/encryption/service/impl/SignServiceImpl.class")
                .exclude("static/**/*")
                .to(new File(config.getToFilePath() + config.getFileName()));
    }

}
