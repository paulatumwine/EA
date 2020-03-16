import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppMain {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        /* Reads META-INF/persistence.xml and looks for specified unit name */

        emf = Persistence.createEntityManagerFactory("edu.mum.cs");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Student student = new Student();
        Enrollment enrollment = new Enrollment();
        Course course = new Course();
        enrollment.setCourse(course);
        enrollment.setStudent(student);

        em.persist(enrollment);

        em.getTransaction().commit();
        emf.close();
    }

}
