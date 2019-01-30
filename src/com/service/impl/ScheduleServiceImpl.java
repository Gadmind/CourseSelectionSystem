package com.service.impl;

import com.mapper.ScheduleMapper;
import com.pojo.Course;
import com.pojo.Schedule;
import com.pojo.StudentSchedule;
import com.pojo.Teacher;
import com.service.ScheduleService;

import java.util.List;

/**
 * 课表业务实现类
 * @author 杜先森
 */
public class ScheduleServiceImpl implements ScheduleService {
    private ScheduleMapper scheduleMapper;

    public ScheduleMapper getScheduleMapper() {
        return scheduleMapper;
    }

    public void setScheduleMapper(ScheduleMapper scheduleMapper) {
        this.scheduleMapper = scheduleMapper;
    }


    @Override
    public List<Schedule> showAll() {
        return scheduleMapper.selAllSchedule();
    }

    @Override
    public Course findCouById(int id) {
        return scheduleMapper.selCouById(id);
    }

    @Override
    public Teacher findTeaById(int id) {
        return scheduleMapper.selTeaById(id);
    }

    @Override
    public List<StudentSchedule> showAllStuSchByStuId(int StudentId) {
        return scheduleMapper.selAllStudentScheduleByStuId(StudentId);
    }

    @Override
    public List<StudentSchedule> showAllStuSch() {
        return scheduleMapper.selAllStudentSchedule();
    }

    @Override
    public Schedule findSchById(int id) {
        return scheduleMapper.selSchById(id);
    }

    @Override
    public int addStudentSchedule(int studentId, int scheduleId) {
        return scheduleMapper.insStudentSchedule(studentId,scheduleId);
    }
}
