package com.gui.beans.forms;

import com.gui.database.DatabaseFactory;
import com.gui.database.UserORM;
import com.gui.entities.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.time.Instant;
import java.util.Date;

@Named
@RequestScoped
public class CreateUserBean {
    @Inject
    private DatabaseFactory db;

    private String name = "Patate";
    private String surname = "Purée";
    private String email = "frite@freeteuse.com";
    private Date birthdate = Date.from(Instant.now());

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
        System.out.println("create");
        UserORM orm = db.getUserORM();
        orm.create(new User(null, name, surname, "test@aze.fr"));
        return "success";
    }
}
