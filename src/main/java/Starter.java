import javax.persistence.*;

public class Starter {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit1");
        EntityManager em = emf.createEntityManager();

        Product product1 = new Product("Product 1");
        Product product2 = new Product("Product 2");

        em.getTransaction().begin();
        em.persist(product1);
        em.persist(product2);
        em.getTransaction().commit();

        em.getTransaction().begin();
        Order order = new Order();
        order.getOrderItems().add(new OrderItem(product1, 2));
        order.getOrderItems().add(new OrderItem(product2, 3));

        Order order2 = new Order();
        order2.getOrderItems().add(new OrderItem(product2, 5));
        order2.getOrderItems().add(new OrderItem(product1, 2));
        em.persist(order);
        em.persist(order2);
        em.getTransaction().commit();

        em.getTransaction().begin();
        Product p = em.find(Product.class, 2);

        TypedQuery<Order> query = em.createQuery
                ("select o from Order o, in (o.orderItems) as item where item like '%2'", Order.class);
        Order or = query.getSingleResult();
        System.out.println(p + " -------- " + or);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
