package com.mapper;

import com.pojo.Course;
import com.pojo.Schedule;
import com.pojo.StudentSchedule;
import com.pojo.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 课表Mapper
 *
 * @author 杜先森
 */
public interface ScheduleMapper {
    /**
     * 查找所有课表
     *
     * @return
     */
    @Select("select * from schedule")
    List<Schedule> selAllSchedule();

    /**
     * 通过Id查课程编号名称
     *
     * @param id
     * @return
     */
    @Select("select courseNum,courseName,classHour from course where id=#{id}")
    Course selCouById(@Param("id") int id);

    /**
     * 通过Id查询老师名字
     *
     * @param id
     * @return
     */
    @Select("select teacherName from teacher where id=#{id}")
    Teacher selTeaById(int id);

    /**
     * 查看所有学生选课信息
     *
     * @return
     */
    @Select("select * from studentSchedule where studentId=#{studentId}")
    List<StudentSchedule> selAllStudentScheduleByStuId(@Param("studentId") int studentId);

    @Select("select * from studentSchedule")
    List<StudentSchedule> selAllStudentSchedule();
    /**
     * 通过Id查找课表
     *
     * @param id
     * @return
     */
    @Select("select * from schedule where id=#{id}")
    Schedule selSchById(@Param("id") int id);

    /**
     * 插入学生选课表
     *
     * @param studentId
     * @param scheduleId
     * @return
     */
    @Insert("insert into studentSchedule(studentId,scheduleId) values (#{studentId},#{scheduleId})")
    int insStudentSchedule(@Param("studentId") int studentId, @Param("scheduleId") int scheduleId);
}
