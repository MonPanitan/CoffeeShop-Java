import java.util.ArrayList;

public class CashTransaction extends Transaction {
    // create variable
    private double amountTendered;
    private double change;

    // constucrtor
    CashTransaction(String time, String item, double price, double amountTendered, double change) {
        super(time, item, price);
        this.amountTendered = amountTendered;
        this.change = change;
    }

    // get the information
    public double getAmountTendered() {
        return amountTendered;
    }

    public double getChange() {
        return change;
    }

    public double setChange(double change) {
        return change;
    }

    public String toString() {
        return super.toString() + amountTendered + "," + change;
    }

    public static void cashProcess(String time, int choice, ArrayList<MenuItems> items,
            ArrayList<Transaction> finalList) {
        // declare or pick an item for local variable use only.
        MenuItems item = items.get(choice - 1);
        // prompt user to input payment type
        double amountTendered = kb.readDouble("Please enter amount tendered : ", "Error: Invalid input!!");
        if (amountTendered > item.getPrice()) {
            // double change = amountTendered - item.getPrice();
            double change = amountTendered - item.getPrice();
            System.out.printf("Here is your %s and your %.2f change\n", item.getName(), change);
            addTransaction(time, choice, items, finalList, amountTendered, change);
        } else {
            System.out.printf("Not enough money for %s\n", item.getName());
        }
    }

    // cash option
    public static void addTransaction(String time, int choice, ArrayList<MenuItems> items,
            ArrayList<Transaction> finalList, double amountTendered, double change) {
        MenuItems item = items.get(choice - 1);

        // store it in ArrayList.
        CashTransaction c1 = new CashTransaction(time, item.getName(), item.getPrice(), amountTendered, change);
        System.out.println(finalList);
        // System.out.println(c1);
        finalList.add(c1);
    }
}