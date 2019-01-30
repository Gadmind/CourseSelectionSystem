package com.service.impl;

import com.mapper.AdminMapper;
import com.pojo.Admin;
import com.service.AdminService;

import java.util.List;

/**
 * 管理员功能实现类
 *
 * @author 杜先森
 */
public class AdminServiceImpl implements AdminService {

    private AdminMapper adminMapper;

    /**
     * 查询所有管理员
     *
     * @return
     */
    @Override
    public List<Admin> show() {
        return adminMapper.selAll();
    }

    /**
     * 通过名字查找管理员
     *
     * @param userName
     * @return
     */
    @Override
    public Admin findByName(String userName) {
        return adminMapper.selAdminByName(userName);
    }

    /**
     * 管理员登陆
     *
     * @param userName
     * @param userPw
     * @return
     */
    @Override
    public Admin login(String userName, String userPw) {
        Admin admin = adminMapper.selAdmin(userName, userPw);
        if (admin != null) {
            admin = adminMapper.selAdmin(userName, userPw);
        } else {
            admin = null;
        }
        return admin;
    }

    /**
     * 添加管理员
     *
     * @param userName
     * @param userPw
     * @return
     */
    @Override
    public int add(String userName, String userPw) {
        return adminMapper.insAdmin(userName, userPw);
    }

    /**
     * 通过Id删除管理员
     *
     * @param userId
     * @return
     */
    @Override
    public int delAdmin(int userId) {
        return adminMapper.delAdminById(userId);
    }

    public AdminMapper getAdminMapper() {
        return adminMapper;
    }

    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }
}
