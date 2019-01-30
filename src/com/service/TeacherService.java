package com.service;

import com.pojo.Teacher;

import java.util.List;

/**
 * 教师业务接口
 *
 * @author 杜先森
 */
public interface TeacherService {
    /**
     * 教师登陆
     *
     * @param loginName
     * @param loginPw
     * @return
     */
    Teacher login(String loginName, String loginPw);

    /**
     * 展示所有教师
     *
     * @return
     */
    List<Teacher> showAllTeacher();

    /**
     * 通过ID删除教师
     *
     * @param id
     * @return
     */
    int delTeacher(int id);

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
    int addTeacher(String teacherNum, String teacherName, String teacherSex, String teacherAge, String teacherTitle, String loginName, String loginPw);
}
