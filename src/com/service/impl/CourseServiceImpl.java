package com.service.impl;

import com.mapper.CourseMapper;
import com.pojo.Course;
import com.service.CourseService;

import java.util.List;

/**
 * 课程业务实现类
 *
 * @author 杜先森
 */
public class CourseServiceImpl implements CourseService {
    private CourseMapper courseMapper;

    public CourseMapper getCourseMapper() {
        return courseMapper;
    }

    public void setCourseMapper(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    @Override
    public List<Course> showAllCourse() {
        return courseMapper.selCourseList();
    }

    @Override
    public int delCourseById(int id) {
        return courseMapper.delCourseById(id);
    }

    @Override
    public int addCourse(String courseNum, String courseName, String classHour) {
        return courseMapper.insCourse(courseNum, courseName, classHour);
    }
}
