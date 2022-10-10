import java.util.ArrayList;

public class Transaction {
    // create variable
    private String time;
    private String item;
    protected double price;

    // called from keyboard class
    static Keyboard kb = new Keyboard();

    // constuctor
    Transaction() {

    }

    Transaction(String time, String item, double price) {
        this.time = Menu.dateAndTime();
        this.item = item;
        this.price = price;
    }

    ArrayList<Transaction> completed = new ArrayList<Transaction>();

    // get the information
    public String getTime() {
        return time;
    }

    public String getItem() {
        return item;
    }

    public double getPrice() {
        return price;
    }

    // Setter
    public void setTime(String time) {
        this.time = time;
    }

    public void setItem(String string) {

    }

    public void setPrice(double price) {

    }

    public String toString() {
        return time + "," + item + "," + price + ",";
    }

    // Processing user input in this method
    public static void transactionType(String time, int choice, ArrayList<MenuItems> items,
            ArrayList<Transaction> finalList) {
        int payOption = kb.readInteger("Please select payment type (1-cash , 2-card) : ", "Error: Invalid input!!!", 1,
                2);
        if (payOption == 1) {
            // Cash
            CashTransaction.cashProcess(time, choice, items, finalList);
        } else {
            // Card
            CardTransaction.cardOption(time, choice, items, finalList);
        }
    }
}
