package vladyslav.goit;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyDemo");
        EntityManager em = emf.createEntityManager();

        new Criteria().criteriaSelectParticipant(em);

        em.close();
        emf.close();
    }
}