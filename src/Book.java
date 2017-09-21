import java.math.BigDecimal;

public class Book {
    private int bookNum;
    private String name;
    private BigDecimal price;

    public Book ( String name, int bookNum, BigDecimal price ) {
        this.name = name;
        this.bookNum = bookNum;
        this.price = price;
    }

    public void setPrice( BigDecimal price ) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setBookNum(int bookNum) {
        this.bookNum = bookNum;
    }

    public int getBookNum() {
        return bookNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
