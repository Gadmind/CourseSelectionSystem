package com.servlet;

import com.pojo.Students;
import com.service.ScheduleService;
import com.service.StudentsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 学生功能管理
 * @author 杜先森
 */
public class StudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentsService studentService = (StudentsService) context.getBean("studentsService");
        String type = request.getParameter("type");
        if(type.equals("xueshengMana")){
            List<Students> students = studentService.showAllStu();
            request.setAttribute("xueshengList",students);
            request.getRequestDispatcher("/admin/xuesheng/xueshengMana.jsp").forward(request,response);
        }if(type.equals("xueshengDel")){
            String id = request.getParameter("id");
            studentService.delStu(Integer.parseInt(id));
            response.sendRedirect("/studentServlet?type=xueshengMana");
        }
        if(type.equals("xueshengAdd")){
            String studentNum = request.getParameter("studentNum");
            String studentName = request.getParameter("studentName");
            String studentSex = request.getParameter("studentSex");
            String studentAge = request.getParameter("studentAge");
            String studentClass = request.getParameter("studentClass");
            String loginName = request.getParameter("loginName");
            String loginPw = request.getParameter("loginPw");
            studentService.addStu(studentNum,studentName,studentSex,studentAge,studentClass,loginName,loginPw);
            response.sendRedirect("/studentServlet?type=xueshengMana");

        }
    }
}
