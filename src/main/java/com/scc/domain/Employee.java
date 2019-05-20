package com.scc.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * scc
 * 2019/5/19
 */
public class Employee {
    private Integer id;
    private String username;
    private String password;
    private String realname;
    private String sex;
    private Date hiredate;
    private BigDecimal salary;
    private Integer age;
    private Integer dept_id;

    private Department department;

    public Employee() {
    }

    public Employee(Integer id, String username, String password, String realname, String sex, Date hiredate, BigDecimal salary, Integer age, Integer dept_id) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.sex = sex;
        this.hiredate = hiredate;
        this.salary = salary;
        this.age = age;
        this.dept_id = dept_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", sex='" + sex + '\'' +
                ", hiredate=" + hiredate +
                ", salary=" + salary +
                ", age=" + age +
                ", dept_id=" + dept_id +
                ", department=" + department +
                '}';
    }
}
