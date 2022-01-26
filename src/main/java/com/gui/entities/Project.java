package com.gui.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * <h1>Project entity</h1>
 * <p>Define project objects<p>
 * <p>Class linked to the project database table</p>
 * <p>Object course has a name, a description, a deadline, a related course, a project team.</p>
 */


@Entity
@Table(name = "project")
@NamedQueries({
    @NamedQuery(name = "Project.list", query = "SELECT p FROM Project p"),
    @NamedQuery(name = "Project.findByCourse", query = "SELECT p FROM Project p WHERE p.course.id = :courseId"),
    @NamedQuery(name = "Project.findByName", query = "SELECT p FROM Project p WHERE p.name = :name"),
    @NamedQuery(name = "Project.findByDescription", query = "SELECT p FROM Project p WHERE p.description = :description"),
    @NamedQuery(name = "Project.findByDeadline", query = "SELECT p FROM Project p WHERE p.deadline = :deadline")})
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Column(name = "deadline")
    @Temporal(TemporalType.DATE)
    private Date deadline;
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Course course;
    /*@OneToMany
    private List<Team> teams;*/

    /***************************************************************************
	 |  Constructor
	***************************************************************************/

    /**
     * Empty consctructor
     */

    public Project() {
    }

    /**
     * Constructor of project
     * @param name of type String
     * @param description of type String
     * @param deadline of type Date
     * @param course of type Course
     */

    public Project(String name, String description, Date deadline, Course course) {
    	this.name = name;
    	this.description = description;
    	this.deadline = deadline;
    	this.course = course;
    }

    /***************************************************************************
	 |  Getter & Setter
	***************************************************************************/

    public int getId() {
		return id;
	}

    /**
     * Getter of project's name
     * @return name of type String
     */

	public String getName() {
        return name;
    }

    /**
     * Setter of project's name
     * @param name of type String
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter of project's Description
     * @return description of type String
     */

    public String getDescription() {
        return description;
    }

    /**
     * Setter of project description
     * @param description of type String
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter of project's deadline
     * @return deadline of type Date
     */

    public Date getDeadline() {
        return deadline;
    }

    /**
     * Setter of project's deadline
     * @param deadline of type Date
     */

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    /**
     * Getter of project's related course
     * @return course of type Course
     */

    public Course getCourse() {
        return course;
    }

    /**
     * Setter of project's related course
     * @param course of type Course
     */

    public void setCourse(Course course) {
        this.course = course;
    }


    /***************************************************************************
	 |  Inherited
	***************************************************************************/

    /**
     * Method that hashes project's name
     * @return hash of type int
     */

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    /**
     * Method that returns true if two projects are equal, false otherwise
     * @param object
     * @return boolean
     */

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    /**
     * Method that returns the project's name
     * @return
     */


    @Override
    public String toString() {
        return "com.gui.entities.Project[ name=" + name + " ]";
    }
    
}
