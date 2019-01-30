package com.service;

import com.pojo.Students;

import java.util.List;

/**
 * 学生业务接口
 *
 * @author 杜先森
 */
public interface StudentsService {
    /**
     * 学生登陆
     *
     * @param loginName
     * @param loginPw
     * @return
     */
    Students login(String loginName, String loginPw);

    /**
     * 所有学生
     *
     * @return
     */
    List<Students> showAllStu();

    /**
     * 删除学生
     *
     * @param id
     * @return
     */
    int delStu(int id);

    /**
     * 添加学生
     *
     * @param studentNum
     * @param studentName
     * @param studentSex
     * @param studentAge
     * @param studentClass
     * @param loginName
     * @param loginPw
     * @return
     */
    int addStu(String studentNum, String studentName, String studentSex, String studentAge, String studentClass, String loginName, String loginPw);
}
