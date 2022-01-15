package com.example.jsf.beans;

import javax.el.MethodExpression;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Named
@RequestScoped
public class GroupProjectBean {
    private String groupName;
    private List<Student> teamMembers;
    private List<Version> versions;

    public GroupProjectBean() {
        groupName = "Test group";

        teamMembers = new ArrayList<>();
        teamMembers.add(new Student("0", "a", "a", "a@a.com"));
        teamMembers.add(new Student("0", "b", "b", "b@b.com"));

        versions = new ArrayList<>();
        versions.add(new Version("0.0.1"));
        versions.add(new Version("0.0.3"));
        versions.add(new Version("0.1.0"));
        versions.add(new Version("0.1.2"));
        versions.add(new Version("0.2.1"));
        versions.add(new Version("0.2.2"));
        versions.add(new Version("1.0.0"));
    }

    public void addTeamMember(Student newStudent) {
        Objects.requireNonNull(newStudent);
        teamMembers.add(newStudent);
    }

    public void addVersion(Version version) {
        versions.add(version);
    }

    public List<Student> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<Student> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public List<Version> getVersions() {
        return versions;
    }

    public void setVersions(List<Version> versions) {
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

    public String removeTeamMember(String studentId) {
        teamMembers.removeIf((student) -> student.getId().equals(studentId));
        return "";
    }
}
