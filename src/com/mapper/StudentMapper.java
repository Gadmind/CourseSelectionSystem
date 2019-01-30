package com.mapper;

import com.pojo.Students;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 学生Mapper
 * @author 杜先森
 */
public interface StudentMapper {
    /**
     * 学生登陆
     *
     * @param loginName
     * @param loginPw
     * @return
     */
    @Select("select * from student where loginName=#{loginName} and loginPw=#{loginPw}")
    Students selStu(@Param("loginName") String loginName, @Param("loginPw") String loginPw);

    /**
     * 查询所有学生
     *
     * @return
     */
    @Select("select * from student")
    List<Students> selAllStu();

    /**
     * 通过Id删除学生
     *
     * @param id
     * @return
     */
    @Delete("delete from student where id=#{id}")
    int delStuById(int id);

    /**
     * 添加学生
     * @param studentNum
     * @param studentName
     * @param studentSex
     * @param studentAge
     * @param studentClass
     * @param loginName
     * @param loginPw
     * @return
     */
    @Insert("insert into student(studentNum,studentName,studentSex,studentAge,studentClass,loginName,loginPw)values (#{studentNum},#{studentName},#{studentSex},#{studentAge},#{studentClass},#{loginName},#{loginPw})")
    int insStu(@Param("studentNum") String studentNum, @Param("studentName") String studentName, @Param("studentSex") String studentSex, @Param("studentAge") String studentAge, @Param("studentClass") String studentClass, @Param("loginName") String loginName, @Param("loginPw") String loginPw);
}
