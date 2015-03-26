import javax.persistence.*;

@Entity
@Table(name = "ORDER_ITEMS")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "id")
    private Order order;

    @OneToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "id")
    private Product product;

    @Column(name="PRODUCT_AMOUNT")
    private int productAmount;

    public OrderItem(Product product, int productAmount) {
        this.product = product;
        this.productAmount = productAmount;
    }

    public OrderItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", order=" + order +
                ", product=" + product +
                ", productAmount=" + productAmount +
                '}';
    }
}
