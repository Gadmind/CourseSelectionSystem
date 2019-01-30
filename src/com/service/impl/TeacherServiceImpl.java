package com.service.impl;

import com.mapper.TeacherMapper;
import com.pojo.Teacher;
import com.service.TeacherService;

import java.util.List;

/**
 * 教师业务实现类
 *
 * @author 杜先森
 */
public class TeacherServiceImpl implements TeacherService {
    private TeacherMapper teacherMapper;

    public TeacherMapper getTeacherMapper() {
        return teacherMapper;
    }

    public void setTeacherMapper(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    @Override
    public Teacher login(String loginName, String loginPw) {
        Teacher teacher = teacherMapper.selTea(loginName, loginPw);
        if (teacher != null) {
            teacher = teacherMapper.selTea(loginName, loginPw);
        }
        return teacher;
    }

    @Override
    public List<Teacher> showAllTeacher() {
        return teacherMapper.selAllTeacher();
    }

    @Override
    public int delTeacher(int id) {
        return teacherMapper.delTeacherById(id);
    }

    @Override
    public int addTeacher(String teacherNum, String teacherName, String teacherSex, String teacherAge, String teacherTitle, String loginName, String loginPw) {
        return teacherMapper.insTeacher(teacherNum,teacherName,teacherSex,teacherAge,teacherTitle, loginName, loginPw);
    }
}
