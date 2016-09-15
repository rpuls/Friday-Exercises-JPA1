/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author rasmus
 */
@Entity
@Table(name = "task")
@NamedQueries({
    @NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t"),
    @NamedQuery(name = "Task.findById", query = "SELECT t FROM Task t WHERE t.id = :id"),
    @NamedQuery(name = "Task.findByName", query = "SELECT t FROM Task t WHERE t.name = :name"),
    @NamedQuery(name = "Task.findByDescription", query = "SELECT t FROM Task t WHERE t.description = :description"),
    @NamedQuery(name = "Task.findByHoursAssigned", query = "SELECT t FROM Task t WHERE t.hoursAssigned = :hoursAssigned"),
    @NamedQuery(name = "Task.findByHoursUsed", query = "SELECT t FROM Task t WHERE t.hoursUsed = :hoursUsed")})
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "hoursAssigned")
    private Integer hoursAssigned;
    @Column(name = "hoursUsed")
    private Integer hoursUsed;
    @JoinColumn(name = "Project_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Project project;

    public Task() {
    }

    public Task(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getHoursAssigned() {
        return hoursAssigned;
    }

    public void setHoursAssigned(Integer hoursAssigned) {
        this.hoursAssigned = hoursAssigned;
    }

    public Integer getHoursUsed() {
        return hoursUsed;
    }

    public void setHoursUsed(Integer hoursUsed) {
        this.hoursUsed = hoursUsed;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

}
