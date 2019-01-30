package com.servlet;

import com.pojo.Teacher;
import com.service.TeacherService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 教师功能管理
 * @author 杜先森
 */
public class TeacherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TeacherService teacherService = (TeacherService) context.getBean("teacherService");
        String type = request.getParameter("type");
        if (type.equals("laoshiMana")) {
            List<Teacher> teachers = teacherService.showAllTeacher();
            request.setAttribute("laoshiList", teachers);
            request.getRequestDispatcher("/admin/laoshi/laoshiMana.jsp").forward(request, response);
        }
        if (type.equals("laoshiDel")) {
            String id = request.getParameter("id");
            teacherService.delTeacher(Integer.parseInt(id));
            response.sendRedirect("/teacherServlet?type=laoshiMana");
        }
        if (type.equals("laoshiAdd")) {
            String teacherNum = request.getParameter("teacherNum");
            String teacherName = request.getParameter("teacherName");
            String teacherSex = request.getParameter("teacherSex");
            String teacherAge = request.getParameter("teacherAge");
            String teacherTitle = request.getParameter("teacherTitle");
            String loginName = request.getParameter("loginName");
            String loginPw = request.getParameter("loginPw");
            teacherService.addTeacher(teacherNum, teacherName, teacherSex, teacherAge, teacherTitle, loginName, loginPw);
            response.sendRedirect("/teacherServlet?type=laoshiMana");
        }
        if (type.equals("laoshiAll")) {
            teacherService.showAllTeacher();
        }
    }
}
