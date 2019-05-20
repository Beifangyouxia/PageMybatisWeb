package com.scc.domain;

import java.util.List;

/**
 * scc
 * 2019/5/19
 */
public class Department {
    private Integer id;
    private String dname;
    private String note;
    private Integer count;

    private List<Employee> employees;

    public Department() {
    }

    public Department(Integer id, String dname, String note, Integer count) {
        this.id = id;
        this.dname = dname;
        this.note = note;
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", dname='" + dname + '\'' +
                ", note='" + note + '\'' +
                ", count=" + count +
                ", employees=" + employees +
                '}';
    }
}
