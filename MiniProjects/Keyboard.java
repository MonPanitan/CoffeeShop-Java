import java.util.Scanner;

public class Keyboard {
    private Scanner in;

    Keyboard() {
        in = new Scanner(System.in);
    }

    // convert to integer
    public int readInteger(String prompt, String error) {
        int num = 0;
        String strInput;
        boolean valid = false;

        // Keep looking until valid input
        while (valid == false) {
            // Prompt the user
            System.out.print(prompt);
            // Grab input from keyboard
            strInput = in.nextLine();
            // Try to convert String to int
            try {
                num = Integer.parseInt(strInput);
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println(error);
            }
        }
        return num;
    }

    // ranged input low and high
    public int readInteger(String prompt, String error, int low, int high) {
        int num = 0;
        String strInput;
        boolean valid = false;

        // Keep looking until valid input
        while (valid == false) {
            // Prompt the user
            System.out.print(prompt);
            // Grab input from keyboard
            strInput = in.nextLine();
            // Try to convert String to int
            try {
                num = Integer.parseInt(strInput);
                if (num >= low && num <= high) {
                    valid = true;
                } else {
                    System.out.println(error);
                }
            } catch (NumberFormatException e) {
                System.out.println(error);
            }
        }
        return num;
    }

    // convert to double
    public double readDouble(String prompt, String error) {
        double num = 0.0;
        String strInput;
        boolean valid = false;

        // Keep looking until valid input
        while (valid == false) {
            // Prompt the user
            System.out.print(prompt);
            // Grab input from keyboard
            strInput = in.nextLine();
            // Try to convert String to int
            try {
                num = Double.parseDouble(strInput);
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println(error);
            }
        }
        return num;
    }

}
