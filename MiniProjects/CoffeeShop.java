import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class CoffeeShop {

    // method that transfer all data to store in Transaction.txt file.
    public static void writeToFile(String fileName, ArrayList<Transaction> data) {
        try {
            FileWriter fw = new FileWriter(fileName);
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < data.size(); i++) {
                pw.println("Order number " + i + ": " + data.get(i));
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Error: cannot write data to a file: " + fileName);
        }
    }

    // Try to print ArrayList on completed Transaction
    public static void printArrayList(ArrayList<Transaction> transactions) {
        for (int i = 0; i < transactions.size(); i++) {
            System.out.printf("%s\n", transactions.get(i).toString());
        }
    }

    public static void main(String[] args) {

        // create User Choice
        int choice;
        // create keyboard object for input validation
        Keyboard kb = new Keyboard();

        // create an ArrayList to store a file that have been read from text file.
        ArrayList<MenuItems> coffeeMenu = new ArrayList<MenuItems>();

        // -----------------------------------------------------------------------------
        // CardTransaction c1 = new CardTransaction(dateAndTime, item, price, cardType)
        // ArrayList to store completed transaction to file.
        ArrayList<Transaction> completedList = new ArrayList<Transaction>();

        // --------------------------------------------------------------------------------

        // Read inventory file.txt and store it in ArrayList above.
        MenuItems.readInventoryFile("inventory.txt", coffeeMenu);

        // create and exit option
        // At the end of ArrayList no matter how large it is it will be at the end.
        int EXIT = coffeeMenu.size() + 1;

        // Display Menu
        // reason that we can use coffeeMeu because it already sorted in
        // readInventoryFile method.
        Menu.displayMenu(coffeeMenu);

        // setup Scanner
        Scanner in = new Scanner(System.in);

        // Get input from user and store to choice integer
        // Before that we will have to check for a validation.
        // by using Keyboard class.. (kb at line 13)
        choice = kb.readInteger("Enter Coffee Choice: ", "Error: Invalid input!!!", 1, coffeeMenu.size() + 1);

        // Menu loop
        while (choice != EXIT) {
            // ----------------- processing user input ------------//
            // compare user input to ArrayList (coffeeMenu)
            Transaction.transactionType(Menu.dateAndTime(), choice, coffeeMenu, completedList);
            // ****try *******************/

            System.out.println(completedList);

            // Display Menu
            Menu.displayMenu(coffeeMenu);

            // Get input from user
            choice = kb.readInteger("Enter Coffee Choice: ", "Error: Invalid input!!!", 1, coffeeMenu.size() + 1);
        }

        // After program exit
        // ------ write all the transaction that has happened during store time to a
        // file called transaction.txt
        // This can be excecuted by writing a new write file method. AKA = fileWriter.
        // writeTransactions---->

        // After all task finished
        writeToFile("Transaction.txt", completedList);
        System.out.println("Thank you for purchase");
    }
}