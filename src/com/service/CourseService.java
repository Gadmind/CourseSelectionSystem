package com.service;

import com.pojo.Course;

import java.util.List;

/**
 * 课程业务接口
 *
 * @author 杜先森
 */
public interface CourseService {
    /**
     * 展示所有课程
     *
     * @return
     */
    List<Course> showAllCourse();

    /**
     * 通过Id删除课程
     *
     * @param id
     * @return
     */
    int delCourseById(int id);

    /**
     * 添加课程
     *
     * @param courseNum
     * @param courseName
     * @param classHour
     * @return
     */
    int addCourse(String courseNum, String courseName, String classHour);
}
