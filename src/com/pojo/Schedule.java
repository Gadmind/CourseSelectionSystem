package com.pojo;


/**
 * 课表实体类
 * @author 杜先森
 */
public class Schedule {
    private int id;
    private int courseId;
    private String scheduleTime;
    private String section;
    private String classRoom;
    private int teacherId;
    private Course course;
    private Teacher teacher;


    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String setion) {
        this.section = setion;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", scheduleTime='" + scheduleTime + '\'' +
                ", section='" + section + '\'' +
                ", classRoom='" + classRoom + '\'' +
                ", teacherId=" + teacherId +
                ", course=" + course +
                ", teacher=" + teacher +
                '}'+"\n";
    }
}
