import java.io.*;
import java.util.ArrayList;

public class MenuItems {
    // private variable
    private String name;
    private double price;

    // Contructor
    MenuItems(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // get access to data member that inside private class.
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    /*
     * This file will read all the menu items
     * That store in the text file called inventory.txt
     * allow user to easily to change or edit memu.
     */
    // Read file method.
    // This method will read file and perform a separated between name and prices
    public static void readInventoryFile(String fileName, ArrayList<MenuItems> items) {
        try {
            FileReader fr = new FileReader(fileName);
            // allow to read a whole line as it go
            BufferedReader br = new BufferedReader(fr);
            String line;
            // read file line by line and store to variable line each time
            // it will read file until br.readLine == null(end of file)
            while ((line = br.readLine()) != null) {
                // Split item and price into two files.
                // Separated by comma
                // tokens[0] = "Cappuccino";
                // tokens[1] = "2.50";
                String tokens[] = line.split(",");
                String name = tokens[0];
                double price = Double.parseDouble(tokens[1]);

                // create new menu item objects
                items.add(new MenuItems(name, price));
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error cannot read from file:" + fileName);
        }
    }
}