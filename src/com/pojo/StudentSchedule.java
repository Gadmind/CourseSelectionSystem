package com.pojo;

/**
 * 学生课表实体类
 * @author 杜先森
 */
public class StudentSchedule {
    private int id;
    private int studentId;
    private int scheduleId;
    private Schedule schedule;

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    @Override
    public String toString() {
        return "StudentSchedule{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", scheduleId=" + scheduleId +
                ", schedule=" + schedule +
                '}'+"\n";
    }
}
