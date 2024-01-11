package com.wio.crm.mapper;

import com.wio.crm.model.Tipdw;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TipdwMapper {
    @Select("SELECT * FROM tipdw WHERE USERID = #{id}")
    Tipdw findById(String id);
}
