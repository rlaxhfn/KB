package org.scoula.security;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class, SecurityConfig.class})
@Log4j2
class PasswordEncoderTest {

    @Autowired
    private PasswordEncoder encoder;

    @Test
    public void testEncode() {
        String str="1234";
        String enStr = encoder.encode(str);
        log.info("password"+enStr);
        String enStr2 = encoder.encode(str);
        log.info("password"+enStr2);
        log.info("match: "+encoder.matches(str, enStr));
        log.info("match: "+encoder.matches(str, enStr2));
    }
}