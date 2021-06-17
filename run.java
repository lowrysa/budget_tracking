import java.util.Scanner;
public class run {
    private static backend backend;
    private static Scanner k;
    public static void main(String args[]) {
        intro();
        loop();
        end();
    }


    public static void intro() {
        p("Welcome to the budget tracking program!");
        backend = new backend();
        k = new Scanner(System.in);
    }

    public static void loop() {
        boolean over = false;
        while (!over) {
            printLoop();
            int choice = k.nextInt();
            if (choice == 1) {

            } else if (choice == 2)
                p("2");
            else if (choice == 3)
                p("2");
            else if (choice == 4)
                p("2");
            else if (choice == 9)
                over = true;
        }
    }

    public static void printLoop() {
        p("What would you like to do?");
        p("1. Print entries");
        p("2. Check stats");
        p("3. Add entry");
        p("9. Quit program");
    }

    public static void end() {
        p("Saving...");
        //somehow save program
        k.close();
        p("Goodbye!");
    }
    
    
    
    
    
    public static void p(String s) {
        System.out.println(s);
    }
}
