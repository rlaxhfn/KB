package org.scoula.jdbc_ex.dao;

import org.scoula.jdbc_ex.domain.UserVO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UserDao {
    // user 등록
    int create(UserVO userVO) throws SQLException;
    // user 조회
    List<UserVO> getList() throws SQLException;
    Optional<UserVO> getUser(String id) throws SQLException;
    // user 수정
    int update(UserVO userVO) throws SQLException;
    // user 삭제
    int delete(String id) throws SQLException;
} // 인터페이스 생성
