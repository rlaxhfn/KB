package org.scoula.jdbc_ex.dao;

import org.scoula.jdbc_ex.common.JDBCUtil;
import org.scoula.jdbc_ex.domain.UserVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    Connection con=JDBCUtil.getConnection();
    // 테이블 관련 SQL 명령어
    private String USER_LIST="select * from users";
    private String USER_GET="select * from users where id=?";
    private String USER_INSERT="insert into users values (?,?,?,?)";
    private String USER_UPDATE="update users set name=?,role=? where id=?";
    private String USER_DELETE="delete from users where id=?";
    // user 등록
    public int create(UserVO userVO) throws SQLException {
        try(PreparedStatement ps=con.prepareStatement(USER_INSERT)){
            ps.setString(1,userVO.getId());
            ps.setString(2,userVO.getPassword());
            ps.setString(3,userVO.getName());
            ps.setString(4,userVO.getRole());
            return ps.executeUpdate();
        }
    }
    private UserVO map(ResultSet rs) throws SQLException {
        UserVO userVO=new UserVO();
        userVO.setId(rs.getString("id"));
        userVO.setPassword(rs.getString("password"));
        userVO.setName(rs.getString("name"));
        userVO.setRole(rs.getString("role"));
        return userVO;
    }

    // user 조회
    public List<UserVO> getList() throws SQLException {
        List<UserVO> list=new ArrayList<UserVO>();
        Connection con=JDBCUtil.getConnection();
        try(PreparedStatement ps=con.prepareStatement(USER_LIST)){
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                UserVO userVO=map(rs);
                list.add(userVO);
            }
        }
        return list;
    }
    public Optional<UserVO> getUser(String id) throws SQLException {
        try(PreparedStatement ps=con.prepareStatement(USER_GET)){
            ps.setString(1,id);
            try(ResultSet rs=ps.executeQuery()){
                if(rs.next()){
                    return Optional.of(map(rs));
                }
            }
            return Optional.empty();
        }
    }
    // user 수정
    public int update(UserVO userVO) throws SQLException {
        Connection con=JDBCUtil.getConnection();
        try(PreparedStatement ps=con.prepareStatement(USER_UPDATE)){
            ps.setString(1,userVO.getName());
            ps.setString(2,userVO.getRole());
            ps.setString(3,userVO.getId());
            return ps.executeUpdate();
        }
    }
    // user 삭제
    public int delete(String id) throws SQLException {
        try(PreparedStatement ps=con.prepareStatement(USER_DELETE)){
            ps.setString(1, id);
            return ps.executeUpdate();
        }
    }
}
