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
                boolean overa = false;
                while (!overa) {
                    firstChoice();
                    int choicea = k.nextInt();
                    if (choicea == 1) {
                        boolean overDate = false;
                        while(!overDate) {
                            dateChoice();
                            int choiceDate = k.nextInt();
                            if (choiceDate == 1) {
                                backend.sortByDateLH();
                                overDate = true;
                            } else if (choiceDate == 2) {
                                backend.sortByDateHL();
                                overDate = true;
                            } else if (choiceDate == 9) 
                                overDate = true;
                            else
                                p("Not valid input");
                        }
                        overa = true;
                    } else if (choicea == 2) {
                        boolean overAmount = false;
                        while(!overAmount) {
                            amountChoice();
                            int choiceAmount = k.nextInt();
                            if (choiceAmount == 1) {
                                backend.sortAmountLH();
                                overAmount = true;
                            } else if (choiceAmount == 2) {
                                backend.sortAmountHL();
                                overAmount = true;
                            } else if (choiceAmount == 9)
                                overAmount = true;
                            else
                                p("Not valid input");
                        }
                        overa = true;
                    } else if (choicea == 3) {
                        boolean overAlphabet = false;
                        while (!overAlphabet) {
                            alphabeticChoice();
                            int choiceAlpha = k.nextInt();
                            if (choiceAlpha == 1) {
                                backend.sortAlphabeticallyAZ();
                                overAlphabet = true;
                            } else if (choiceAlpha == 2) {
                                backend.sortAlphabeticallyZA();
                                overAlphabet = true;
                            } else if (choiceAlpha == 9)
                                overAlphabet = true;
                            else
                                p("Not a valid input");
                        }
                        overa = true;
                    } else if (choicea == 4) {
                        backend.printEntries();
                        overa = true;
                    } else if (choicea == 9) {

                        overa = true;
                    } else 
                        p("Not valid input");  
                }   
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
        p("8. Show random entry");
        p("9. Quit program");
    }

    public static void firstChoice() {
        p("1. Print by date");
        p("2. Print by amount");
        p("3. Print alphabetically");
        p("4. Print in order of added");
        p("9. Back");
    }

    public static void dateChoice() {
        p("1. Sort by low to high date");
        p("2. Sort by high to low date");
        p("9. Back");
    }

    public static void amountChoice() {
        p("1. Sort by low to high amount");
        p("2. Sort by high to low amount");
        p("9. Back");
    }

    public static void alphabeticChoice() {
        p("1. Sort from A->Z");
        p("2. Sort from Z->A");
        p("9. Back");
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
