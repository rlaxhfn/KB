package org.scoula.travel.dao;

import org.scoula.database.JDBCUtil;
import org.scoula.travel.domain.TravelImageVO;
import org.scoula.travel.domain.TravelVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TravelDaoImpl implements TravelDao {
    Connection con = JDBCUtil.getConnection();
    public void insert(TravelVO travelVO) {
        String sql="insert into tbl_travel(no,district,title,description,address,phone) values(?,?,?,?,?,?)";
        try(PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, travelVO.getNo());
            ps.setString(2, travelVO.getDistrict());
            ps.setString(3, travelVO.getTitle());
            ps.setString(4, travelVO.getDescription());
            ps.setString(5, travelVO.getAddress());
            ps.setString(6, travelVO.getPhone());
            int cnt=ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void insertImage(TravelImageVO travelImageVO) {
        String sql="insert into tbl_travel_image(filename,travel_no) values(?,?)";
        try(PreparedStatement ps=con.prepareStatement(sql)) {
            ps.setString(1, travelImageVO.getFilename());
            ps.setLong(2, travelImageVO.getTravelNo());
            int cnt=ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int getTotalCount(){
        String sql="select count(*) from tbl_travel";
        try(PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery()){
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<String> getDistricts() {
        List<String> districts = new ArrayList<>();
        String sql="select distinct(district) from tbl_travel order by district";
        try(PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery()){
            while(rs.next()){
                districts.add(rs.getString("district"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return districts;
    }
    private TravelVO map(ResultSet rs) throws SQLException {
        return TravelVO.builder()
                .no(rs.getLong("no"))
                .district(rs.getString("district"))
                .title(rs.getString("title"))
                .description(rs.getString("description"))
                .address(rs.getString("address"))
                .phone(rs.getString("address"))
                .build();
    }
    public List<TravelVO> getTravels() {
        List<TravelVO> travels = new ArrayList<>();
        String sql="select * from tbl_travel order by district, title";
        try(PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery()){
            while(rs.next()){
                TravelVO travelVO = map(rs);
                travels.add(travelVO);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return travels;
    }
    public List<TravelVO> getTravels(int page) {
        List<TravelVO> travels = new ArrayList<>();
        String sql="select * from tbl_travel order by district, title limit ?,?";
        try(PreparedStatement ps=con.prepareStatement(sql)){
            int cnt=10;
            int start=(page-1)*10;
            ps.setInt(1, start);
            ps.setInt(2, cnt);
            try(ResultSet rs=ps.executeQuery()){
                while(rs.next()){
                    TravelVO travelVO = map(rs);
                    travels.add(travelVO);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return travels;
    }
    public List<TravelVO> getTravels(String district) {
        List<TravelVO> travels = new ArrayList<>();
        String sql="select * from tbl_travel where district = ?";
        try(PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1, district);
            try(ResultSet rs=ps.executeQuery()){
                while(rs.next()){
                    TravelVO travelVO = map(rs);
                    travels.add(travelVO);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return travels;
    }
    private TravelImageVO mapImage(ResultSet rs) throws SQLException {
        return TravelImageVO.builder()
                .no(rs.getLong("tino"))
                .filename(rs.getString("filename"))
                .travelNo(rs.getLong("travel_no"))
                .build();
    }
    public Optional<TravelVO> getTravel(Long no) {
        TravelVO travelVO = null;
        String sql= """
                select t.*, ti.no as tino, ti.filename, ti.travel_no from tbl_travel t left outer join tbl_travel_image ti on t.no=ti.travel_no where no = ?;
                """;
        try(PreparedStatement ps=con.prepareStatement(sql)){
            ps.setLong(1, no);
            try(ResultSet rs=ps.executeQuery()){
                if(rs.next()){
                    travelVO = map(rs);
                    List<TravelImageVO> images = new ArrayList<>();
                    try{
                        do {
                            TravelImageVO travelImageVO = mapImage(rs);
                            images.add(travelImageVO);
                        } while(rs.next());
                    } catch (SQLException e) {}
                    travelVO.setImages(images);
                    return Optional.of(travelVO);
                } else {
                    return Optional.empty();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
