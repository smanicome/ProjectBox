package com.example.jsf.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;

@Named
@RequestScoped
public class StudentListBean {
    private ArrayList<Student> students = new ArrayList<>();

    public StudentListBean() {
        students.add(new Student("0", "a", "a", "a@a.com"));
        students.add(new Student("1", "b", "b", "b@b.com"));
        students.add(new Student("2", "c", "c", "c@c.com"));
        students.add(new Student("3", "d", "d", "d@d.com"));
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
