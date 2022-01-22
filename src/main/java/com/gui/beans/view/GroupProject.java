package com.gui.beans.view;

import javax.el.MethodExpression;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.gui.adelete.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Named
@RequestScoped
public class GroupProject {
    private String groupName;
    private List<Student> teamMembers;
    private List<String> versions;

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

    public void addTeamMember(Student newStudent) {
        Objects.requireNonNull(newStudent);
        teamMembers.add(newStudent);
    }

    public void addVersion(String version) {
        versions.add(version);
    }

    public List<Student> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<Student> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public List<String> getVersions() {
        return versions;
    }

    public void setVersions(List<String> versions) {
        this.versions = versions;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getSubmit() {
        return "";
    }

    public String removeTeamMember(int studentId) {
        teamMembers.removeIf((student) -> student.getId() == studentId);
        return "";
    }

    public String download(String version) {
        return "success";
    }
}
