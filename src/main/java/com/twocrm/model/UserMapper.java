package com.twocrm.model;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT COUNT(*) FROM temp01 WHERE userId = #{username} AND pw = #{password}")
    int countUserByUsernameAndPassword(@Param("userId") String username, @Param("password") String password);
}