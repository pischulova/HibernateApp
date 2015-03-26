import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(value=TemporalType.DATE)
    private Date date;

    private String name;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="ORDER_ID")
    private List<OrderItem> orderItems = new ArrayList<>();

    public Order() {
        this.date = new Date();
        this.name = this.date.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", orderItems=" + orderItems +
                '}';
    }
}
