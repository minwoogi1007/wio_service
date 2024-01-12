package com.wio.crm.mapper;

import com.wio.crm.model.Tcnt01Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Tcnt01EmpMapper {
    @Select("SELECT * FROM tcnt01emp WHERE userid = #{userid}")
    Tcnt01Emp findByUserId(@Param("userid") String userid);
}