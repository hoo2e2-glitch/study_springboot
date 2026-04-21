package com.app.ncs.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TimeMapper {
    public String getTime();

    @Select("SELECT CURRENT_TIMESTAMP FROM DUAL")
    public void getTime2();
}
