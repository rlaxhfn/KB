package org.scoula.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
    @Select("SELECT sysdate()")
    public String getTime(); // 어노테이션
    public String getTime2();// xml -> 선호
}
