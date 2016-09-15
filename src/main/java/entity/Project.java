/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author rasmus
 */
@Entity
@Table(name = "project")
@NamedQueries({
    @NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p"),
    @NamedQuery(name = "Project.findById", query = "SELECT p FROM Project p WHERE p.id = :id"),
    @NamedQuery(name = "Project.findByName", query = "SELECT p FROM Project p WHERE p.name = :name"),
    @NamedQuery(name = "Project.findByDescription", query = "SELECT p FROM Project p WHERE p.description = :description"),
    @NamedQuery(name = "Project.findByCreated", query = "SELECT p FROM Project p WHERE p.created = :created"),
    @NamedQuery(name = "Project.findByLastModified", query = "SELECT p FROM Project p WHERE p.lastModified = :lastModified")})
public class Project implements Serializable {

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
    @Column(name = "created")
    @Temporal(TemporalType.DATE)
    private Date created;
    @Column(name = "lastModified")
    @Temporal(TemporalType.DATE)
    private Date lastModified;
    @JoinTable(name = "relation", joinColumns = {
        @JoinColumn(name = "Project_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "projectUser_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Projectuser> projectuserCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private Collection<Task> taskCollection;

    public Project() {
    }

    public Project(String name, String description, Date created, Date lastModified) {
        this.name = name;
        this.description = description;
        this.created = created;
        this.lastModified = lastModified;
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Collection<Projectuser> getProjectuserCollection() {
        return projectuserCollection;
    }

    public void setProjectuserCollection(Collection<Projectuser> projectuserCollection) {
        this.projectuserCollection = projectuserCollection;
    }

    public Collection<Task> getTaskCollection() {
        return taskCollection;
    }

    public void setTaskCollection(Collection<Task> taskCollection) {
        this.taskCollection = taskCollection;
    }

}
