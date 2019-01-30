package com.service;

import com.pojo.Admin;

import java.util.List;

/**
 * 管理员业务接口
 * @author 杜先森
 */
public interface AdminService {
    /**
     * 展示所有管理员
     *
     * @return
     */
    List<Admin> show();

    /**
     * 通过名字查找管理员
     *
     * @param userName
     * @return
     */
    Admin findByName(String userName);

    /**
     * 管理员登陆
     *
     * @param userName
     * @param userPw
     * @return
     */
    Admin login(String userName, String userPw);

    /**
     * 添加管理员
     *
     * @param userName
     * @param userPw
     * @return
     */
    int add(String userName, String userPw);

    /**
     * 删除管理员
     *
     * @param userId
     * @return
     */
    int delAdmin(int userId);

}
