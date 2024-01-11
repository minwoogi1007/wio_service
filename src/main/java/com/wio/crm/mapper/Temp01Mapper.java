package com.wio.crm.mapper;

import com.wio.crm.model.Temp01;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Temp01Mapper {
    @Select("SELECT * FROM temp01 WHERE userid = #{userid}")
    Temp01 findByUserId(String userid);
}
