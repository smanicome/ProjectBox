package com.gui.beans.view;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.gui.adelete.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Group project page view
 */

@Named
@RequestScoped
public class GroupProject {
    private String groupName;
    private List<Student> teamMembers;
    private List<String> versions;

    /**
     * Constructor of Group project view with test values
     */
    public GroupProject() {
        groupName = "Test group";

        teamMembers = new ArrayList<>();
        /*teamMembers.add(new Student("0", "a", "a", 0, "a@a.com"));
        teamMembers.add(new Student("1", "b", "b", 1, "b@b.com"));*/

        versions = new ArrayList<>();
        versions.add("0.0.1");
        versions.add("0.0.3");
        versions.add("0.1.0");
        versions.add("0.1.2");
        versions.add("0.2.1");
        versions.add("0.2.2");
        versions.add("1.0.0");
    }

    /**
     * Add new student in form and add it to the group team
     * @param newStudent, student type
     */
    public void addTeamMember(Student newStudent) {
        Objects.requireNonNull(newStudent);
        teamMembers.add(newStudent);
    }

    /**
     * Add new project version
     * @param version, string type
     */
    public void addVersion(String version) {
        versions.add(version);
    }

    /**
     * Get list of team members
     * @return List of students
     */

    public List<Student> getTeamMembers() {
        return teamMembers;
    }

    /**
     * Set list of team members
     * @param teamMembers, list of students
     */

    public void setTeamMembers(List<Student> teamMembers) {
        this.teamMembers = teamMembers;
    }

    /**
     * Get list of project versions
     * @return list of strings
     */

    public List<String> getVersions() {
        return versions;
    }

    /**
     * Set List of project versions
     * @param versions, list of strings
     */

    public void setVersions(List<String> versions) {
        this.versions = versions;
    }

    /**
     * Get group name
     * @return String
     */

    public String getGroupName() {
        return groupName;
    }

    /**
     * Set group name
     * @param groupName, String
     */

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * Get notification of submission
     * @return string
     */

    public String getSubmit() {
        return "";
    }

    /**
     * Removes a Student from the list of Students defining the group
     * @param studentId, int, to identify the right student
     * @return string
     */

    public String removeTeamMember(int studentId) {
        teamMembers.removeIf((student) -> student.getId() == studentId);
        return "";
    }

    /**
     * Download chosen version of project
     * @param version
     * @return "success",  go to "success" page
     */

    public String download(String version) {
        return "success";
    }
}
