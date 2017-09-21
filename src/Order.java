import java.util.List;

public class Order {
    private List<OrderItem> cart;

    public List<OrderItem> getCart() {
        return cart;
    }

    public void placeInCart ( OrderItem selection ) {
        cart.add(selection);
    }
}
