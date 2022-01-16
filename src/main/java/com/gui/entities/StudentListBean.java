package com.gui.entities;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;

@Named
@RequestScoped
public class StudentListBean {
    private ArrayList<User> students = new ArrayList<>();

    public StudentListBean() {
        students.add(new User("0", "a", "a", "a@a.com"));
        students.add(new User("1", "b", "b", "b@b.com"));
        students.add(new User("2", "c", "c", "c@c.com"));
        students.add(new User("3", "d", "d", "d@d.com"));
    }

    public ArrayList<User> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<User> students) {
        this.students = students;
    }
}
