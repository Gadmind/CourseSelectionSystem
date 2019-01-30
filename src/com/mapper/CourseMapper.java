package com.mapper;

import com.pojo.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 杜先森
 * 课程MApper
 */
public interface CourseMapper {
    /**
     * 查询所有课程
     *
     * @return
     */
    @Select("select  * from course")
    List<Course> selCourseList();

    /**
     * 通过ID删除课程
     *
     * @param id
     * @return
     */
    @Delete("delete from course where id=#{id}")
    int delCourseById(@Param("id") int id);

    /**
     * 添加新的课程
     *
     * @param courseNum
     * @param courseName
     * @param classHour
     * @return
     */
    @Insert("insert into course(courseNum,courseName,classHour) values (#{courseNum},#{courseName},#{classHour})")
    int insCourse(@Param("courseNum") String courseNum, @Param("courseName") String courseName, @Param("classHour") String classHour);
}
