package com.servlet;


import com.pojo.Admin;
import com.service.AdminService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.faces.application.ApplicationFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

/**
 * 管理员功能管理
 *
 * @author 杜先森
 */
public class AdminServlet extends HttpServlet {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    AdminService adminService = (AdminService) context.getBean("adminService");

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String type = request.getParameter("type");
        if (type.equals("adminMana")) {
            List<Admin> aList = adminService.show();
            request.setAttribute("adminList", aList);
            request.getRequestDispatcher("admin/admin/adminMana.jsp").forward(request, response);
        }
        if (type.equals("adminAdd")) {
            String userName = request.getParameter("userName");
            String userPw = request.getParameter("userPw");
            if (adminService.findByName(userName) != null) {
                response.sendRedirect("admin/admin/adminAdd.jsp");
            } else {
                adminService.add(userName, userPw);
                response.sendRedirect("/adminServlet?type=adminMana");
            }
        }
        if (type.equals("adminDel")) {
            String use = request.getParameter("userId");
            adminService.delAdmin(Integer.parseInt(use));
            response.sendRedirect("/adminServlet?type=adminMana");

        }
    }
}
