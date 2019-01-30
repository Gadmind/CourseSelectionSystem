package com.servlet;

import com.pojo.Course;
import com.service.CourseService;
import javafx.print.Printer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.misc.Version;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author 杜先森
 * 课程管理
 */
public class CourseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CourseService courseService = (CourseService) context.getBean("courseService");
        String type = request.getParameter("type");
        if (type.equals("courseMana")) {
            List<Course> courses = courseService.showAllCourse();
            request.setAttribute("kechengList", courses);
            request.getRequestDispatcher("/admin/kecheng/kechengMana.jsp").forward(request, response);
        }
        if (type.equals("kechengDel")) {
            String id = request.getParameter("id");
            courseService.delCourseById(Integer.parseInt(id));
            response.sendRedirect("/courseServlet?type=courseMana");
        }
        if (type.equals("courseAdd")) {
            String courseNum = request.getParameter("courseNum");
            String courseName = request.getParameter("courseName");
            String classHour = request.getParameter("classHour");
            courseService.addCourse(courseNum, courseName, classHour);
            response.sendRedirect("/courseServlet?type=courseMana");
        }
        if(type.equals("kechengAll")){
            List<Course> courseList=courseService.showAllCourse();
            request.setAttribute("courselist",courseList);
        }
    }
}
