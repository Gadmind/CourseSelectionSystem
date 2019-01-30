package com.mapper;

import com.pojo.Admin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 杜先森
 * 管理员功能接口
 */
public interface AdminMapper {
    /**
     * 查询所有管理员
     *
     * @return
     */
    @Select("select * from admin")
    List<Admin> selAll();

    /**
     * 通过用户名查找用户
     *
     * @param userName
     * @return
     */
    @Select("select userName from admin where userName =#{userName}")
    Admin selAdminByName(@Param("userName") String userName);

    /**
     * 用户登录
     *
     * @param userName
     * @param userPw
     * @return
     */
    @Select("select * from admin where userName=#{userName} and userPw=#{userPw}")
    Admin selAdmin(@Param("userName") String userName, @Param("userPw") String userPw);

    /**
     * 添加管理员
     *
     * @param userName
     * @param userPw
     */
    @Insert("INSERT INTO admin(userName,userPw)VALUES(#{userName},#{userPw})")
    int insAdmin(@Param("userName") String userName, @Param("userPw") String userPw);

    /**
     * 通过ID删除管理员
     * @param userId
     * @return
     */
    @Delete("DELETE FROM admin WHERE userId=#{userId}")
    int delAdminById(@Param("userId") int userId);
}
