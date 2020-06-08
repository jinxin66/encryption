package com.conlin.encryption.loader;

import com.conlin.encryption.config.XjarConfig;
import io.xjar.XCryptos;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

/**
 * @Description ClazzLoader
 * @Date 2020/6/3 14:46
 * @Created by R:jinxin
 */
@Slf4j
public class ClazzLoader extends ClassLoader {
    private XjarConfig config;
    public ClazzLoader(XjarConfig config){
        log.info("ClazzLoader init config {}",config);
        this.config = config;
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        String path = name.replace('.', '/').concat(".class");
        byte[] data = new byte[0];
        try {
            data= XCryptos.decryption()
                    .from(new File(config.getToFilePath()+config.getFileName()))
                    .use(config.getAlgorithm(), config.getKeysize(), config.getIvsize(), config.getPassword())
                    .toClazz(path);
        } catch (Exception e) {
            log.error("自定义ClazzLoader解密失败 {}",e.getMessage(),e);
        }
        return super.defineClass(name, data, 0, data.length);
    }
}