import javax.persistence.*;

public class Starter {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");

        EntityManager em = emf.createEntityManager();

    }
}
