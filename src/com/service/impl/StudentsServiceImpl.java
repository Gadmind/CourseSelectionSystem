package com.service.impl;

import com.mapper.StudentMapper;
import com.pojo.Admin;
import com.pojo.Students;
import com.service.StudentsService;

import java.util.List;

/**
 * 学生功能实现类
 * @author 杜先森
 */
public class StudentsServiceImpl implements StudentsService {
    private StudentMapper studentMapper;

    public StudentMapper getStudentMapper() {
        return studentMapper;
    }

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public Students login(String loginName, String loginPw) {
        Students students=studentMapper.selStu(loginName,loginPw);
        if (students!= null) {
            students=studentMapper.selStu(loginName, loginPw);
        }
        return students;
    }

    @Override
    public List<Students> showAllStu() {
        return studentMapper.selAllStu();
    }

    @Override
    public int delStu(int id) {
        return studentMapper.delStuById(id);
    }

    @Override
    public int addStu(String studentNum, String studentName, String studentSex, String studentAge, String studentClass, String loginName, String loginPw) {
        return studentMapper.insStu(studentNum,studentName,studentSex,studentAge,studentClass,loginName,loginPw);
    }
}
