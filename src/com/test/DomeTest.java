package com.test;

import com.mapper.AdminMapper;
import com.pojo.*;
import com.service.AdminService;
import com.service.CourseService;
import com.service.ScheduleService;
import com.service.StudentsService;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sound.midi.Soundbank;
import java.util.List;

/**
 * 瞎鸡儿测试
 * @author 杜先森
 */
public class DomeTest {
    private Logger logger = Logger.getLogger(DomeTest.class);
    private AdminMapper adminMapper;

    public AdminMapper getAdminMapper() {
        return adminMapper;
    }

    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void all() throws RuntimeException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ScheduleService scheduleService = (ScheduleService) context.getBean("scheduleService");
        List<Schedule> sl = scheduleService.showAll();
        for (Schedule schedule : scheduleService.showAll()) {
            Course cou = scheduleService.findCouById(schedule.getCourseId());
            Teacher tea = scheduleService.findTeaById(schedule.getTeacherId());
            sl.add(schedule);
//            System.out.println("课程编号：" + cou.getCourseNum() + " 课程名称：" + cou.getCourseName() + " 老师名字：" + tea.getTeacherName());
        }
        System.out.println(sl);
    }

}
