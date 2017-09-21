public class OrderItem {
    private Book selectedBook;
    private short quantity;

    public OrderItem ( Book selectedBook, Short quantity ) {
        this.selectedBook = selectedBook;
        this.quantity = quantity;
    }
}
