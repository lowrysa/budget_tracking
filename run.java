import java.util.Scanner;

//import jdk.tools.jlink.internal.Archive.Entry.EntryType;
public class run {
    private static backend backend;
    private static Scanner k;
    public static void main(String args[]) {
        intro();
        loop();
        end();
    }

    //TODO: Make sure to compare start to end date when setting them
    //TODO: If start/end date arent set, ask which they want to set
    //TODO: File I/O

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
                                    p("Not valid input\n");
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
                                    p("Not valid input\n");
                            }
                            //overa = true;
                        } else if (choicea == 3) {
                            clear();
                            p("Categories:\n");
                            backend.printCategory();
                            p("");
                            overa = true;
                            //overa = true;
                        } else if (choicea == 4) {
                            clear();
                            p("Entries:");
                            backend.printEntries();
                            //p("");
                            overa = true;
                        } else if (choicea == 9) {
                            overa = true;
                            clear();
                        } else 
                         p("Not valid input\n");  
                    }  
                } else 
                    p("No entries yet!\n");
            } else if (choice == 2) { //Check Stats
                clear();
                p("Checking stats:");
                if (backend.totalSpent() > 0.0) {
                    p("Calculating...");
                    System.out.print("Between " + backend.getStartDate() + " and " + backend.getEndDate() + ", you have spent $");
                    System.out.print(backend.totalSpent());
                    p("");
                    p("");
                    p("More specifically...");
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
                    p("\n");
                } else 
                    p("No entries yet!\n");
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
                                p("Not valid input\n");
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
                        k.nextLine();
                        entryType = k.nextLine();
                        overc = true;
                    } else if (choice1 == 9) {
                        overc = true;
                        back1 = true;
                        clear();
                    } else 
                        p("Not valid input\n");  
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
                    if (yearChoice < 0 && yearChoice > 2050) 
                        yearChoice = 0;
                    date adate = new date(monthChoice, dayChoice, yearChoice);
                    if (adate.check(adate.getMonth(), adate.getDay(), adate.getYear())) {
                        backend.addEntry(entryType, cost, adate);
                    } else {
                        clear();
                        p("Not valid date, Entry not added");
                    }
                    p("");
                    back1 = false;
                } 
            } else if (choice == 4) { //check/change dates
                boolean g = false;
                while (!g) {
                    clear();
                    p("Check/Change dates:");
                    p("1. Check dates");
                    p("2. Change dates");
                    p("9. Back");
                    int choicez = k.nextInt();
                    if (choicez == 1) { //check dates
                        clear();
                        p("Check dates:");
                        if (backend.checkDates()) {
                            p("Starting Date: " + backend.getStartDate().printFull());
                            if (!backend.checkEndDate()) {
                                boolean o = false;
                                while (!o) {
                                    p("\nThere is no end date set yet, would you like to set one?");
                                    System.out.print("(y/n) ");
                                    k.nextLine();
                                    String input = k.nextLine();
                                    if (input.equalsIgnoreCase("y")) {
                                        //clear();
                                        boolean x = false;
                                        while(!x) {
                                            p("\nSet Ending date:");
                                            System.out.print("Month: ");
                                            int month = k.nextInt();
                                            p("");
                                            System.out.print("Day: ");
                                            int day = k.nextInt();
                                            p("");
                                            System.out.print("Year: ");
                                            int year = k.nextInt();
                                            p("");
                                            date a = new date(month,day,year);
                                            if(a.check(a.getMonth(), a.getDay(), a.getYear())) {
                                                clear();
                                                p("Date set successfully!");
                                                p("Ending date: " + month + "/" + day + "/" + year);
                                                p("");
                                                backend.setEndDate(a);
                                                x = true;
                                                g = true;
                                                o = true;
                                            } else 
                                                p("Not valid date");                      
                                        }
                                    } else if (input.equalsIgnoreCase("n")) {
                                        p("");
                                        o = true;
                                        g = true;
                                    } else
                                        p("Not valid input");
                                }
                            } else 
                                p("Ending Date: " + backend.getEndDate().printFull());
                            p("");
                            g = true;
                        } else {
                            p("No dates set yet!");
                            boolean r = false;
                            while (!r) {
                                p("Would you like to set them now?");
                                System.out.print("(y/n) ");
                                k.nextLine();
                                String input = k.nextLine();
                                date cat = new date();
                                date a = new date();
                                if (input.equalsIgnoreCase("n")) {
                                    //p("");
                                    g = true;
                                    r = true;
                                } else if (input.equalsIgnoreCase("y")) {
                                    clear();
                                    boolean xo = false;
                                    while(!xo) {
                                        p("Set Starting date:");
                                        System.out.print("Month: ");
                                        int month = k.nextInt();
                                        System.out.print("Day: ");
                                        int day = k.nextInt();
                                        System.out.print("Year: ");
                                        int year = k.nextInt();
                                        cat = new date(month,day,year);
                                        if(cat.check(cat.getMonth(), cat.getDay(), cat.getYear())) {
                                            backend.setStartDate(cat);
                                            xo = true;
                                        }
                                    }
                                    boolean z = false;
                                    while(!z) {
                                        p("\nSet Ending date:");
                                        System.out.print("Month: ");
                                        int month = k.nextInt();
                                        System.out.print("Day: ");
                                        int day = k.nextInt();
                                        System.out.print("Year: ");
                                        int year = k.nextInt();
                                        a = new date(month,day,year);
                                        if(a.check(a.getMonth(), a.getDay(), a.getYear())) {
                                            clear();
                                            p("Dates set successfully!");
                                            p("Starting date: " + cat.getMonth() + "/" + cat.getDay() + "/" + cat.getYear());
                                            p("Ending date: " + a.getMonth() + "/" + a.getDay() + "/" + a.getYear());
                                            p("");
                                            backend.setEndDate(a);
                                            z = true;
                                            g = true;
                                            r = true;
                                        }
                                    }
                                } else 
                                    p("Not valid input");
                            }  
                        }
                    } else if (choicez == 2) {
                        clear();
                        p("Change dates:");
                        if (!backend.checkDates() && !backend.checkEndDate()) 
                            p("Neither of the dates have been set!");
                        else if (backend.checkDates() && !backend.checkEndDate()) {
                            p("The Starting Date is: " + backend.getStartDate().print());
                            p("The Ending Date hasn't been set yet!");
                        } else {
                            p("The Starting Date is: " + backend.getStartDate().print());
                            p("The Ending Date is: " + backend.getEndDate().print());
                        }
                        p("\nWhich one would you like to change?");
                        p("1. Starting date");
                        p("2. Ending date");
                        p("3. Both");
                        p("9. Back");
                        int abc = k.nextInt();
                        clear();
                        if (abc == 1) {
                            boolean z = false;
                            while(!z) {
                                p("Change Starting date:");
                                System.out.print("Month: ");
                                int month = k.nextInt();
                                System.out.print("Day: ");
                                int day = k.nextInt();
                                System.out.print("Year: ");
                                int year = k.nextInt();
                                date a = new date(month,day,year);
                                if(a.check(a.getMonth(), a.getDay(), a.getYear())) {
                                    clear();
                                    p("Date changed successfully!");
                                    p("New starting date: " + month + "/" + day + "/" + year);
                                    p("");
                                    backend.setStartDate(a);
                                    z = true;
                                    g = true;
                                }
                            }
                        } else if (abc == 2) {
                            boolean z = false;
                            while(!z) {
                                p("Change Ending date:");
                                System.out.print("Month: ");
                                int month = k.nextInt();
                                System.out.print("Day: ");
                                int day = k.nextInt();
                                System.out.print("Year: ");
                                int year = k.nextInt();
                                date a = new date(month,day,year);
                                if(a.check(a.getMonth(), a.getDay(), a.getYear())) {
                                    clear();
                                    p("Date changed successfully!");
                                    p("New ending date: " + month + "/" + day + "/" + year);
                                    p("");
                                    backend.setEndDate(a);
                                    z = true;
                                    g = true;
                                }
                            }
                        } else if (abc == 3) {
                            //System.out.println(abc);
                            date a = new date();
                            date b = new date();
                            boolean z = false;
                            while(!z) {
                                p("Change Starting date:");
                                System.out.print("Month: ");
                                int month = k.nextInt();
                                System.out.print("Day: ");
                                int day = k.nextInt();
                                System.out.print("Year: ");
                                int year = k.nextInt();
                                a.setDay(day);
                                a.setMonth(month);
                                a.setYear(year);
                                if(a.check(a.getMonth(), a.getDay(), a.getYear())) {
                                    //p("Date changed successfully!");
                                    p("");
                                    backend.setStartDate(a);
                                    z = true;
                                }
                            }
                            boolean y = false;
                            while(!y) {
                                p("Change Ending date:");
                                System.out.print("Month: ");
                                int month = k.nextInt();
                                System.out.print("Day: ");
                                int day = k.nextInt();
                                System.out.print("Year: ");
                                int year = k.nextInt();
                                b.setMonth(month);
                                b.setDay(day);
                                b.setYear(year);
                                if(b.check(b.getMonth(), b.getDay(), b.getYear())) {
                                    clear();
                                    p("Dates changed successfully!");
                                    p("");
                                    backend.setEndDate(a);
                                    y = true;
                                }
                            }
                            p("New starting date: " + a.getMonth() + "/" + a.getDay() + "/" + a.getYear());
                            p("New ending date: " + b.getMonth() + "/" + b.getDay() + "/" + b.getYear());
                            p("");
                            g = true;
                        } else if (abc == 9) 
                            clear();
                        else
                            p("Not valid input\n");
                    } else if (choicez == 9) {
                        clear();
                        g = true;
                    }
                     else 
                        p("Not valid input");
                }
            } else if (choice == 8) {//Show Random Entry
                clear();
                p("Random entry:");
                backend.printRandom();
                p("");
            } else if (choice == 9) {//Quit Program
                over = true;
            } else 
                p("Not valid input\n");
        }
    }

    public static void printLoop() {
        //clear();
        p("What would you like to do?");
        p("1. Print entries");
        p("2. Check stats");
        p("3. Add entry");
        p("4. Check/Change dates");
        p("8. Show random entry");
        p("9. Quit program");
    }

    public static void firstChoice() {
        //clear();
        p("How would you like to print?");
        p("1. Print by date");
        p("2. Print by amount");
        p("3. Print by category");
        p("4. Print in order of added");
        p("9. Back");
    }

    public static void dateChoice() {
        clear();
        p("How would you like to sort?");
        p("1. Sort by oldest to newest");
        p("2. Sort by newest to oldest");
        p("9. Back");
    }

    public static void amountChoice() {
        clear();
        p("How would you like to sort?");
        p("1. Sort by low to high");
        p("2. Sort by high to low");
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
