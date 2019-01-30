package com.mapper;

import com.pojo.Teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 教师Mapper
 * @author 杜先森
 */
public interface TeacherMapper {
    /**
     * 教师登陆
     *
     * @param loginName
     * @param loginpw
     * @return
     */
    @Select("select * from teacher where loginName=#{loginName} and loginPw=#{loginPw}")
    Teacher selTea(@Param("loginName") String loginName, @Param("loginPw") String loginpw);

    /**
     * 查询所有教师
     *
     * @return
     */
    @Select("select *from teacher")
    List<Teacher> selAllTeacher();

    /**
     * 通过Id删除老师
     * @param id
     * @return
     */
    @Delete("delete from teacher where id=#{id}")
    int delTeacherById(int id);
    /**
     * 添加老师
     * @param teacherNum
     * @param teacherName
     * @param teacherSex
     * @param teacherAge
     * @param teacherTitle
     * @param loginName
     * @param loginPw
     * @return
     */
    @Insert("insert into teacher(teacherNum,teacherName,teacherSex,teacherAge,teacherTitle, loginName, loginPw) values(#{teacherNum},#{teacherName},#{teacherSex},#{teacherAge},#{teacherTitle},#{loginName},#{loginPw});")
    int insTeacher(@Param("teacherNum") String teacherNum, @Param("teacherName") String teacherName, @Param("teacherSex") String teacherSex, @Param("teacherAge") String teacherAge, @Param("teacherTitle") String teacherTitle, @Param("loginName") String loginName, @Param("loginPw") String loginPw);
}
