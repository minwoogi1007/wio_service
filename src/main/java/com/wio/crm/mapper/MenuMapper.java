package com.wio.crm.mapper;

import com.wio.crm.model.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface MenuMapper {
    List<Menu> findMenusByRole(String userid);
}
