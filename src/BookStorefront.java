import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookStorefront {
    private JPanel panel1;
    private JPanel FormValues;
    private JButton ProcessItem;
    private JTextField numItems;
    private JTextField bookId;
    private JTextField quanity;
    private JTextField itemInfoCalculated;
    private JTextField subTotal;
    private JPanel MainPanel;
    private JButton ConfirmItem;
    private JButton ViewOrder;
    private JButton FinishOrder;
    private JButton NewOrder;
    private JButton Exit;
    private JLabel NumberOfItems;
    private JLabel BookId;
    private JLabel Quantity;
    private JLabel ItemInfo;
    private JLabel OrderSubtotal;

    public static void main(String[] args) {
        //Initialze Bookstore Classes
        BookStore bookStore = new BookStore();

        //Swing setup
        JFrame frame = new JFrame("Bookstore");
        frame.setContentPane(new BookStorefront().MainPanel );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        //set default form state


    }
}
