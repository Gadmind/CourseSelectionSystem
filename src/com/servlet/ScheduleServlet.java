package com.servlet;

import com.pojo.*;
import com.service.ScheduleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 课表功能管理
 * @author 杜先森
 *
 */
public class ScheduleServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ScheduleService scheduleService = (ScheduleService) context.getBean("scheduleService");
        String type = request.getParameter("type");
        HttpSession session = request.getSession();
        Students students = (Students) session.getAttribute("xuesheng");

        List<Schedule> sl = new ArrayList<>();
        for (Schedule schedule : scheduleService.showAll()) {
            Teacher teacher = scheduleService.findTeaById(schedule.getTeacherId());
            Course course = scheduleService.findCouById(schedule.getCourseId());
            schedule.setTeacher(teacher);
            schedule.setCourse(course);
            sl.add(schedule);
        }
        if (type.equals("kebiaoMana")) {
            request.setAttribute("kebiaoList", sl);
            request.getRequestDispatcher("/admin/kebiao/kebiaoMana.jsp").forward(request, response);
        }
        if (type.equals("kebiaoAll")) {
            request.setAttribute("kebiaoList", sl);
            request.getRequestDispatcher("/admin/kebiao/kebiaoAll.jsp").forward(request, response);
        }
        if (type.equals("kebiaoAll1")) {
            request.setAttribute("kebiaoList", sl);
            request.getRequestDispatcher("/admin/kebiao/kebiaoAll1.jsp").forward(request, response);
        }
        if (type.equals("kebiao_mana_stu")) {
            List<StudentSchedule> studentSchedules = new ArrayList<>();
            int StudentId = students.getId();
            for (StudentSchedule studentSchedule : scheduleService.showAllStuSchByStuId(StudentId)) {
                Schedule schedule = scheduleService.findSchById(studentSchedule.getScheduleId());
                Teacher teacher = scheduleService.findTeaById(schedule.getTeacherId());
                Course course = scheduleService.findCouById(schedule.getCourseId());
                schedule.setTeacher(teacher);
                schedule.setCourse(course);
                studentSchedule.setSchedule(schedule);
                studentSchedules.add(studentSchedule);
            }
            request.setAttribute("xuesheng_kebiao_list", studentSchedules);
            request.getRequestDispatcher("/axuesheng/kebiao/kebiao_mana_stu.jsp").forward(request, response);
        }
        if (type.equals("kebiao_xuanze_stu")) {
            int StudentId = students.getId();
            String scheduleId = request.getParameter("kebiao_id");
            scheduleService.addStudentSchedule(StudentId, Integer.parseInt(scheduleId));
            response.sendRedirect("/scheduleServlet?type=kebiao_mana_stu");
        }
    }
}
