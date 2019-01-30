package com.service;

import com.pojo.Course;
import com.pojo.Schedule;
import com.pojo.StudentSchedule;
import com.pojo.Teacher;

import java.util.List;

/**
 * 课表业务接口
 *
 * @author 杜先森
 */
public interface ScheduleService {
    /**
     * 查询所有课表
     *
     * @return
     */
    List<Schedule> showAll();

    /**
     * 通过课程Id查找课程信息
     *
     * @param id
     * @return
     */
    Course findCouById(int id);

    /**
     * 通过教师ID查找教师信息
     *
     * @param id
     * @return
     */
    Teacher findTeaById(int id);

    /**
     * 通过ID查找学生所有选课信息
     *
     * @return
     */
    List<StudentSchedule> showAllStuSchByStuId(int id);

    /**
     * 查找学生所有选课信息
     *
     * @return
     */
    List<StudentSchedule> showAllStuSch();

    /**
     * 通过Id查找课表信息
     *
     * @param id
     * @return
     */
    Schedule findSchById(int id);

    /**
     * 插入学生选课表
     *
     * @param studentId
     * @param scheduleId
     * @return
     */
    int addStudentSchedule(int studentId, int scheduleId);
}
