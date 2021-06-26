import java.util.Scanner;

//import jdk.tools.jlink.internal.Archive.Entry.EntryType;
public class run {
    private static backend backend;
    private static Scanner k;
    public static void main(String args[]) {
        clear();
        clear();
        intro();
        loop();
        end();
    }


    public static void intro() {
        clear();
        p("*******************************************************************************************");
        p("*                                                                                         *");
        System.out.print("*                         ");
        System.out.print("Welcome to the budget tracking program!");
        System.out.print("                         *");
        p("*                                                                                         *");
        p("*******************************************************************************************");
        p("");
        backend = new backend();
        k = new Scanner(System.in);
        backend.readFile();
    }

    public static void loop() {
        boolean over = false;
        while (!over) {
            printLoop();
            int choice = k.nextInt();
            if (choice == 1) { //Print Entries
                clear();
                p("Print entries:");
                if (backend.totalSpent() > 0.0) {
                    boolean overa = false;
                    while (!overa) {
                        firstChoice();
                        int choicea = k.nextInt();
                        boolean reallyOver = false;
                        if (choicea == 1) {
                            boolean overDate = false;
                            while(!overDate) {
                                dateChoice();
                                int choiceDate = k.nextInt();
                                if (choiceDate == 1) {
                                    backend.sortByDateLH();
                                    overDate = true;
                                    overa = true;
                                } else if (choiceDate == 2) {
                                    backend.sortByDateHL();
                                    overDate = true;
                                    overa = true;
                                } else if (choiceDate == 9) {
                                    overDate = true;
                                    clear();
                                } else
                                    p("Not valid input");
                            }
                            //overa = true;
                        } else if (choicea == 2) {
                            boolean overAmount = false;
                            while(!overAmount) {
                                amountChoice();
                                int choiceAmount = k.nextInt();
                                if (choiceAmount == 1) {
                                    backend.sortAmountLH();
                                    overAmount = true;
                                    overa = true;
                                } else if (choiceAmount == 2) {
                                    backend.sortAmountHL();
                                    overAmount = true;
                                    overa = true;
                                } else if (choiceAmount == 9) {
                                    overAmount = true;
                                    clear();
                                } else
                                    p("Not valid input");
                            }
                            //overa = true;
                        } else if (choicea == 3) {
                            boolean overAlphabet = false;
                            while (!overAlphabet) {
                               alphabeticChoice();
                                int choiceAlpha = k.nextInt();
                                if (choiceAlpha == 1) {
                                    backend.sortAlphabeticallyAZ();
                                   overAlphabet = true;
                                   overa = true;
                                } else if (choiceAlpha == 2) {
                                    backend.sortAlphabeticallyZA();
                                    overAlphabet = true;
                                    overa = true;
                                } else if (choiceAlpha == 9) {
                                    overAlphabet = true;
                                    clear();
                                } else
                                    p("Not a valid input");
                            }
                            //overa = true;
                        } else if (choicea == 4) {
                            backend.printEntries();
                            overa = true;
                        } else if (choicea == 9) {
                            overa = true;
                            clear();
                        } else 
                         p("Not valid input");  
                    }  
                } else 
                    p("No entries yet!\n");
            } else if (choice == 2) { //Check Stats
                clear();
                p("Checking stats:");
                if (backend.totalSpent() > 0.0) {
                    p("Calculating...");
                    System.out.print("In total, you have spent $");
                    System.out.print(backend.totalSpent());
                    p("");
                    p("More specifically...");
                    p("");
                    System.out.print("You have spent $");
                    System.out.print(backend.totalSpentFood());
                    System.out.print(" on Food");
                    p("");
                    System.out.print("You have spent $");
                    System.out.print(backend.totalSpentGas());
                    System.out.print(" on Gas");
                    p("");
                    System.out.print("You have spent $");
                    System.out.print(backend.totalSpentClothes());
                    System.out.print(" on Clothes");
                    p("");
                    System.out.print("You have spent $");
                    System.out.print(backend.totalSpentGecko());
                    System.out.print(" on Gecko");
                    p("");
                    System.out.print("You have spent $");
                    System.out.print(backend.totalSpentNintendo());
                    System.out.print(" on Nintendo");
                    p("");
                    System.out.print("You have spent $");
                    System.out.print(backend.totalSpentOther());
                    System.out.print(" on everything else!");
                    p("");
                } else {
                    p("No entries yet!");
                    p("");
                }
                
            } else if (choice == 3) { //Add Entry
                clear();
                p("Add entry:");
                boolean overc = false;
                boolean back1 = false;
                String entryType = "";
                while(!overc) {
                    whatTypeOfEntry();
                    var choice1 = k.nextInt();
                    if (choice1 == 1) {
                        boolean over2 = false;
                        while (!over2) {
                            foodChoice();
                            int choic = k.nextInt();
                            if (choic == 1) {
                                entryType = "Eat Out";
                                over2 = true;
                                overc = true;
                            } else if (choic == 2) {
                                entryType = "Groceries";
                                over2 = true;
                                overc = true;
                            } else if (choic == 3) {
                                entryType = "Ice Cream";
                                over2 = true;
                                overc = true;
                            } else 
                                p("Not valid input");
                        }
                    } else if (choice1 == 2) {
                        entryType = "Gas";
                        overc = true;
                    } else if (choice1 == 3) {
                        entryType = "Clothes";
                        overc = true;
                    } else if (choice1 == 4) {
                        entryType = "Gecko";
                        overc = true;
                    } else if (choice1 == 5) {
                        entryType = "Nintendo";
                        overc = true;
                    } else if (choice1 == 8) {
                        p("Please specify what kind of entry:");
                        entryType = k.nextLine();
                        overc = true;
                    } else if (choice1 == 9) {
                        overc = true;
                        back1 = true;
                        clear();
                    } else 
                        p("Not valid input");  
                }
                if (!back1) {
                    clear();
                    System.out.print("How much did it cost? (Keep it above $0.0): ");
                    System.out.print("$");
                    double cost = k.nextDouble();
                    p("What day did you purchase it?");
                    System.out.print("Month: ");
                    //p("What month?");
                    monthChoice();
                    int monthChoice;
                    int dayChoice;
                    int yearChoice;
                    monthChoice = k.nextInt();
                    if(monthChoice != 1 && monthChoice != 2 && 
                    monthChoice != 3 && monthChoice != 4 &&
                    monthChoice != 5 && monthChoice != 6 && 
                    monthChoice != 7 && monthChoice != 8 && 
                    monthChoice != 9 && monthChoice != 10 && 
                    monthChoice != 11 && monthChoice != 12) {
                        //p("Not a valid month");
                        monthChoice = 0;
                    }
                    //p("What day?");
                    clear();
                    System.out.print("Day: ");
                    dayChoice = k.nextInt();
                    if (dayChoice < 1 || dayChoice > 31) {
                        //p("Not a valid day");
                        dayChoice = 0;
                    } else if (monthChoice == 2 && dayChoice > 29 ) {
                        //p("Not a valid day");
                        dayChoice = 0;
                    } 
                    clear();
                    System.out.print("Year: ");
                    yearChoice = k.nextInt();
                    if (yearChoice < 0 && yearChoice > 2050) {
                        //p("Not a valid year");
                        yearChoice = 0;
                    }
                    date adate = new date(monthChoice, dayChoice, yearChoice);
                    backend.addEntry(entryType, cost, adate);
                    //p("Added!");
                    p("");
                    back1 = false;
                } 
            } else if (choice == 8) {//Show Random Entry
                clear();
                p("Random entry:");
                backend.printRandom();
                p("");
            } else if (choice == 9) {//Quit Program
                over = true;
            } else 
                p("Not valid input");
        }
    }

