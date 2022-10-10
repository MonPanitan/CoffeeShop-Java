import java.util.ArrayList;
import java.time.LocalDateTime; // import date and time
import java.time.format.DateTimeFormatter; //import formatter to decolate layout.

public class Menu {
    private static String time;

    // Date and Time method
    public static String dateAndTime() {
        LocalDateTime dateTime = LocalDateTime.now();
        // format Date and Time
        DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("E MMM dd yyyy   HH:mm:ss");

        String formattedDate = dateTime.format(formatObj);
        return formattedDate;
    }

    // repeat "-" form a line
    public static void dash() {
        for (int i = 0; i < 30; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    // repeat "=" form a line
    public static void line() {
        for (int i = 0; i < 30; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    // print out main menu
    // This method is specifically target to for MenuItems File.
    public static void displayMenu(ArrayList<MenuItems> items) {
        // print out date and time
        dash();
        time = dateAndTime();
        System.out.println(time);
        dash();

        // print out main menu
        System.out.println("\n---- Welcome to </> Coffee Shop ----\n");
        System.out.println("M E N U");
        line();
        // coffee list
        System.out.printf("%10s %17s\n", "Coffee List", "Prices");
        System.out.println();

        // Loop through options and items in MenuItems ArrayList.
        for (int i = 0; i < items.size(); i++) {
            MenuItems item = items.get(i);// This will read out the whole line
            System.out.printf("%d. %-18s  %.2f\n", i + 1, item.getName(), item.getPrice());
        }
        // Print the Exit options after all menu has been printed.
        System.out.printf("%d. Exit\n", items.size() + 1); // No matter array size exit will be at the end of the list.
        line();
        // end of main menu
    }

    // Processing user input in this method
    public static void completeTransaction(int choice, ArrayList<MenuItems> items) {
        // declare local objects
        MenuItems item = items.get(choice - 1);

        System.out.printf("Here is your %s price is %.2f\n", item.getName(), item.getPrice()); // get method is created
                                                                                               // in MenuItems file.
    }

}
