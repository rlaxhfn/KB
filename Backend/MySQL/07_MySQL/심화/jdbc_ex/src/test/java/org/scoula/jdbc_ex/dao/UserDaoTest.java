package org.scoula.jdbc_ex.dao;

import org.junit.jupiter.api.*;
import org.scoula.jdbc_ex.common.JDBCUtil;
import org.scoula.jdbc_ex.domain.UserVO;

import java.sql.SQLException;
import java.util.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();

    @AfterAll
    static void tearDown(){
        JDBCUtil.close();
    }

    @Test
    @DisplayName("user 등록")
    @Order(1)
    void create() throws SQLException {
        UserVO userVO = new UserVO("ssamz3","ssamz123","쌤즈","ADMIN");
        int cnt = userDao.create(userVO);
        Assertions.assertEquals(1,cnt);
    }
    @Test
    @DisplayName("user 조회")
    @Order(2)
    void getList() throws SQLException {
        List<UserVO> list = userDao.getList();
        for(UserVO userVO : list){
            System.out.println(userVO);
        }
    }
    @Test
    @DisplayName("user 추출")
    @Order(3)
    void getUser() throws SQLException {
        UserVO user = userDao.getUser("ssamz3").orElseThrow(NoSuchElementException::new);
        Assertions.assertNotNull(user);
    }
    @Test
    @DisplayName("user 수정")
    @Order(4)
    void update() throws SQLException {
        UserVO user = userDao.getUser("ssamz3").orElseThrow(NoSuchElementException::new);
        user.setName("쌤즈");
        int cnt = userDao.update(user);
        Assertions.assertEquals(1, cnt);
    }
    @Test
    @DisplayName("user 삭제")
    @Order(5)
    void delete() throws SQLException {
        int cnt = userDao.delete("ssamz3");
        Assertions.assertEquals(1, cnt);
    }
}
