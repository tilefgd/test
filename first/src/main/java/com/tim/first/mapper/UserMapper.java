package com.tim.first.mapper;

import com.tim.first.vo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select id,name,admin,password from register where admin=#{admin}")
    User selectByUseradmin(String admin);
    @Insert("insert into register values(null,#{name},#{admin},#{password},#{email}, #{phone})")
    void insert(User user1);


}
