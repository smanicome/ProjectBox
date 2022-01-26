package com.gui.beans.view;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.gui.entities.User;

@Named
@RequestScoped
public class NewTeamMember {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public User getStudent() {
        return null;
    }
}
