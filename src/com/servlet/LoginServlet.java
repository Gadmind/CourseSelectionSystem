package com.servlet;

import com.pojo.Admin;
import com.pojo.Students;
import com.pojo.Teacher;
import com.service.AdminService;
import com.service.StudentsService;
import com.service.TeacherService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登陆管理
 *
 * @author 杜先森
 */
public class LoginServlet extends HttpServlet {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    AdminService adminService = (AdminService) context.getBean("adminService");
    StudentsService studentsService = (StudentsService) context.getBean("studentsService");
    TeacherService teacherService = (TeacherService) context.getBean("teacherService");

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("userName");
        String userPw = request.getParameter("userPw");
        Integer userType = Integer.parseInt(request.getParameter("userType"));
        HttpSession session = request.getSession();
        session.setAttribute("userType", userType);
        if (userType == 0) {
            if (adminService.login(userName, userPw) != null) {
                Admin admin = adminService.login(userName, userPw);
                session.setAttribute("admin", admin);
                request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
            } else {
                response.sendRedirect("login.jsp");
            }
        }
        if (userType == 1) {
            if (teacherService.login(userName, userPw) != null) {
                Teacher teacher = teacherService.login(userName, userPw);
                session.setAttribute("laoshi", teacher);
                request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
            } else {
                response.sendRedirect("login.jsp");
            }
        }
        if (userType == 2) {
            if (studentsService.login(userName, userPw) != null) {
                Students students = studentsService.login(userName, userPw);
                session.setAttribute("xuesheng", students);
                request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
            } else {
                response.sendRedirect("login.jsp");
            }
        }
    }
}
