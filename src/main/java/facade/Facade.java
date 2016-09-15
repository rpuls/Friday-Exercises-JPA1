package facade;

import entity.*;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author rasmus
 */
public class Facade {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    private static EntityManager em = emf.createEntityManager();

    // Create user
    public void createUser(Projectuser user) {
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Find user
    public Projectuser getProjectuser(int id) {
        return em.find(Projectuser.class, id);
    }

    // Get all users
    public Collection<Projectuser> findAllUsers() {
        Query query = em.createQuery("SELECT p FROM Projectuser p");
        return (Collection<Projectuser>) query.getResultList();
    }

    // Create project
    public void createProject(Project project) {
        try {
            em.getTransaction().begin();
            em.persist(project);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Assign user to project -- update
    public void assignUser(int id, int projectId) {
        Projectuser user = em.find(Projectuser.class, id);
        try {
            em.getTransaction().begin();
            Collection projectCol = user.getProjectCollection();
            projectCol.add(projectId);
            user.setProjectCollection(projectCol);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Find project
    public Project findProject(int id) {
        return em.find(Project.class, id);
    }
    
    // CreateTaskAndAssignToProject
    public void createTastAndAssignToProject(Task task, int projectId){
        try {
            task.setProject(findProject(projectId));
            em.getTransaction().begin();
            em.persist(task);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    // Etc.
}
