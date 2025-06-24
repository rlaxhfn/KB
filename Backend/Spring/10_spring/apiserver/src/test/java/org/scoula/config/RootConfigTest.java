package org.scoula.config;

import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j2
class RootConfigTest {
    @Autowired
    private DataSource dataSource;

    @Test
    @DisplayName("DataSource connect")
    void dataSource() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            log.info("Connected to database");
            log.info(connection);
        }
    }

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void sqlSessionFactory() {
        try (SqlSession session = sqlSessionFactory.openSession();
            Connection connection = session.getConnection();
        ) {
            log.info(session);
            log.info(connection);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}