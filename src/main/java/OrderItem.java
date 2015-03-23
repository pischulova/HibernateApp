import javax.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    private int productAmount;

//    public OrderItem(int productId, int productAmount) {
//        this.product = product;
//        this.productAmount = productAmount;
//    }

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
}
