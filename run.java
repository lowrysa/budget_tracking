import java.util.Scanner;

public class run {
    private static backend backend;
    private static Scanner k;
    private static textoptions text;

    public run() { //Meat and Potatos of Program
        intro();
        loop();
        end();
    }

    public static void intro() { //Intro text and setting up contructors
        clear();
        backend = new backend();
        text = new textoptions();
        text.greetings();
        k = new Scanner(System.in);
        backend.readFile();
    }

    public static void loop() { //Main loop of program
        boolean over = false;
        while (!over) {
            text.printLoop();
            int choice = k.nextInt();
            if (choice == 1) { //Print Entries
                clear();
                p("Print entries:");
                if (backend.totalSpent() > 0.0) {
                    boolean overa = false;
                    while (!overa) {
                        text.firstChoice();
                        int choicea = k.nextInt();
                        if (choicea == 1) { //Sort by Date
                            boolean overDate = false;
                            while(!overDate) {
                                text.dateChoice();
                                int choiceDateABBA = k.nextInt();
                                if (choiceDateABBA == 1) { //Spending Sort by Date, low->high
                                    backend.sortByDateLHSpending();
                                    overDate = true;
                                    overa = true;
                                } else if (choiceDateABBA == 2) { //Spending Sort by Date, high->low
                                    backend.sortByDateHLSpending();
                                    overDate = true;
                                    overa = true;
                                } else if (choiceDateABBA == 3) {
                                    backend.sortByDateLHEarning(); //Earning Sort by Date, low->high
                                    overDate = true;
                                    overa = true;
                                } else if (choiceDateABBA == 4) {
                                    backend.sortByDateHLEarning(); //Earning Sort by Date, high->low
                                    overDate = true;
                                    overa = true;
                                } else if (choiceDateABBA == 9) { //Back
                                    overDate = true;
                                    clear();
                                } else
                                    p("Not valid input\n");
                            }
                        } else if (choicea == 2) { //Sort by Amount
                            boolean overAmount = false;
                            while(!overAmount) {
                                text.amountChoice();
                                k.nextLine();
                                int choiceAmount = k.nextInt();
                                if (choiceAmount == 1) {
                                    backend.sortAmountLHSpending(); //Spending Sort by Amount, low->high
                                    overAmount = true;
                                    overa = true;
                                } else if (choiceAmount == 2) { //Spending Sort by Amount, high->low
                                    backend.sortAmountHLSpending();
                                    overAmount = true;
                                    overa = true;
                                } else if (choiceAmount == 3) {
                                    backend.sortAmountLHEarning(); //Earning Sort by Amount, low->high
                                    overAmount = true;
                                    overa = true;
                                } else if (choiceAmount == 4) {
                                    backend.sortAmountHLEarning(); //Earning Sort by Amount, high->low
                                    overAmount = true;
                                    overa = true;
                                } else if (choiceAmount == 9) { //Back
                                    overAmount = true;
                                    clear();
                                } else
                                    p("Not valid input\n");
                            }
                        } else if (choicea == 3) { //Sort by Various Categories
                            clear();
                            clear();
                            p("Print Categories:");
                            boolean yur = false;
                            while (!yur) {
                                p("1. Spendings");
                                p("2. Earnings");
                                p("9. Back");
                                int categoryChoice = k.nextInt();
                                if (categoryChoice == 1) { //Spendings
                                    clear();
                                    p("\nCategories:\n");
                                    backend.printCategory();
                                    p("");
                                    overa = true;
                                    yur = true;
                                } else if (categoryChoice == 2) { //Earnings
                                    clear();
                                    p("\nCategories:\n");
                                    backend.printCategoryEarnings();
                                    p("");
                                    overa = true;
                                    yur = true;
                                } else if (categoryChoice == 9) { //Back
                                    yur = true;
                                } else 
                                    p("Not valid input\n");
                            }
                        } else if (choicea == 4) { //Sort by added entries
                            clear();
                            p("Spendings:");
                            backend.printEntries();
                            overa = true;
                        } else if (choicea == 5) { //Print Earnings
                            clear();
                            p("Earnings:");
                            backend.printEarnings();
                            overa = true;
                        } else if (choicea == 9) { //Back
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
                    //Printing stats
                    p("Calculating...");
                    System.out.print("Between " + backend.getStartDate().printFull() + " and " + backend.getEndDate().printFull() + ", you have spent $");
                    System.out.print(backend.totalSpent());
                    if (backend.totalEarned() > 0.0) {
                        System.out.print(" and have earned $" + backend.totalEarned() + "!\n");
                        double difference = backend.totalEarned() - backend.totalSpent();
                        if (difference > 0.0)
                            p("(A difference of +" + difference + ")");
                        else if (difference < 0.0)
                            p("(A difference of " + difference + ")");
                        else
                            p("(You have no gained or lost money)");
                    }
                    p("\nMore specifically...");
                    p("Spendings:");
                    if (backend.totalSpentFood() > 0.0)
                        p("You have spent $" + backend.totalSpentFood() + " on Food");
                    if (backend.totalSpentGas() > 0.0) 
                        p("You have spent $" + backend.totalSpentGas() + " on Gas"); 
                    if (backend.totalSpentClothes() > 0.0)
                        p("You have spent $" + backend.totalSpentClothes() + " on Clothes");
                    if (backend.totalSpentGecko() > 0.0)
                        p("You have spent $" + backend.totalSpentGecko() + " on Gecko");
                    if (backend.totalSpentNintendo() > 0.0)
                        p("You have spent $" + backend.totalSpentNintendo() + " on Nintendo");
                    if (backend.totalSpentSplice() > 0.0)
                        p("You have spent $" + backend.totalSpentSplice() + " on Splice");
                    if (backend.totalSpentMovies() > 0.0)
                        p("You have spent $" + backend.totalSpentMovies() + " on Movies");
                    if (backend.totalSpentPlant() > 0.0)
                        p("You have spent $" + backend.totalSpentPlant() + " on Plants");
                    if (backend.totalSpentCVS() > 0.0) 
                        p("You have spent $" + backend.totalSpentCVS() + " on CVS");
                    if (backend.totalSpentRent() > 0.0)
                        p("You have spent $" + backend.totalSpentRent() + " on Rent");
                    if (backend.totalSpentUtilities() > 0.0)
                        p("You have spent $" + backend.totalSpentUtilities() + " on Utilities");
                    if (backend.totalSpentOther() > 0.0)
                        p("You have spent $" + backend.totalSpentOther() + " on everything else!");
                    if (backend.totalEarned() > 0.0) {
                        p("\nEarnings:");
                        if (backend.totalEarnedVicars() > 0.0)
                            p("You have earned $" + backend.totalEarnedVicars() + " from Vicars");
                        if (backend.totalEarnedPublix() > 0.0)
                            p("You have earned $" + backend.totalEarnedPublix() + " from Publix");
                        if (backend.totalEarnedPoshmark() > 0.0)
                            p("You have earned $" + backend.totalEarnedPoshmark() + " from Poshmark");
                        if (backend.totalEarnedDepop() > 0.0)
                            p("You have earned $" + backend.totalEarnedDepop() + " from Depop");
                        if (backend.totalEarnedShipt() > 0.0) 
                            p("You have earned $" + backend.totalEarnedShipt() + " from Shipt");
                        if (backend.totalEarnedUSC() > 0.0)
                            p("You have earned $" + backend.totalEarnedUSC() + " from USC");
                        if (backend.totalEarnedStreaming() > 0.0)
                            p("You have earned $" + backend.totalEarnedStreaming() + " from Streaming");
                        if (backend.totalEarnedOther() > 0.0)
                            p("You have earned $" + backend.totalEarnedOther() + " from everything else!\n");
                    } else
                        p("\nNo earnings yet!\n");
                } else 
                    p("No entries yet!\n");
            } else if (choice == 3) { //Add Entry
                clear();
                if (!backend.checkEndDate() && !backend.checkDates()) {
                    p("There's no starting or ending dates set yet, would you like to set them now?");
                    boolean bee = false;
                    while (!bee) {
                        System.out.print("(y/n) ");
                        k.nextLine();
                        String f = k.nextLine();
                        if (f.equalsIgnoreCase("y")) { //Adding Starting and Ending Dates
                            date cat = new date();
                            date a = new date();
                            clear();
                            boolean xo = false;
                            while(!xo) { //Set starting date
                                p("Set Starting date:");
                                System.out.print("Month: ");
                                int month = k.nextInt();
                                System.out.print("Day: ");
                                int day = k.nextInt();
                                System.out.print("Year: ");
                                int year = k.nextInt();
                                cat = new date(month,day,year);
                                if(cat.check(cat.getMonth(), cat.getDay(), cat.getYear()) 
                                   && backend.compareEndDate(cat)) {
                                    backend.setStartDate(cat);
                                    xo = true;
                                }
                            }
                            boolean z = false;
                            while(!z) { //Set ending date
                                p("\nSet Ending date:");
                                System.out.print("Month: ");
                                int month = k.nextInt();
                                System.out.print("Day: ");
                                int day = k.nextInt();
                                System.out.print("Year: ");
                                int year = k.nextInt();
                                a = new date(month,day,year);
                                if(a.check(a.getMonth(), a.getDay(), a.getYear()) 
                                    && backend.compareStartDate(a)) {
                                    clear();
                                    p("Dates set successfully!");
                                    p("Starting date: " + cat.getMonth() + "/" + cat.getDay() + "/" + cat.getYear());
                                    p("Ending date: " + a.getMonth() + "/" + a.getDay() + "/" + a.getYear());
                                    p("");
                                    backend.setEndDate(a);
                                    z = true;
                                    bee = true;
                                }
                            }
                        } else if (f.equalsIgnoreCase("n")) { //Not Setting dates
                            bee = true;
                            p("");
                        } else 
                            p("Invalid input\n");
                    }
                } else if (!backend.checkDates() && backend.checkEndDate()) {
                    boolean deer = false;
                    while (!deer) { 
                        p("There's no starting date set yet, would you like to set that up now?");
                        System.out.print("(y/n) ");
                        k.nextLine();
                        String input = k.nextLine();
                        if (input.equalsIgnoreCase("y")) { //Set starting date
                            boolean x = false;
                            while(!x) {
                                p("\nSet Starting date:");
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
                                if(a.check(a.getMonth(), a.getDay(), a.getYear()) 
                                    && backend.compareEndDate(a)) {
                                    clear();
                                    p("Date set successfully!");
                                    p("Starting date: " + month + "/" + day + "/" + year);
                                    p("");
                                    backend.setStartDate(a);
                                    x = true;
                                    deer = true;
                                } else 
                                    p("Not valid date");                      
                            }
                        } else if (input.equalsIgnoreCase("n")) { //Not setting date
                            p("");
                            deer = true;
                        } else 
                            p("Invalid input\n");
                    }
                } else if (!backend.checkEndDate() && backend.checkDates()) {
                    boolean deer = false;
                    while (!deer) {
                        p("There's no ending date set yet, would you like to set that up now?");
                        System.out.print("(y/n) ");
                        k.nextLine();
                        String input = k.nextLine();
                        if (input.equalsIgnoreCase("y")) { //Setting ending date
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
                                if(a.check(a.getMonth(), a.getDay(), a.getYear()) 
                                    && backend.compareStartDate(a)) {
                                    clear();
                                    p("Date set successfully!");
                                    p("Ending date: " + month + "/" + day + "/" + year);
                                    p("");
                                    backend.setEndDate(a);
                                    x = true;
                                    deer = true;
                                } else 
                                    p("Not valid date");                      
                            }
                        } else if (input.equalsIgnoreCase("n")) { //Not setting date
                            p("");
                            deer = true;
                        } else 
                            p("Invalid input\n");
                    }
                }
                //Now, actually adding an entry
                p("Add Spending:");
                boolean overc = false;
                boolean back1 = false;
                String entryType = "";
                while(!overc) {
                    //Pick type of entry
                    text.whatTypeOfEntry();
                    var choice1 = k.nextInt();
                    if (choice1 == 1) {
                        boolean over2 = false;
                        while (!over2) {
                            text.foodChoice();
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
                    } else if (choice1 == 6) {
                        entryType = "Splice";
                        overc = true;
                    } else if (choice1 == 7) {
                        entryType = "Movies";
                        overc = true;
                    } else if (choice1 == 8) {
                        entryType = "Plant";
                        overc = true;
                    } else if (choice1 == 9) {
                        entryType = "CVS";
                        overc = true;
                    } else if (choice1 == 10) {
                        entryType = "Rent";
                        overc = true;
                    } else if (choice1 == 11) {
                        entryType = "Utilities";
                        overc = true;
                    } else if (choice1 == 12) {
                        clear();
                        p("Please specify what kind of entry:");
                        k.nextLine();
                        entryType = k.nextLine();
                        overc = true;
                    } else if (choice1 == 13) {
                        overc = true;
                        back1 = true;
                        clear();
                    } else 
                        p("Not valid input\n");  
                }
                if (!back1) {
                    //Input how much it cost
                    clear();
                    System.out.print("How much did it cost? (Keep it above $0.0): ");
                    System.out.print("$");
                    double cost = k.nextDouble();
                    clear();
                    //Input date of purchase
                    p("What day did you purchase it?");
                    text.monthChoice();
                    int monthChoice;
                    int dayChoice;
                    int yearChoice;
                    monthChoice = k.nextInt(); //Select month
                    if(monthChoice != 1 && monthChoice != 2 && 
                    monthChoice != 3 && monthChoice != 4 &&
                    monthChoice != 5 && monthChoice != 6 && 
                    monthChoice != 7 && monthChoice != 8 && 
                    monthChoice != 9 && monthChoice != 10 && 
                    monthChoice != 11 && monthChoice != 12) 
                        monthChoice = 0;
                    clear();
                    System.out.print("Day: "); //Input day
                    dayChoice = k.nextInt();
                    if (dayChoice < 1 || dayChoice > 31) 
                        dayChoice = 0;
                    else if (monthChoice == 2 && dayChoice > 29 ) 
                        dayChoice = 0;
                    clear();
                    System.out.print("Year: "); //Input year
                    yearChoice = k.nextInt();
                    if (yearChoice < 0 && yearChoice > 2050) 
                        yearChoice = 0;
                    date adate = new date(monthChoice, dayChoice, yearChoice);
                    if (adate.check(adate.getMonth(), adate.getDay(), adate.getYear())
                        && backend.checkDateBounds(adate)) { //Adding entry
                        backend.addEntry(entryType, cost, adate);
                    } else 
                        p("Not valid date, Entry not added");
                    p("");
                    back1 = false;
                } 
            } else if (choice == 4) { //Add Earning
                clear();
                if (!backend.checkEndDate() && !backend.checkDates()) {
                    p("There's no starting or ending dates set yet, would you like to set them now?");
                    boolean bee = false;
                    while (!bee) {
                        System.out.print("(y/n) ");
                        k.nextLine();
                        String f = k.nextLine();
                        if (f.equalsIgnoreCase("y")) { //Adding Starting and Ending Dates
                            date cat = new date();
                            date a = new date();
                            clear();
                            boolean xo = false;
                            while(!xo) { //Set starting date
                                p("Set Starting date:");
                                System.out.print("Month: ");
                                int month = k.nextInt();
                                System.out.print("Day: ");
                                int day = k.nextInt();
                                System.out.print("Year: ");
                                int year = k.nextInt();
                                cat = new date(month,day,year);
                                if(cat.check(cat.getMonth(), cat.getDay(), cat.getYear()) 
                                   && backend.compareEndDate(cat)) {
                                    backend.setStartDate(cat);
                                    xo = true;
                                }
                            }
                            boolean z = false;
                            while(!z) { //Set ending date
                                p("\nSet Ending date:");
                                System.out.print("Month: ");
                                int month = k.nextInt();
                                System.out.print("Day: ");
                                int day = k.nextInt();
                                System.out.print("Year: ");
                                int year = k.nextInt();
                                a = new date(month,day,year);
                                if(a.check(a.getMonth(), a.getDay(), a.getYear()) 
                                    && backend.compareStartDate(a)) {
                                    clear();
                                    p("Dates set successfully!");
                                    p("Starting date: " + cat.getMonth() + "/" + cat.getDay() + "/" + cat.getYear());
                                    p("Ending date: " + a.getMonth() + "/" + a.getDay() + "/" + a.getYear());
                                    p("");
                                    backend.setEndDate(a);
                                    z = true;
                                    bee = true;
                                }
                            }
                        } else if (f.equalsIgnoreCase("n")) { //Not Setting dates
                            bee = true;
                            p("");
                        } else 
                            p("Invalid input\n");
                    }
                } else if (!backend.checkDates() && backend.checkEndDate()) {
                    boolean deer = false;
                    while (!deer) { 
                        p("There's no starting date set yet, would you like to set that up now?");
                        System.out.print("(y/n) ");
                        k.nextLine();
                        String input = k.nextLine();
                        if (input.equalsIgnoreCase("y")) { //Set starting date
                            boolean x = false;
                            while(!x) {
                                p("\nSet Starting date:");
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
                                if(a.check(a.getMonth(), a.getDay(), a.getYear()) 
                                    && backend.compareEndDate(a)) {
                                    clear();
                                    p("Date set successfully!");
                                    p("Starting date: " + month + "/" + day + "/" + year);
                                    p("");
                                    backend.setStartDate(a);
                                    x = true;
                                    deer = true;
                                } else 
                                    p("Not valid date");                      
                            }
                        } else if (input.equalsIgnoreCase("n")) { //Not setting date
                            p("");
                            deer = true;
                        } else 
                            p("Invalid input\n");
                    }
                } else if (!backend.checkEndDate() && backend.checkDates()) {
                    boolean deer = false;
                    while (!deer) {
                        p("There's no ending date set yet, would you like to set that up now?");
                        System.out.print("(y/n) ");
                        k.nextLine();
                        String input = k.nextLine();
                        if (input.equalsIgnoreCase("y")) { //Setting ending date
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
                                if(a.check(a.getMonth(), a.getDay(), a.getYear()) 
                                    && backend.compareStartDate(a)) {
                                    clear();
                                    p("Date set successfully!");
                                    p("Ending date: " + month + "/" + day + "/" + year);
                                    p("");
                                    backend.setEndDate(a);
                                    x = true;
                                    deer = true;
                                } else 
                                    p("Not valid date");                      
                            }
                        } else if (input.equalsIgnoreCase("n")) { //Not setting date
                            p("");
                            deer = true;
                        } else 
                            p("Invalid input\n");
                    }
                }
                //Now, actually adding an earning
                p("Add Earning:");
                boolean overc = false;
                boolean back1 = false;
                String entryType = "";
                while(!overc) {
                    //Pick type of entry
                    text.whatTypeOfEarning();
                    var choice1 = k.nextInt();
                    if (choice1 == 1) {
                        entryType = "Vicars";
                        overc = true;
                    } else if (choice1 == 2) {
                        entryType = "Publix";
                        overc = true;
                    } else if (choice1 == 3) {
                        entryType = "Poshmark";
                        overc = true;
                    } else if (choice1 == 4) {
                        entryType = "Depop";
                        overc = true;
                    } else if (choice1 == 5) {
                        entryType = "Shipt";
                        overc = true;
                    } else if (choice1 == 6) {
                        entryType = "USC";
                        overc = true;
                    } else if (choice1 == 7) {
                        entryType = "Streaming";
                        overc = true;
                    } else if (choice1 == 8) {
                        clear();
                        p("Please specify what kind of earning:");
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
                    //Input how much you earned
                    clear();
                    System.out.print("How much did you earn? (Keep it above $0.0): ");
                    System.out.print("$");
                    double cost = k.nextDouble();
                    clear();
                    //Input date of earning
                    p("What day did you earn it?");
                    text.monthChoice();
                    int monthChoice;
                    int dayChoice;
                    int yearChoice;
                    monthChoice = k.nextInt(); //Select month
                    if(monthChoice != 1 && monthChoice != 2 && 
                    monthChoice != 3 && monthChoice != 4 &&
                    monthChoice != 5 && monthChoice != 6 && 
                    monthChoice != 7 && monthChoice != 8 && 
                    monthChoice != 9 && monthChoice != 10 && 
                    monthChoice != 11 && monthChoice != 12) 
                        monthChoice = 0;
                    clear();
                    System.out.print("Day: "); //Input day
                    dayChoice = k.nextInt();
                    if (dayChoice < 1 || dayChoice > 31) 
                        dayChoice = 0;
                    else if (monthChoice == 2 && dayChoice > 29 ) 
                        dayChoice = 0;
                    clear();
                    System.out.print("Year: "); //Input year
                    yearChoice = k.nextInt();
                    if (yearChoice < 0 && yearChoice > 2050) 
                        yearChoice = 0;
                    date adate = new date(monthChoice, dayChoice, yearChoice);
                    if (adate.check(adate.getMonth(), adate.getDay(), adate.getYear())
                        && backend.checkDateBounds(adate)) { //Adding entry
                        backend.addEarning(entryType, cost, adate);
                    } else 
                        p("Not valid date, Earning not added");
                    p("");
                    back1 = false;
                } 
            } else if (choice == 5) { //Remove Entry
                clear();
                p("Removing entry:");
                if (backend.getArraySize() == 0) 
                    p("No entries yet!\n");
                else {
                    boolean remove = false;
                    while (!remove) {
                        //Printing entries to remove by user
                        p("\nWhich entry would you like to remove?");
                        p("(Type number of entry to remove, or 0 to go back)\n");
                        p("0. Back");
                        for (int i = 1; i < backend.getArraySize() + 1; i++) 
                            System.out.println(i + ": " + backend.printIndex(i-1));
                        int choicey = k.nextInt();
                        if (choicey == 0) {
                            remove = true;
                            clear();
                        } else if (choicey > 0 && choicey <= (backend.getArraySize())){
                            for (int i = 0; i < backend.getArraySize(); i++) {
                                if (choicey == (i+1)) {
                                    String name = backend.getEntry(i).getName();
                                    double amount = backend.getEntry(i).getAmount();
                                    date date = backend.getEntry(i).getDate();
                                    backend.removeEntry(name,amount,date);
                                    remove = true;
                                    clear();
                                    p("Removed!\n");
                                }
                            }
                        } else {
                            clear();
                            System.out.println("Not valid input");
                        }       
                    }
                }
            } else if (choice == 6) { //Remove Earning
                clear();
                p("Removing earning:");
                if (backend.getEarningArraySize() == 0) 
                    p("No entries yet!\n");
                else {
                    boolean remove = false;
                    while (!remove) {
                        //Printing earnings to remove by user
                        p("\nWhich entry would you like to remove?");
                        p("(Type number of entry to remove, or 0 to go back)\n");
                        p("0. Back");
                        for (int i = 1; i < backend.getEarningArraySize() + 1; i++) 
                            System.out.println(i + ": " + backend.printIndey(i-1));
                        int choicey = k.nextInt();
                        if (choicey == 0) {
                            remove = true;
                            clear();
                        } else if (choicey > 0 && choicey <= (backend.getEarningArraySize())){
                            for (int i = 0; i < backend.getEarningArraySize(); i++) {
                                if (choicey == (i+1)) {
                                    String name = backend.getEarning(i).getName();
                                    double amount = backend.getEarning(i).getAmount();
                                    date date = backend.getEarning(i).getDate();
                                    backend.removeEarning(name,amount,date);
                                    remove = true;
                                    clear();
                                    p("Removed!\n");
                                }
                            }
                        } else {
                            clear();
                            System.out.println("Not valid input");
                        }       
                    }
                }
            } else if (choice == 7) { //Show Random Entry
                clear();
                p("Random entry:");
                backend.printRandom();
                p("");
            } else if (choice == 8) { //Next page
                boolean overEasy = false;
                clear();
                while (!overEasy) {
                    text.printLoop2();
                    int choiceg = k.nextInt();
                    if (choiceg == 1) { //Print file
                        backend.printFile();
                    } else if (choiceg == 2) { //Reset file
                        clear();
                        boolean u = false;
                        while (!u) {
                            p("Are you sure you would like to reset the file?");
                            System.out.print("(y/n)");
                            k.nextLine();
                            String ahh = k.nextLine();
                            if (ahh.equalsIgnoreCase("y")) {
                                clear();
                                backend.resetFile();
                                u = true;
                            }
                            else if (!ahh.equalsIgnoreCase("n") && !ahh.equalsIgnoreCase("y"))
                                p("Not valid input\n");
                            else {
                                u = true;
                                p("");
                            }
                        } 
                    } else if (choiceg == 3) { //Change/Check Dates
                        boolean g = false;
                while (!g) {
                    clear();
                    p("Check/Change dates:");
                    p("1. Check dates");
                    p("2. Change dates");
                    p("9. Back");
                    int choicez = k.nextInt();
                    if (choicez == 1) { //Check dates
                        clear();
                        p("Check dates:");
                        if (backend.checkDates()) {
                            p("Starting Date: " + backend.getStartDate().printFull()); //Output starting date
                            //Checking if no ending date
                            if (!backend.checkEndDate()) {
                                boolean o = false;
                                while (!o) {
                                    p("\nThere is no end date set yet, would you like to set one?");
                                    System.out.print("(y/n) ");
                                    k.nextLine();
                                    String input = k.nextLine();
                                    if (input.equalsIgnoreCase("y")) {
                                        boolean x = false;
                                        while(!x) {
                                            p("\nSet Ending date:");
                                            System.out.print("Month: ");
                                            int month = k.nextInt();
                                            System.out.print("Day: ");
                                            int day = k.nextInt();
                                            System.out.print("Year: ");
                                            int year = k.nextInt();
                                            date a = new date(month,day,year);
                                            if(a.check(a.getMonth(), a.getDay(), a.getYear()) 
                                                && backend.compareStartDate(a)) {
                                                clear();
                                                p("Date set successfully!");
                                                p("Ending date: " + month + "/" + day + "/" + year);
                                                p("");
                                                backend.setEndDate(a);
                                                for(int i = 0; i < backend.getArraySize(); i++) {
                                                    if (!backend.checkDateBounds(backend.getEntry(i).getDate())) {
                                                        p("Entry no longer in bounds, removing...");
                                                        String name = backend.getEntry(i).getName();
                                                        double amount = backend.getEntry(i).getAmount();
                                                        date date = backend.getEntry(i).getDate();
                                                        backend.removeEntry(name,amount,date);
                                                        p("Removed!\n");
                                                    } 
                                                }
                                                for (int i = 0; i < backend.getEarningArraySize(); i++) {
                                                    if (!backend.checkDateBounds(backend.getEarning(i).getDate())) {
                                                        p("Earning no longer in bounds, removing...");
                                                        String name = backend.getEarning(i).getName();
                                                        double amount = backend.getEarning(i).getAmount();
                                                        date date = backend.getEarning(i).getDate();
                                                        backend.removeEarning(name,amount,date);
                                                        p("Removed!\n");
                                                    }
                                                }
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
                                p("Ending Date: " + backend.getEndDate().printFull()); //Printing ending date
                            p("");
                            g = true;
                        } else if (backend.checkEndDate() && !backend.checkDates()){
                            p("Ending Date: " + backend.getStartDate().printFull()); //Printing ending date
                            boolean o = false;
                                while (!o) {
                                    //Checking if no starting date
                                    p("\nThere is no start date set yet, would you like to set one?");
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
                                            if(a.check(a.getMonth(), a.getDay(), a.getYear()) 
                                                && backend.compareEndDate(a)) {
                                                clear();
                                                p("Date set successfully!");
                                                p("Starting date: " + month + "/" + day + "/" + year);
                                                p("");
                                                backend.setStartDate(a);
                                                for(int i = 0; i < backend.getArraySize(); i++) {
                                                    if (!backend.checkDateBounds(backend.getEntry(i).getDate())) {
                                                        p("Entry no longer in bounds, removing...");
                                                        String name = backend.getEntry(i).getName();
                                                        double amount = backend.getEntry(i).getAmount();
                                                        date date = backend.getEntry(i).getDate();
                                                        backend.removeEntry(name,amount,date);
                                                        p("Removed!\n");
                                                    } 
                                                }
                                                for (int i = 0; i < backend.getEarningArraySize(); i++) {
                                                    if (!backend.checkDateBounds(backend.getEarning(i).getDate())) {
                                                        p("Earning no longer in bounds, removing...");
                                                        String name = backend.getEarning(i).getName();
                                                        double amount = backend.getEarning(i).getAmount();
                                                        date date = backend.getEarning(i).getDate();
                                                        backend.removeEarning(name,amount,date);
                                                        p("Removed!\n");
                                                    }
                                                }
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
                        } else {
                            p("No dates set yet!");
                            boolean r = false;
                            while (!r) {
                                //Setting both dates
                                p("Would you like to set them now?");
                                System.out.print("(y/n) ");
                                k.nextLine();
                                String input = k.nextLine();
                                date cat = new date();
                                date a = new date();
                                if (input.equalsIgnoreCase("n")) {
                                    p("");
                                    g = true;
                                    r = true;
                                } else if (input.equalsIgnoreCase("y")) {
                                    clear();
                                    boolean xo = false;
                                    while(!xo) {
                                        //Starting date
                                        p("Set Starting date:");
                                        System.out.print("Month: ");
                                        int month = k.nextInt();
                                        System.out.print("Day: ");
                                        int day = k.nextInt();
                                        System.out.print("Year: ");
                                        int year = k.nextInt();
                                        cat = new date(month,day,year);
                                        if(cat.check(cat.getMonth(), cat.getDay(), cat.getYear()) 
                                            && backend.compareEndDate(cat)) {
                                            backend.setStartDate(cat);
                                            xo = true;
                                        }
                                    }
                                    boolean z = false;
                                    while(!z) {
                                        //Ending date
                                        p("\nSet Ending date:");
                                        System.out.print("Month: ");
                                        int month = k.nextInt();
                                        System.out.print("Day: ");
                                        int day = k.nextInt();
                                        System.out.print("Year: ");
                                        int year = k.nextInt();
                                        a = new date(month,day,year);
                                        if(a.check(a.getMonth(), a.getDay(), a.getYear()) 
                                            && backend.compareStartDate(a)) {
                                            clear();
                                            p("Dates set successfully!");
                                            p("Starting date: " + cat.getMonth() + "/" + cat.getDay() + "/" + cat.getYear());
                                            p("Ending date: " + a.getMonth() + "/" + a.getDay() + "/" + a.getYear());
                                            p("");
                                            backend.setEndDate(a);
                                            for(int i = 0; i < backend.getArraySize(); i++) {
                                                if (!backend.checkDateBounds(backend.getEntry(i).getDate())) {
                                                    p("Entry no longer in bounds, removing...");
                                                    String name = backend.getEntry(i).getName();
                                                    double amount = backend.getEntry(i).getAmount();
                                                    date date = backend.getEntry(i).getDate();
                                                    backend.removeEntry(name,amount,date);
                                                    p("Removed!\n");
                                                } 
                                            }
                                            for (int i = 0; i < backend.getEarningArraySize(); i++) {
                                                if (!backend.checkDateBounds(backend.getEarning(i).getDate())) {
                                                    p("Earning no longer in bounds, removing...");
                                                    String name = backend.getEarning(i).getName();
                                                    double amount = backend.getEarning(i).getAmount();
                                                    date date = backend.getEarning(i).getDate();
                                                    backend.removeEarning(name,amount,date);
                                                    p("Removed!\n");
                                                }
                                            }
                                            z = true;
                                            g = true;
                                            r = true;
                                        }
                                    }
                                } else 
                                    p("Not valid input");
                            }  
                        }
                    } else if (choicez == 2) { //Change dates
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
                                //Change starting date
                                p("Change Starting date:");
                                System.out.print("Month: ");
                                int month = k.nextInt();
                                System.out.print("Day: ");
                                int day = k.nextInt();
                                System.out.print("Year: ");
                                int year = k.nextInt();
                                date a = new date(month,day,year);
                                if(a.check(a.getMonth(), a.getDay(), a.getYear())
                                    && backend.compareEndDate(a)) {
                                    clear();
                                    p("Date changed successfully!");
                                    p("New starting date: " + month + "/" + day + "/" + year);
                                    p("");
                                    backend.setStartDate(a);
                                    for(int i = 0; i < backend.getArraySize(); i++) {
                                        if (!backend.checkDateBounds(backend.getEntry(i).getDate())) {
                                            p("Entry no longer in bounds, removing...");
                                            String name = backend.getEntry(i).getName();
                                            double amount = backend.getEntry(i).getAmount();
                                            date date = backend.getEntry(i).getDate();
                                            backend.removeEntry(name,amount,date);
                                            p("Removed!\n");
                                        }
                                    }
                                    for (int i = 0; i < backend.getEarningArraySize(); i++) {
                                        if (!backend.checkDateBounds(backend.getEarning(i).getDate())) {
                                            p("Earning no longer in bounds, removing...");
                                            String name = backend.getEarning(i).getName();
                                            double amount = backend.getEarning(i).getAmount();
                                            date date = backend.getEarning(i).getDate();
                                            backend.removeEarning(name,amount,date);
                                            p("Removed!\n");
                                        }
                                    }
                                    z = true;
                                    g = true;
                                } else 
                                    p("");
                            }
                        } else if (abc == 2) {
                            boolean z = false;
                            //Change ending date
                            while(!z) {
                                p("Change Ending date:");
                                System.out.print("Month: ");
                                int month = k.nextInt();
                                System.out.print("Day: ");
                                int day = k.nextInt();
                                System.out.print("Year: ");
                                int year = k.nextInt();
                                date a = new date(month,day,year);
                                if(a.check(a.getMonth(), a.getDay(), a.getYear())
                                    && backend.compareStartDate(a)) {
                                    clear();
                                    p("Date changed successfully!");
                                    p("New ending date: " + month + "/" + day + "/" + year);
                                    p("");
                                    backend.setEndDate(a);
                                    for(int i = 0; i < backend.getArraySize(); i++) {
                                        if (!backend.checkDateBounds(backend.getEntry(i).getDate())) {
                                            p("Entry no longer in bounds, removing...");
                                            String name = backend.getEntry(i).getName();
                                            double amount = backend.getEntry(i).getAmount();
                                            date date = backend.getEntry(i).getDate();
                                            backend.removeEntry(name,amount,date);
                                            p("Removed!\n");
                                        }
                                    }
                                    for (int i = 0; i < backend.getEarningArraySize(); i++) {
                                        if (!backend.checkDateBounds(backend.getEarning(i).getDate())) {
                                            p("Earning no longer in bounds, removing...");
                                            String name = backend.getEarning(i).getName();
                                            double amount = backend.getEarning(i).getAmount();
                                            date date = backend.getEarning(i).getDate();
                                            backend.removeEarning(name,amount,date);
                                            p("Removed!\n");
                                        }
                                    }
                                    z = true;
                                    g = true;
                                } else 
                                    p("");
                            }
                        } else if (abc == 3) {
                            //Change both dates
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
                                if(a.check(a.getMonth(), a.getDay(), a.getYear())
                                   && backend.compareEndDate(a)) {
                                    //p("Date changed successfully!");
                                    p("");
                                    backend.setStartDate(a);
                                    z = true;
                                } else
                                    p("");
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
                                if(b.check(b.getMonth(), b.getDay(), b.getYear())
                                    && backend.compareStartDate(b)) {
                                    clear();
                                    p("Dates changed successfully!");
                                    p("");
                                    backend.setEndDate(b);
                                    for(int i = 0; i < backend.getArraySize(); i++) {
                                        if (!backend.checkDateBounds(backend.getEntry(i).getDate())) {
                                            p("Entry no longer in bounds, removing...");
                                            String name = backend.getEntry(i).getName();
                                            double amount = backend.getEntry(i).getAmount();
                                            date date = backend.getEntry(i).getDate();
                                            backend.removeEntry(name,amount,date);
                                            p("Removed!\n");
                                        }
                                    }
                                    for (int i = 0; i < backend.getEarningArraySize(); i++) {
                                        if (!backend.checkDateBounds(backend.getEarning(i).getDate())) {
                                            p("Earning no longer in bounds, removing...");
                                            String name = backend.getEarning(i).getName();
                                            double amount = backend.getEarning(i).getAmount();
                                            date date = backend.getEarning(i).getDate();
                                            backend.removeEarning(name,amount,date);
                                            p("Removed!\n");
                                        }
                                    }
                                    y = true;
                                }
                            }
                            //Printing new dates
                            p("New starting date: " + a.getMonth() + "/" + a.getDay() + "/" + a.getYear());
                            p("New ending date: " + b.getMonth() + "/" + b.getDay() + "/" + b.getYear());
                            p("");
                            g = true;
                        } else if (abc == 9) //Back
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
                    } else if (choiceg == 8) { //Previous page
                        overEasy = true;
                        clear();
                    } else if (choiceg == 9) { //Quit program
                        overEasy = true;
                        over = true;
                    } else
                        p("Not valid input\n");
                }
            } else if (choice == 9) {//Quit Program
                over = true;
            } else 
                p("Not valid input\n");
        }
    } 

    public static void end() { //End of program
        System.out.print("Saving");
        boolean done = false;
        int count1 = 0;
        while (!done) {
            if (count1 == 2) {
                done = true;
            }
            System.out.print(".");
            backend.wait(1000);
            count1++;
        }
        backend.saveFile();
        k.close();
        p("\nGoodbye!");
    }
     
    public static void clear() { //Clear console
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    public static void p(String s) { //Easier than doing System.out.println
        System.out.println(s);
    }
}
