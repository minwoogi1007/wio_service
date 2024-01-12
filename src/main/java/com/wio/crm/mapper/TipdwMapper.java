package com.wio.crm.mapper;

import com.wio.crm.model.Tipdw;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface TipdwMapper {


    @Select("SELECT * FROM tipdw WHERE userid = #{userid}")
    Tipdw findByUserId(@Param("userid") String userid);

    @Update("UPDATE tipdw SET pw = #{user.pw} WHERE id = #{user.id}")
    void save(@Param("user") Tipdw user);

    @Select("SELECT * FROM tipdw")
    List<Tipdw> findAll();
}
