import java.util.List;

public class Inventory {
    private List<Book> shelf;

    public List<Book> getShelf() {
        return shelf;
    }

    public void addBook ( Book book ) {
        shelf.add(book);
    }
}
