
import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

import org.omg.CORBA.DynAnyPackage.TypeMismatch;

import java.math.BigDecimal;
import java.math.RoundingMode;
public class run {
    private static backend backend;
    private static Scanner k;
    private static textoptions text;
    private static String fileName = "";

    // public run() { //Meat and Potatos of Program
    //     intro();
    //     loop();
    //     end();
    // }

    public static void main() { //Meat and Potatos of Program
        //fileName = args;
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
            //System.out.println(System.currentTimeMillis());
            text.printLoop();
            //System.out.println(System.currentTimeMillis());
            int choice = k.nextInt();
            if (choice == 1) { //Print Entries
                clear();
                pb("Print entries:");
                if (backend.totalSpent() > 0.0) {
                    boolean overa = false;
                    while (!overa) {
                        text.firstChoice();
                        int choicea = k.nextInt();
                        if (choicea == 1) { //Sort by Date
                            boolean overDate = false;
                            while(!overDate) {
                                text.dateChoice();
                                k.nextLine();
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
                            pb("Print Categories:");
                            boolean yur = false;
                            while (!yur) {
                                p("1. Spendings");
                                p("2. Earnings");
                                p("9. Back");
                                k.nextLine();
                                int categoryChoice = k.nextInt();
                                if (categoryChoice == 1) { //Spendings
                                    clear();
                                    pb("\nSpending Categories:\n");
                                    backend.printCategoriesSpendings();
                                    overa = true;
                                    yur = true;
                                } else if (categoryChoice == 2) { //Earnings
                                    clear();
                                    pb("\nEarning Categories:\n");
                                    backend.printCategoriesEarnings();
                                    overa = true;
                                    yur = true;
                                } else if (categoryChoice == 9) { //Back
                                    yur = true;
                                } else 
                                    p("Not valid input\n");
                            }
                        } else if (choicea == 4) { //Sort by added spendings
                            clear();
                            pb("Spendings:");
                            backend.printEntries();
                            overa = true;
                        } else if (choicea == 5) { //Print Earnings
                            clear();
                            pb("Earnings:");
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
                pb("\n\nChecking stats:");
                if (backend.totalSpent() > 0.0) {
                    //Printing stats
                    pi("Calculating...");
                    System.out.print("Between " + backend.getStartDate().printFull() + " and " + backend.getEndDate().printFull() + ", you have spent $");
                    System.out.print(round(backend.totalSpent(),2));
                    if (backend.totalEarned() > 0.0) {
                        System.out.print(" and have earned $" + roundNumber(backend.totalEarned()) + "!\n");
                        double difference = backend.totalEarned() - backend.totalSpent();
                        double differencePrint = roundNumber(difference);
                        if (difference > 0.0)
                            p("(A difference of $+" + differencePrint + ")");
                        else if (difference < 0.0)
                            p("(A difference of $" + differencePrint + ")");
                        else
                            p("(You have no gained or lost money)");
                    }
                    if (backend.spendings.totalSpent() > 0 || backend.earnings.totalEarned() > 0)
                        pi("\nMore specifically...");
                    //Need to fix all this so its dependent on what categories the user wants
                    if (backend.spendings.totalSpent() > 0) {
                        p("Spendings:");
                        for(int i = 0; i < backend.getSpendings().getCategories().size(); i++) {
                            double moneys = roundNumber(backend.getSpendings().totalSpentCategory(backend.getSpendings().getCategories().get(i)));
                            p("You have spent $" + moneys + " on " + backend.getSpendings().getCategories().get(i));
                        }
                    } else 
                        p("\nNo spendings yet!");
                    
                    // if (backend.totalSpentFood() > 0.0)
                    //     p("You have spent $" + backend.totalSpentFood() + " on Food");
                    // if (backend.totalSpentGas() > 0.0) 
                    //     p("You have spent $" + backend.totalSpentGas() + " on Gas"); 
                    // if (backend.totalSpentClothes() > 0.0)
                    //     p("You have spent $" + backend.totalSpentClothes() + " on Clothes");
                    // if (backend.totalSpentGecko() > 0.0)
                    //     p("You have spent $" + backend.totalSpentGecko() + " on Gecko");
                    // if (backend.totalSpentNintendo() > 0.0)
                    //     p("You have spent $" + backend.totalSpentNintendo() + " on Nintendo");
                    // if (backend.totalSpentSplice() > 0.0)
                    //     p("You have spent $" + backend.totalSpentSplice() + " on Splice");
                    // if (backend.totalSpentMovies() > 0.0)
                    //     p("You have spent $" + backend.totalSpentMovies() + " on Movies");
                    // if (backend.totalSpentPlant() > 0.0)
                    //     p("You have spent $" + backend.totalSpentPlant() + " on Plants");
                    // if (backend.totalSpentCVS() > 0.0) 
                    //     p("You have spent $" + backend.totalSpentCVS() + " on CVS");
                    // if (backend.totalSpentRent() > 0.0)
                    //     p("You have spent $" + backend.totalSpentRent() + " on Rent");
                    // if (backend.totalSpentUtilities() > 0.0)
                    //     p("You have spent $" + backend.totalSpentUtilities() + " on Utilities");
                    // if (backend.totalSpentOther() > 0.0)
                    //     p("You have spent $" + backend.totalSpentOther() + " on everything else!");
                    if (backend.earnings.totalEarned() > 0) {
                        p("\nEarnings:");
                        for(int i = 0; i < backend.getEarnings().getCategories().size(); i++) {
                            double moneys = roundNumber(backend.getEarnings().totalEarnedCategory(backend.getEarnings().getCategories().get(i)));
                            p("You have earned $" + moneys + " from " + backend.getEarnings().getCategories().get(i));
                        }
                    } else
                        p("No earnings yet!");
                    
                    // if (backend.totalEarned() > 0.0) {
                    //     p("\nEarnings:");
                    //     if (backend.totalEarnedVicars() > 0.0)
                    //         p("You have earned $" + backend.totalEarnedVicars() + " from Vicars");
                    //     if (backend.totalEarnedPublix() > 0.0)
                    //         p("You have earned $" + backend.totalEarnedPublix() + " from Publix");
                    //     if (backend.totalEarnedPoshmark() > 0.0)
                    //         p("You have earned $" + backend.totalEarnedPoshmark() + " from Poshmark");
                    //     if (backend.totalEarnedDepop() > 0.0)
                    //         p("You have earned $" + backend.totalEarnedDepop() + " from Depop");
                    //     if (backend.totalEarnedShipt() > 0.0) 
                    //         p("You have earned $" + backend.totalEarnedShipt() + " from Shipt");
                    //     if (backend.totalEarnedUSC() > 0.0)
                    //         p("You have earned $" + backend.totalEarnedUSC() + " from USC");
                    //     if (backend.totalEarnedStreaming() > 0.0)
                    //         p("You have earned $" + backend.totalEarnedStreaming() + " from Streaming");
                    //     if (backend.totalEarnedOther() > 0.0)
                    //         p("You have earned $" + backend.totalEarnedOther() + " from everything else!\n");
                    // } else
                    //     p("\nNo earnings yet!\n");
                } else 
                    p("No entries yet!\n");
            } else if (choice == 3) { //Add Spending
                clear();
                backend.checkWhatDatesSet();

                //Now, actually adding a spending
                pb("Add a Spending:");
                boolean overc = false;
                boolean back1 = false;
                String entryType = "";
                while(!overc) {
                    //Pick type of entry
                    if(backend.spendings.getCategories().isEmpty()) {
                        p("No Categories yet, time to make the first!");
                        boolean overd = false;
                        while (!overd) {
                            p("What type of entry is it?");
                            String entryTypeMaybe = k.nextLine();
                            if (!entryTypeMaybe.equalsIgnoreCase("")) {
                                backend.spendings.addCategory(entryTypeMaybe);
                                entryType = entryTypeMaybe;
                                overd = true;
                                overc = true;
                            } else 
                                p("Not valid input\n");
                        }
                    } else {
                        boolean overd = false;
                        boolean skip = false;
                        while (!overd) {
                            p("What type of entry is it?");
                            for(int i = 0; i < backend.spendings.getCategories().size(); i++) 
                                p((i+1) + ". " + backend.spendings.getCategories().get(i));
                            p(backend.spendings.getCategories().size()+1 + ". New Category");
                            p(backend.spendings.getCategories().size()+2 + ". Other");

                            int choiceEntryType = k.nextInt(); 
                            if (choiceEntryType < 1 || choiceEntryType > backend.spendings.getCategories().size()+3 )
                                p("Not valid input\n");
                            else if (choiceEntryType == backend.spendings.getCategories().size()+2) {
                                clear();
                                boolean otherBool = false;
                                while(!otherBool) {
                                    pb("What is the entry type?");
                                    String otherEntryType = k.nextLine();
                                    if (!otherEntryType.equalsIgnoreCase("")) {
                                        entryType = otherEntryType;
                                        otherBool = true;
                                        overd = true;
                                        overc = true;
                                    } else  
                                        p("Not valid\n");
                                }
                            } else if (choiceEntryType == backend.spendings.getCategories().size()+1) {
                                clear();
                                boolean newBool = false;
                                while(!newBool) {
                                    pb("What will the new category be?");
                                    String newType = k.nextLine();
                                    if (!newType.equalsIgnoreCase("")) {
                                        entryType = newType;
                                        backend.spendings.addCategory(newType);
                                        newBool = true;
                                        overd = true;
                                        overc = true;
                                    } else  
                                        p("Not valid\n");
                                }
                            } else {
                                entryType = backend.spendings.getCategories().get(choiceEntryType);
                                overd = true;
                                overc = true;
                            }
                        }
                    }
                        

                    // text.whatTypeOfEntry();
                    // int choice1 = k.nextInt();
                    // if (choice1 == 1) {
                    //     boolean over2 = false;
                    //     while (!over2) {
                    //         text.foodChoice();
                    //         int choic = k.nextInt();
                    //         if (choic == 1) {
                    //             entryType = "Eat Out";
                    //             over2 = true;
                    //             overc = true;
                    //         } else if (choic == 2) {
                    //             entryType = "Groceries";
                    //             over2 = true;
                    //             overc = true;
                    //         } else if (choic == 3) {
                    //             entryType = "Ice Cream";
                    //             over2 = true;
                    //             overc = true;
                    //         } else 
                    //             p("Not valid input\n");
                    //     }
                    // } else if (choice1 == 2) {
                    //     entryType = "Gas";
                    //     overc = true;
                    // } else if (choice1 == 3) {
                    //     entryType = "Clothes";
                    //     overc = true;
                    // } else if (choice1 == 4) {
                    //     entryType = "Gecko";
                    //     overc = true;
                    // } else if (choice1 == 5) {
                    //     entryType = "Nintendo";
                    //     overc = true;
                    // } else if (choice1 == 6) {
                    //     entryType = "Splice";
                    //     overc = true;
                    // } else if (choice1 == 7) {
                    //     entryType = "Movies";
                    //     overc = true;
                    // } else if (choice1 == 8) {
                    //     entryType = "Plant";
                    //     overc = true;
                    // } else if (choice1 == 9) {
                    //     entryType = "CVS";
                    //     overc = true;
                    // } else if (choice1 == 10) {
                    //     entryType = "Rent";
                    //     overc = true;
                    // } else if (choice1 == 11) {
                    //     entryType = "Utilities";
                    //     overc = true;
                    // } else if (choice1 == 12) {
                    //     clear();
                    //     p("Please specify what kind of entry:");
                    //     k.nextLine();
                    //     entryType = k.nextLine();
                    //     overc = true;
                    // } else if (choice1 == 13) {
                    //     overc = true;
                    //     back1 = true;
                    //     clear();
                    // } else 
                    //     p("Not valid input\n");  
                }
                if (!back1) {
                    //Input how much it cost
                    clear();
                    System.out.print("How much did it cost? (Keep it above $0.0): ");
                    System.out.print("$");
                    double cost = k.nextDouble();
                    clear();

                    //Input date of purchase
                    if(backend.datesEqual()) {
                        backend.addEntry(entryType, cost, backend.startingDate);
                    } else {
                        int monthChoice;
                        int dayChoice;
                        int yearChoice;

                        if (!backend.datesMonthEqual()) {
                            p("What month did you spend it?");
                            text.monthChoice();
                            monthChoice = k.nextInt(); //Select month
                            if(monthChoice != 1 && monthChoice != 2 && 
                            monthChoice != 3 && monthChoice != 4 &&
                            monthChoice != 5 && monthChoice != 6 && 
                            monthChoice != 7 && monthChoice != 8 && 
                            monthChoice != 9 && monthChoice != 10 && 
                            monthChoice != 11 && monthChoice != 12) 
                                monthChoice = 0;
                        } else 
                            monthChoice = backend.startingDate.getMonth();
                        
                        clear();
                        System.out.print("What day did you spend it?: "); //Input day
                        dayChoice = k.nextInt();
                        if (dayChoice < 1 || dayChoice > 31) 
                            dayChoice = 0;
                        else if (monthChoice == 2 && dayChoice > 29 ) 
                            dayChoice = 0;
                        
                        if (!backend.datesYearEqual()) {
                            clear();
                            System.out.print("What year did you spend it?: "); //Input year
                            yearChoice = k.nextInt();
                            if (yearChoice < 0 && yearChoice > 2050) 
                                yearChoice = 0;
                        } else 
                            yearChoice = backend.getStartDate().getYear();
                        
                        date adate = new date(monthChoice, dayChoice, yearChoice);
                        if (adate.check(adate.getMonth(), adate.getDay(), adate.getYear())
                            && backend.checkDateBounds(adate)) { //Adding entry
                            backend.addEntry(entryType, cost, adate);
                        } else 
                            p("Not valid date, Spending not added");
                        p("");
                    }                  
                    back1 = false;
                } 
            } else if (choice == 4) { //Add Earning
                clear();
                backend.checkWhatDatesSet();
    
                //Now, actually adding an earning
                pb("Add Earning:");
                boolean overc = false;
                boolean back1 = false;
                String entryType = "";
                while(!overc) {
                    if(backend.earnings.getCategories().isEmpty()) {
                        p("No Categories yet, time to make the first!");
                        boolean overd = false;
                        while (!overd) {
                            p("What type of entry is it?");
                            String entryTypeMaybe = k.nextLine();
                            if (!entryTypeMaybe.equalsIgnoreCase("")) {
                                backend.earnings.addCategory(entryTypeMaybe);
                                entryType = entryTypeMaybe;
                                overd = true;
                                overc = true;
                            } else 
                                p("Not valid input\n");
                        }
                    } else {
                        boolean overd = false;
                        boolean skip = false;
                        while (!overd) {
                            p("What type of entry is it?");
                            for(int i = 0; i < backend.earnings.getCategories().size(); i++) 
                                p((i+1) + ". " + backend.earnings.getCategories().get(i));
                            p(backend.earnings.getCategories().size()+1 + ". New Category");
                            p(backend.earnings.getCategories().size()+2 + ". Other");

                            int choiceEntryType = k.nextInt(); 
                            if (choiceEntryType < 1 || choiceEntryType > backend.earnings.getCategories().size()+3 )
                                p("Not valid input\n");
                            else if (choiceEntryType == backend.earnings.getCategories().size()+2) {
                                clear();
                                boolean otherBool = false;
                                while(!otherBool) {
                                    pb("What is the entry type?");
                                    String otherEntryType = k.nextLine();
                                    if (!otherEntryType.equalsIgnoreCase("")) {
                                        entryType = otherEntryType;
                                        otherBool = true;
                                        overd = true;
                                        overc = true;
                                    } else  
                                        p("Not valid\n");
                                }
                            } else if (choiceEntryType == backend.earnings.getCategories().size()+1) {
                                clear();
                                boolean newBool = false;
                                while(!newBool) {
                                    pb("What will the new category be?");
                                    String newType = k.nextLine();
                                    if (!newType.equalsIgnoreCase("")) {
                                        entryType = newType;
                                        backend.earnings.addCategory(newType);
                                        newBool = true;
                                        overd = true;
                                        overc = true;
                                    } else  
                                        p("Not valid\n");
                                }
                            } else {
                                entryType = backend.earnings.getCategories().get(choiceEntryType);
                                overd = true;
                                overc = true;
                            }
                        }
                    }

                    //Pick type of entry
                    // text.whatTypeOfEarning();
                    // int choice1 = k.nextInt();
                    // if (choice1 == 1) {
                    //     entryType = "Vicars";
                    //     overc = true;
                    // } else if (choice1 == 2) {
                    //     entryType = "Publix";
                    //     overc = true;
                    // } else if (choice1 == 3) {
                    //     entryType = "Poshmark";
                    //     overc = true;
                    // } else if (choice1 == 4) {
                    //     entryType = "Depop";
                    //     overc = true;
                    // } else if (choice1 == 5) {
                    //     entryType = "Shipt";
                    //     overc = true;
                    // } else if (choice1 == 6) {
                    //     entryType = "USC";
                    //     overc = true;
                    // } else if (choice1 == 7) {
                    //     entryType = "Streaming";
                    //     overc = true;
                    // } else if (choice1 == 8) {
                    //     clear();
                    //     p("Please specify what kind of earning:");
                    //     k.nextLine();
                    //     entryType = k.nextLine();
                    //     overc = true;
                    // } else if (choice1 == 9) {
                    //     overc = true;
                    //     back1 = true;
                    //     clear();
                    // } else 
                    //     p("Not valid input\n");  
                }
                if (!back1) {
                    //Input how much you earned
                    clear();
                    System.out.print("How much did you earn? (Keep it above $0.0): ");
                    System.out.print("$");
                    double cost = k.nextDouble();
                    clear();
                    //Input date of earning
                    if(backend.datesEqual()) {
                        backend.addEarning(entryType, cost, backend.startingDate);
                    } else {
                        int monthChoice;
                        int dayChoice;
                        int yearChoice;

                        if (!backend.datesMonthEqual()) {
                            p("What month did you earn it?");
                            text.monthChoice();
                            monthChoice = k.nextInt(); //Select month
                            if(monthChoice != 1 && monthChoice != 2 && 
                            monthChoice != 3 && monthChoice != 4 &&
                            monthChoice != 5 && monthChoice != 6 && 
                            monthChoice != 7 && monthChoice != 8 && 
                            monthChoice != 9 && monthChoice != 10 && 
                            monthChoice != 11 && monthChoice != 12) 
                                monthChoice = 0;
                        } else 
                            monthChoice = backend.startingDate.getMonth();
                        
                        clear();
                        System.out.print("What day did you earn it?: "); //Input day
                        dayChoice = k.nextInt();
                        if (dayChoice < 1 || dayChoice > 31) 
                            dayChoice = 0;
                        else if (monthChoice == 2 && dayChoice > 29 ) 
                            dayChoice = 0;
                        
                        if (!backend.datesYearEqual()) {
                            clear();
                            System.out.print("What year did you earn it?: "); //Input year
                            yearChoice = k.nextInt();
                            if (yearChoice < 0 && yearChoice > 2050) 
                                yearChoice = 0;
                        } else 
                            yearChoice = backend.getStartDate().getYear();
                        
                        date adate = new date(monthChoice, dayChoice, yearChoice);
                        if (adate.check(adate.getMonth(), adate.getDay(), adate.getYear())
                            && backend.checkDateBounds(adate)) { //Adding entry
                            backend.addEarning(entryType, cost, adate);
                        } else 
                            p("Not valid date, Earning not added");
                        p("");
                    }                  
                    back1 = false;
                } 
            } else if (choice == 5) { //Remove Entry
                clear();
                pb("Removing entry:");
                if (backend.spendings.getSize() == 0) 
                    p("No entries yet!\n");
                else {
                    boolean remove = false;
                    while (!remove) {
                        //Printing entries to remove by user
                        pb("\nWhich entry would you like to remove?");
                        pi("(Type number of entry to remove, or " + backend.spendings.getSize()+1 + " to purge all entries, or " + backend.spendings.getSize()+2 + " to go back)\n");
    
                        for (int i = 1; i < backend.spendings.getSize() + 1; i++) 
                            System.out.println(i + ": " + backend.printIndex(i-1));
                        p(backend.spendings.getSize()+1 + ". Purge Entries");
                        p(backend.spendings.getSize()+2 + ". Back");

                        int choicey = k.nextInt();
                        if (choicey == backend.spendings.getSize()+2) {
                            remove = true;
                            clear();
                        } else if (choicey == backend.spendings.getSize()+1) {
                            boolean purgeAll = false;
                            while (!purgeAll) {
                                clear();
                                pb("Are you sure you want to purge all entries?");
                                pi("This cannot be undone");
                                System.out.print("(y/n) ");

                                String purgeChoice = k.nextLine();
                                if (purgeChoice.equalsIgnoreCase("y")) {
                                    clear();
                                    backend.purgeSpendings();
                                    purgeAll = true;
                                    remove = true;
                                } else if (purgeChoice.equalsIgnoreCase("n")) {
                                    clear();
                                    purgeAll = true;
                                    remove = true;
                                } else 
                                    p("Not valid input\n");
                            }
                        } else if (choicey > 0 && choicey < (backend.spendings.getSize())){
                            for (int i = 0; i < backend.spendings.getSize(); i++) {
                                if (choicey == (i+1)) {
                                    String name = backend.getEntry(i).getName();
                                    double amount = backend.getEntry(i).getAmount();
                                    date date = backend.getEntry(i).getDate();
                                    backend.removeSpending(name,amount,date);
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
                pb("Removing earning:");
                if (backend.earnings.getSize() == 0) 
                    p("No entries yet!\n");
                else {
                    boolean remove = false;
                    while (!remove) {
                        //Printing earnings to remove by user
                        p("\nWhich entry would you like to remove?");
                        pi("(Type number of entry to remove, or " + backend.earnings.getSize()+1 + " to purge all entries, or " + backend.earnings.getSize()+2 + " to go back)\n");
    
                        for (int i = 1; i < backend.earnings.getSize() + 1; i++) 
                            System.out.println(i + ": " + backend.printIndex(i-1));
                        p(backend.earnings.getSize()+1 + ". Purge Entries");
                        p(backend.earnings.getSize()+2 + ". Back");

                        int choicey = k.nextInt();
                        if (choicey == backend.earnings.getSize()+2) {
                            remove = true;
                            clear();
                        } else if (choicey == backend.earnings.getSize()+1) {
                            boolean purgeAll = false;
                            while (!purgeAll) {
                                clear();
                                pb("Are you sure you want to purge all entries?");
                                pi("This cannot be undone");
                                System.out.print("(y/n) ");

                                String purgeChoice = k.nextLine();
                                if (purgeChoice.equalsIgnoreCase("y")) {
                                    clear();
                                    backend.purgeEarnings();
                                    purgeAll = true;
                                    remove = true;
                                } else if (purgeChoice.equalsIgnoreCase("n")) {
                                    clear();
                                    purgeAll = true;
                                    remove = true;
                                } else 
                                    p("Not valid input\n");
                            }
                        //}
                        // p("(Type number of entry to remove, or 0 to go back)\n");
                        // p("0. Back");
                        // for (int i = 1; i < backend.earnings.getSize() + 1; i++) 
                        //     System.out.println(i + ": " + backend.printIndey(i-1));
                        // int choicey = k.nextInt();
                        // if (choicey == 0) {
                        //     remove = true;
                        //     clear();
                        } else if (choicey > 0 && choicey < (backend.earnings.getSize())){
                            for (int i = 0; i < backend.earnings.getSize(); i++) {
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
                pb("Random entry:");
                backend.printRandom();
                p("");
            } else if (choice == 8) { //Next page
                boolean overEasy = false;
                clear();
                while (!overEasy) {
                    text.printLoop2();
                    int choiceg = k.nextInt();
                    if (choiceg == 4) { //Print file
                        backend.printFile();
                    } else if (choiceg == 5) { //Reset file
                        clear();
                        boolean u = false;
                        while (!u) {
                            p("Are you sure you would like to reset the file?");
                            System.out.print("(y/n) ");
                            k.nextLine();
                            String ahh = k.nextLine();
                            if (ahh.equalsIgnoreCase("y")) {
                                boolean h = false;
                                while (!h) {
                                    p("\nWould you like to save your file to a new name? ");
                                    System.out.print("(y/n) ");
                                    //k.nextLine();
                                    String ahhh = k.nextLine();
                                    if (ahhh.equalsIgnoreCase("y")) {
                                        boolean b = false;
                                        while (!b) {
                                            p("What description do you want to add for the file? (press 'n' to go back)");
                                            pi("(Ex. Summer '22)");
                                            String ne = k.nextLine();
                                            if (!ne.equalsIgnoreCase("n")) {
                                                String newName = "budget_tracking(" + ne + ").txt";
                                                p("");
                                                clear();
                                                backend.saveToNewFile(newName);
                                            } else {
                                                clear();
                                            }
                                            b = true;
                                            h = true;
                                            u = true;
                                            overEasy = true;
                                        }
                                    } else if (ahhh.equalsIgnoreCase("n")) {
                                        clear();
                                        backend.resetFile();
                                        h = true;
                                        u = true;
                                    } else if (!ahhh.equalsIgnoreCase("n") && !ahhh.equalsIgnoreCase("y")) 
                                        p("Not valid input\n");
                                }
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
                            pb("Check/Change dates:");
                            p("1. Check dates");
                            p("2. Change dates");
                            p("9. Back");
                            int choicez = k.nextInt();
                            
                            if (choicez == 1) { //Check dates
                                clear();
                                pb("Check dates:");
                                if (backend.checkStartDate()) {
                                    p("Starting Date: " + backend.getStartDate().printFull()); //Output starting date
        
                                    //Checking if no ending date
                                    if (!backend.checkEndDate()) 
                                        backend.checkWhatDatesSet();
                                    else 
                                        p("Ending Date: " + backend.getEndDate().printFull() + "\n"); //Printing ending date
        
                                    g = true;
                                } else if (backend.checkEndDate() && !backend.checkStartDate()){
                                    p("Ending Date: " + backend.getStartDate().printFull() + "\n"); //Printing ending date
                                    backend.checkWhatDatesSet();
                                } else {
                                    p("No dates set yet!");
                                    backend.checkWhatDatesSet();
                                }
                            } else if (choicez == 2) { //Change dates
                                clear();
                                pb("Change dates:");
        
                                if (!backend.checkStartDate() && !backend.checkEndDate()) 
                                    p("Neither of the dates have been set!");
                                else if (backend.checkStartDate() && !backend.checkEndDate()) {
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
                                    backend.noStartDateSet();
                                    g = true;
                                } else if (abc == 2) {
                                    backend.noEndDateSet();
                                    g = true;
                                } else if (abc == 3) {
                                    //Change both dates
                                    backend.noStartDateSet();
                                    backend.noEndDateSet();
        
                                    clear();
                                    p("New Dates:");
                                    if (backend.getStartDate() != null) p("Starting Date: " + backend.getStartDate().printFull());
                                    if (backend.getEndDate() != null) p("Ending Date: " + backend.getEndDate().printFull());
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
                    } else if (choiceg == 6) { //Change file
                        clear();
                        pb("Change File:\n");
                        p("Input new file name: "); 
                        k.nextLine();
                        String newFile = k.nextLine();

                        if (newFile.equalsIgnoreCase(fileName)) 
                            p("This is the same file bruh\n");
                        else {
                            backend.readFile();
                            overEasy = true;
                        }
                    } else if (choiceg == 1) { //Print Categories
                        clear();
                        if(backend.earnings.getCategories().size() + backend.spendings.getCategories().size() > 4)
                            p("\n\n");
                        pb("Categories:");

                        if (backend.earnings.getCategories().size() > 0 || backend.spendings.getCategories().size() > 0) {
                            if (backend.spendings.getCategories().size() > 0) {
                                p("\nSpending Categories:");
                                for(int i = 0; i < backend.spendings.getCategories().size(); i++)
                                    p(backend.spendings.getCategories().get(i));
                            }
                            if (backend.earnings.getCategories().size() > 0) {
                                p("\nEarning Categories:");
                                for(int i = 0; i < backend.earnings.getCategories().size(); i++)
                                    p(backend.earnings.getCategories().get(i));
                            }
                        } else  
                            p("No categories yet!");
                    } else if (choiceg == 2) { //Add Remove Categories
                        clear();
                        boolean overCat = false;
                        while(!overCat) {
                            pb("Which one would you like to do?");
                            p("1. Add Category");
                            p("2. Remove Category");
                            p("9. Back");
                            //try {
                                int choiceCat = k.nextInt();
                                clear();
                                if (choiceCat == 9) {
                                    overCat = true;
                                } else if (choiceCat == 1) {
                                    pb("What do you want the category to be called?");
                                    String addCat = k.nextLine();
                                    
                                    boolean overCat2 = false;
                                    while(!overCat2) {
                                        p("\nIs it for spending, earning, or both?");
                                        p("1. Spending");
                                        p("2. Earning");
                                        p("3. Both");
                                        p("9. Quit This");

                                        int question = k.nextInt();
                                        if (question == 1) { //Add Spending
                                            backend.spendings.addCategory(addCat);
                                            p("Added category " + addCat + "!");
                                            overCat2 = true;
                                        } else if (question == 2) { //Add Earning
                                            backend.earnings.addCategory(addCat);
                                            p("Added category " + addCat + "!");
                                            overCat2 = true;
                                        } else if (question == 3) { //Add Both
                                            backend.earnings.addCategory(addCat);
                                            backend.spendings.addCategory(addCat);
                                            p("Added category " + addCat + "!");
                                            overCat2 = true;
                                        } else if (question == 9) { //Quit
                                            overCat2 = true;
                                        } else 
                                            p("Not valid input");
                                    }
                                } else if (choiceCat == 2) { //Remove Category
                                    //TODO: this
                                    clear();
                                    pb("Remove Category:");
                                    boolean overCat2 = false;
                                    while(!overCat2) {
                                        p("A Category from Spending or Earning?");
                                        p("1. Spending");
                                        p("2. Earning");
                                        p("3. Purge them all");
                                        p("9. Quit");

                                        //try {
                                            int catRemove = k.nextInt();
                                            if(catRemove == 1) { //Remove a spending
                                                clear();
                                                if (backend.getSpendings().getCategories().isEmpty()) {
                                                    p("There are no spending categories yet!");
                                                    //over
                                                    overCat2 = true;
                                                } else {
                                                    boolean picked = false;
                                                    while (!picked){
                                                        pb("Which spending category?");
                                                        for(int i = 0; i < backend.getSpendings().getCategories().size(); i++) {
                                                            p((i+1) + ". " + backend.getSpendings().getCategories().get(i));
                                                        } 
                                                        p(backend.getSpendings().getCategories().size()+2 + ". Go Back");
                                                        int spendingRemove = k.nextInt();
                                                        if (spendingRemove < 0 || spendingRemove > backend.getSpendings().getCategories().size()+2) {
                                                            p("Not valid input");
                                                        } else if (spendingRemove == backend.getSpendings().getCategories().size()+2) {
                                                            overCat2 = true;
                                                            picked = true;
                                                        } else {
                                                            overCat2 = true;
                                                            picked = true;
                                                            backend.removeSpendingCategory(backend.getSpendings().getCategories().get(spendingRemove-1));
                                                        }
                                                    }
                                                    
                                                    
                                                }
                                                

                                            } else if (catRemove == 2) { //Remove a earning
                                                // try {
                                                    clear();
                                                    if (backend.getEarnings().getCategories().isEmpty()) {
                                                        p("There are no earning categories yet!");
                                                        //over
                                                        overCat2 = true;
                                                    } else {
                                                        boolean picked = false;
                                                        while (!picked){
                                                            pb("Which earning category?");
                                                            for(int i = 0; i < backend.getEarnings().getCategories().size(); i++) {
                                                                p((i+1) + ". " + backend.getEarnings().getCategories().get(i));
                                                            } 
                                                            p(backend.getEarnings().getCategories().size()+2 + ". Go Back");
                                                            int spendingRemove = k.nextInt();
                                                            if (spendingRemove < 0 || spendingRemove > backend.getEarnings().getCategories().size()+2) {
                                                                p("Not valid input");
                                                            } else if (spendingRemove == backend.getEarnings().getCategories().size()+2) {
                                                                overCat2 = true;
                                                                picked = true;
                                                            } else {
                                                                overCat2 = true;
                                                                picked = true;
                                                                backend.removeEarningCategory(backend.getEarnings().getCategories().get(spendingRemove-1)); 
                                                            }
                                                        }
                                                        
                                                        
                                                    }
                                                // } catch (TypeMismatch e) {

                                                // }
                                            } else if (catRemove == 3) { //Purge everythi g
                                                clear();
                                                boolean sureThing = false;
                                                while (!sureThing) {
                                                    pb("Are you sure you want to purge everything?");
                                                    pi("This cannot be undone");
                                                    System.out.print("(y/n): ");
                                                    String sure = k.nextLine();
    
                                                    if (sure.equalsIgnoreCase("y")) {
                                                        p("\nPurging categories...");
                                                        sureThing = true;
                                                        overCat2 = true;
                                                        backend.purgeAllCategories();
                                                        
                                                    } else if (sure.equalsIgnoreCase("n")) {
                                                        sureThing = true;
                                                        overCat2 = true;
                                                    } else 
                                                        p("Not valid input\n");
                                                }
                                                
                                            } else if (catRemove == 9) { //Quit
                                                overCat2 = true;
                                            } else 
                                                p("Not valid input");
                                       // } catch (TypeMismatch e) {

                                       // }
                                    }
                                } else 
                                    p("Not valid input\n");

                            // } catch(TypeMismatch e) {
                            //     p("Wrong input, going back...");
                            //     overCat = true;
                            // }  
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

    public static void pb(String s) { //System.out.println but bold
        System.out.println("\033[0;1m" + s + "\033[0m");
    }

    public static void pi(String s) { //System.out.println but bold
        System.out.println("\033[3m" + s + "\033[0m");
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
    
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static double roundNumber(double value) {
        return round(value, 2);
    }
}