    public static void printLoop() {
        //clear();
        p("What would you like to do?");
        p("1. Print entries");
        p("2. Check stats");
        p("3. Add entry");
        p("8. Show random entry");
        p("9. Quit program");
    }

    public static void firstChoice() {
        //clear();
        p("How would you like to print?");
        p("1. Print by date");
        p("2. Print by amount");
        p("3. Print alphabetically");
        p("4. Print in order of added");
        p("9. Back");
    }

    public static void dateChoice() {
        clear();
        p("How would you like to sort?");
        p("1. Sort by low to high date");
        p("2. Sort by high to low date");
        p("9. Back");
    }

    public static void amountChoice() {
        clear();
        p("How would you like to sort?");
        p("1. Sort by low to high amount");
        p("2. Sort by high to low amount");
        p("9. Back");
    }

    public static void alphabeticChoice() {
        clear();
        p("How would you like to sort?");
        p("1. Sort from A->Z");
        p("2. Sort from Z->A");
        p("9. Back");
    }

    public static void whatTypeOfEntry() {
        clear();
        p("What Type of Entry is it?");
        p("1. Food");
        p("2. Gas");
        p("3. Clothes");
        p("4. Gecko");
        p("5. Nintendo");
        p("8. Other");
        p("9. Back");
    }

    public static void foodChoice() {
        clear();
        p("What kind of food purchase?");
        p("1. Eat Out");
        p("2. Groceries");
        p("3. Ice Cream");
    }

    public static void monthChoice() {
        clear();
        p("Select the correct month:");
        p("1. January");
        p("2. February");
        p("3. March");
        p("4. April");
        p("5. May");
        p("6. June");
        p("7. July");
        p("8. August");
        p("9. September");
        p("10. October");
        p("11. November");
        p("12. December");
    }

    public static void end() {
        p("Saving...");
        backend.saveFile();
        k.close();
        p("Goodbye!");
    }
    
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    
    
    public static void p(String s) {
        System.out.println(s);
    }
}
