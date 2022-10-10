import java.util.ArrayList;

public class CardTransaction extends Transaction {
    // create variable
    private String cardType;

    // constructor
    CardTransaction() {

    }

    CardTransaction(String time, String item, double price, String cardType) {
        super(time, item, price);
        this.cardType = cardType;
    }

    // ArrayList of cardTransaction
    static ArrayList<CardTransaction> card = new ArrayList<CardTransaction>();

    // Getter
    // get the information
    public String getcardType() {
        return cardType;
    }

    // Setter
    public void setcardType(String cardType) {
        this.cardType = cardType;
    }

    public static String visa() {
        String visa = "Visa-card";
        return visa;
    }

    public static String master() {
        String master = "Master card";
        return master;
    }

    public String toString() {
        return super.toString() + cardType;
    }

    public static void cardOption(String time, int choice, ArrayList<MenuItems> items,
            ArrayList<Transaction> finalList) {
        MenuItems item = items.get(choice - 1);

        // prompt user to input payment type
        int option = kb.readInteger("Please select card type (1-visa , 2-master) : ", "Error: Invalid input!!");
        if (option == 1) {
            System.out.printf("Here is your %s and your %s back. Enjoy!!\n", item.getName(), visa());// take only
                                                                                                     // itemName
            // Transaction was successful
            // ---->some sort of way to store this into String and put it in ArrayList.
            visaOption(time, choice, items, finalList);
        } else {
            System.out.printf("Here is your %s and your %s back. Enjoy!!\n", item.getName(), master());
            // add this data into ArrayList.
            masterOption(time, choice, items, finalList);
        }
    }

    // Visa option
    public static void visaOption(String time, int choice, ArrayList<MenuItems> items,
            ArrayList<Transaction> finalList) {
        MenuItems item = items.get(choice - 1);
        String cardType = visa();

        // store it in ArrayList.
        System.out.println("Before Add data: " + finalList);
        finalList.add(new CardTransaction(time, item.getName(), item.getPrice(), cardType));
    }

    // master option
    public static void masterOption(String time, int choice, ArrayList<MenuItems> items,
            ArrayList<Transaction> finalList) {
        MenuItems item = items.get(choice - 1);
        String cardType = master();

        // store it in ArrayList.
        System.out.println("Before Add data: " + finalList);
        finalList.add(new CardTransaction(time, item.getName(), item.getPrice(), cardType));
    }
}
