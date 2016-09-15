/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author rasmus
 */
@Entity
@Table(name = "projectuser")
@NamedQueries({
    @NamedQuery(name = "Projectuser.findAll", query = "SELECT p FROM Projectuser p"),
    @NamedQuery(name = "Projectuser.findById", query = "SELECT p FROM Projectuser p WHERE p.id = :id"),
    @NamedQuery(name = "Projectuser.findByUsername", query = "SELECT p FROM Projectuser p WHERE p.username = :username"),
    @NamedQuery(name = "Projectuser.findByEmail", query = "SELECT p FROM Projectuser p WHERE p.email = :email"),
    @NamedQuery(name = "Projectuser.findByCreated", query = "SELECT p FROM Projectuser p WHERE p.created = :created")})
public class Projectuser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "created")
    @Temporal(TemporalType.DATE)
    private Date created;
    @ManyToMany(mappedBy = "projectuserCollection")
    private Collection<Project> projectCollection;

    public Projectuser() {
    }

    public Projectuser(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Collection<Project> getProjectCollection() {
        return projectCollection;
    }

    public void setProjectCollection(Collection<Project> projectCollection) {
        this.projectCollection = projectCollection;
    }

}
