package com.pojo;

/**
 * 学生实体类
 * @author 杜先森
 */
public class Students {
    /**
     * id int(11) NOT NULL学生ID
     * studentNum varchar(50) NULL学生编号
     * studentName varchar(50) NULL学生名字
     * studentSex varchar(50) NULL学生性别
     * studentAge varchar(50) NULL学生年龄
     * studentClass varchar(50) NULL学生班级
     * loginName varchar(50) NULL学生登录名
     * loginPw varchar(50) NULL登陆密码
     */
    private int id;
    private String studentNum;
    private String studentName;
    private String studentSex;
    private String studentAge;
    private String studentClass;
    private String loginName;
    private String loginPw;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    public String getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(String studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPw() {
        return loginPw;
    }

    public void setLoginPw(String loginPw) {
        this.loginPw = loginPw;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", studentNum='" + studentNum + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentSex='" + studentSex + '\'' +
                ", studentAge='" + studentAge + '\'' +
                ", studentClass='" + studentClass + '\'' +
                ", loginName='" + loginName + '\'' +
                ", loginPw='" + loginPw + '\'' +
                '}';
    }
}
