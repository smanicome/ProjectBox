/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gui.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

import com.gui.adelete.Student;

/**
 * <h1>Team Entity</h1>
 * <p>Defines team objects based on the related table on the database</p>
 * <p>A team has an id, a name, a collection of students and a related project</p>
 */

@Entity
@Table(name = "team")
@NamedQueries({
        @NamedQuery(name = "Team.findAll", query = "SELECT t FROM Team t"),
        @NamedQuery(name = "Team.findByName", query = "SELECT t FROM Team t WHERE t.name = :name")})
public class Team implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "teams")
    private Collection<Student> students;
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Project project;

    /**
     * Empty constructor
     */

    public Team() {
    }

    /**
     * Constructor taking a name parameter
     * @param name of type String
     */

    public Team(String name) {
        this.name = name;
    }

    /**
     * Getter of team id
     * @return id of type int
     */

    public int getId() {
        return id;
    }

    /**
     * Setter of team id
     * @param id of type int
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter of team's Project
     * @return project of type Project
     */

    public Project getProject() {
        return project;
    }

    /**
     * Setter of team's Project
     * @param project of type Project
     */

    public void setProject(Project project) {
        this.project = project;
    }

    /**
     * Getter of team name
     * @return name of type String
     */

    public String getName() {
        return name;
    }

    /**
     * Setter of team name
     * @param name of type String
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter of students of the team
     * @return a collection of Students
     */

    public Collection<Student> getStudents() {
        return students;
    }

    /**
     * Setter of the students of the team
     * @param students, a collection of Students
     */

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }

    /**
     * method used to hash the team's name
     * @return hashed name of type int
     */

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    /**
     * Method that compares two objects to see if they are equal
     * @param object
     * @return true if the two objects are equal, false otherwise
     */

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Team)) {
            return false;
        }
        Team other = (Team) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    /**
     * toString method of team class
     * @return name of project, type String
     */

    @Override
    public String toString() {
        return "com.gui.entities.Team[ name=" + name + " ]";
    }

}