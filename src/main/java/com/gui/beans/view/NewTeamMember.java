package com.gui.beans.view;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.gui.entities.User;

/**
 *  Create a new team member
 */
@Named
@RequestScoped
public class NewTeamMember {
    private String value;

    /**
     * get value of team member
     * @return String
     */

    public String getValue() {
        return value;
    }

    /**
     * Set value of team member
     * @param value, String
     */

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Get Student
     * @return null
     */

    public User getStudent() {
        return null;
    }
}
