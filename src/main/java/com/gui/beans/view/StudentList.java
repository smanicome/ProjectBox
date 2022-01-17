package com.gui.beans.view;

import com.gui.entities.Student;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;

@Named
@RequestScoped
public class StudentList {
    private ArrayList<Student> students = new ArrayList<>();

    public StudentList() {
        students.add(new Student("0", "a", "a", 0, "a@a.com"));
        students.add(new Student("1", "b", "b", 1, "b@b.com"));
        students.add(new Student("2", "c", "c", 2, "c@c.com"));
        students.add(new Student("3", "d", "d", 3, "d@d.com"));
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
