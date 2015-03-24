import javax.persistence.*;

public class Starter {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit1");

        EntityManager em = emf.createEntityManager();

        Order order = new Order();
        order.getOrderItems().add(new OrderItem(1, 3));
        em.persist(order);
    }
}
