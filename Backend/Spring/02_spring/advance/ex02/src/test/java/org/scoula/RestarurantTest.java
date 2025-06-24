package org.scoula;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.scoula.ex02.Restarurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = RootConfig.class)
@Log4j2
class RestarurantTest {
    @Autowired
    private Restarurant restarurant;

    @Test
    void getChef() {
        assertNotNull(restarurant);
        log.info(restarurant);
        log.info("---------------------");
        log.info(restarurant.getChef());
    }
}