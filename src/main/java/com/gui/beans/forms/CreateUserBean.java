package com.gui.beans.forms;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;

import com.gui.database.DatabaseFactory;
import com.gui.database.StudentDaoInterface;
import com.gui.entities.Student;

import java.util.Date;

@Named
@RequestScoped
public class CreateUserBean {
    @Inject
    private DatabaseFactory db;

    private String name = "";
    private String surname = "";
    private String email = "";
    private Date birthdate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String saveUser() {
        System.out.println("new user");
        StudentDaoInterface dao = db.getStudentDAO();
        
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
        String pwd = RandomStringUtils.random( 15, characters );
        Student student = new Student( name, surname, DigestUtils.sha1Hex(pwd), email );
        
        dao.create( student );
        return "success";
    }
}
