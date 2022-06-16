
import java.util.Random;
import java.io.*;
//import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;
public class backend {
    //Various things needed
    private entryArray spendings;
    private earningArray earnings;
    private Random n;
    public date startingDate;
    public date endingDate;
    private static Scanner k;
    private static textoptions textoptions = new textoptions();
    private static String FILE = "";
    private static String FILEPATH = "/Users/lmao/Desktop/Coding Projects/Budget Tracking/budget_tracking/files/";
    private static final String DELIM = "\t";
    private static final String SEPERATOR = "/";


    public backend() { init(); }//Initialize the backend of program 

    public void init() { //Initialize array
        spendings = new entryArray();
        earnings = new earningArray();
        k = new Scanner(System.in);
    }

    public int getArraySize() { //Get array size
        return spendings.getSize();
    }

    public int getEarningArraySize() {
        return earnings.getSize();
    }

    public date getStartDate() { //Get start date
        return startingDate;
    }

    public date getEndDate() { //Get end date
        return endingDate;
    }

    public void setStartDate(date a) { //Set start date
        if(a.check(a.getMonth(), a.getDay(), a.getYear())) {
            date oldDate;
            if (endingDate != null) 
                oldDate = startingDate;
            else 
                oldDate = null;
            startingDate = a;
            setStartFile(a,oldDate);
        } else
            startingDate = new date(0,0,0);
    }

    public void setEndDate(date a) { //Set end date
        if(a.check(a.getMonth(), a.getDay(), a.getYear())) {
            date oldDate;
            if (endingDate != null) 
                oldDate = endingDate;
            else 
                oldDate = null;
            endingDate = a;
            setEndFile(a, oldDate);
        } else
            endingDate = new date(0,0,0);
    }

    public void setStartFile(date a, date old) { //Edit start date on file
        ArrayList<String> copy = new ArrayList<String>();
        try { //Read in file
            Scanner fileReader = new Scanner(new File(FILE));
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                if (line.equalsIgnoreCase("Starting Date:\t")) {
                    String something = "Starting Date:\t" + a.print();
                    copy.add(something);
                } else if (old != null && (line.equalsIgnoreCase("Starting Date:\t" + old.print()))) {
                    String[] splitLine = line.split("\t");
                    splitLine[1] = a.print();
                    String something = splitLine[0] + "\t" + splitLine[1];
                    copy.add(something);
                } else 
                    copy.add(line);
            }
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try { //Write to file
            BufferedWriter fileWriter = new BufferedWriter( new FileWriter(FILE));
            for(int i =0; i < copy.size(); i++) {
                fileWriter.write(copy.get(i) + "\n");
            }
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setEndFile(date a, date old) { //Set end date on file
        ArrayList<String> copy = new ArrayList<String>();
        try { //Read in file
            Scanner fileReader = new Scanner(new File(FILE));
            for (int i = 0; fileReader.hasNextLine(); i++) {
                String line = fileReader.nextLine();
                if (line.equalsIgnoreCase("Ending Date:\t")) {
                    String something = "Ending Date:\t" + a.print();
                    copy.add(something);
                } else if (old != null && (line.equalsIgnoreCase("Ending Date:\t" + old.print()))) {
                    String[] splitLine = line.split("\t");
                    splitLine[1] = a.print();
                    String something = splitLine[0] +  "\t" + splitLine[1];
                    copy.add(something);
                } else 
                    copy.add(line);
            }
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try { //Write to file
            BufferedWriter fileWriter = new BufferedWriter( new FileWriter(FILE));
            for(int i =0; i < copy.size(); i++) {
                fileWriter.write(copy.get(i) + "\n");
            }
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean checkStartDate() { //Check if starting date is null
        return (startingDate != null);
    }

    public boolean checkEndDate() { //Check if ending date is null
        return (endingDate != null);
    }

    public boolean checkDateBounds(date a) { //Check if date is within bounds
        if (!checkEndDate() && !checkStartDate()) { //No ending or starting dates
            return true;
        } else if (!checkEndDate()) { //No ending date
            if (a.getYear() > startingDate.getYear()) {
                return true;
            } else if (a.getYear() == startingDate.getYear() 
                && a.getMonth() > startingDate.getMonth()) {
                return true;
            } else if (a.getYear() == startingDate.getYear() 
                && a.getMonth() == startingDate.getMonth()
                && a.getDay() >= startingDate.getDay()) {
                return true;
            } else {
                System.out.println("Date not within bounds");
                return false;
            }
        } else if (!checkStartDate()) { //No starting date
            if (a.getYear() < endingDate.getYear()) {
                return true;
            } else if (a.getYear() == endingDate.getYear() 
                && a.getMonth() < endingDate.getMonth()) {
                return true;
            } else if (a.getYear() == endingDate.getYear() 
                && a.getMonth() == endingDate.getMonth()
                && a.getDay() <= endingDate.getDay()) {
                return true;
            } else {
                System.out.println("Date not within bounds");
                return false;
            }
        } else { //Both dates are set, comparing
            if (a.getYear() > startingDate.getYear() 
                && a.getYear() < endingDate.getYear()) {
                    return true;
            } else if (a.getYear() > startingDate.getYear() 
                && a.getYear() == endingDate.getYear()
                && a.getMonth() < endingDate.getMonth()) {
                    return true;
            } else if (a.getYear() > startingDate.getYear() 
                && a.getYear() == endingDate.getYear() 
                && a.getMonth() == endingDate.getMonth()
                && a.getDay() <= endingDate.getDay()) {
                    return true;
            } else if (a.getYear() < endingDate.getYear()
                && a.getYear() == startingDate.getYear() 
                && a.getMonth() > startingDate.getMonth()) {
                    return true;
            } else if (a.getYear() < endingDate.getYear()
                && a.getYear() == startingDate.getYear() 
                && a.getMonth() == startingDate.getMonth()
                && a.getDay() >= startingDate.getDay()) {
                    return true;
            } else if (a.getYear() == endingDate.getYear()
                && a.getYear() == startingDate.getYear() 
                && a.getMonth() > startingDate.getMonth() 
                && a.getMonth() < endingDate.getMonth()) {
                    return true;
            } else if (a.getYear() == endingDate.getYear()
                && a.getMonth() == endingDate.getMonth()
                && a.getDay() <= endingDate.getDay()
                && a.getYear() == startingDate.getYear() 
                && a.getMonth() > startingDate.getMonth()) {
                    return true;
            } else if (a.getYear() == endingDate.getYear()
                && a.getMonth() < endingDate.getMonth()
                && a.getDay() >= startingDate.getDay()
                && a.getYear() == startingDate.getYear() 
                && a.getMonth() == startingDate.getMonth()) {
                    return true;
            } else if (a.getYear() == endingDate.getYear() 
                && a.getMonth() == endingDate.getMonth()
                && a.getYear() == startingDate.getYear() 
                && a.getMonth() == startingDate.getMonth()
                && a.getDay() <= endingDate.getDay()
                && a.getDay() >= startingDate.getDay()) {
                    return true;
            } else { //Date does not pass
                System.out.println("Date not within bounds");
                return false;
            }
        }
    }

    public boolean compareStartDate(date b) { //Compare date to start date
        if (!checkStartDate()) {
            return true;
        } else {
            if (b.getYear() > startingDate.getYear()) {
                return true;
            } else if (b.getYear() == startingDate.getYear() 
                && b.getMonth() > startingDate.getMonth()) {
                return true;
            } else if (b.getYear() == startingDate.getYear() 
                && b.getMonth() == startingDate.getMonth()
                && b.getDay() > startingDate.getDay()) {
                return true;
            } else {
                System.out.println("Date not within bounds");
                return false;
            }
        }
    }

    public boolean compareEndDate(date b) { //Compare date to end date
        if (!checkEndDate()) {
            return true;
        } else {
            if (b.getYear() < endingDate.getYear()) {
                return true;
            } else if (b.getYear() == endingDate.getYear() 
                && b.getMonth() < endingDate.getMonth()) {
                return true;
            } else if (b.getYear() == endingDate.getYear() 
                && b.getMonth() == endingDate.getMonth()
                && b.getDay() < endingDate.getDay()) {
                return true;
            } else {
                System.out.println("Date not within bounds");
                return false;
            }
        }
    }

    public boolean datesEqual() {
        boolean ret = false;
        if (startingDate != null && endingDate != null) {
            if (startingDate.getDay() == endingDate .getDay()
                && startingDate.getMonth() == endingDate.getMonth()
                && startingDate.getYear() == endingDate.getYear())
                ret = true;
        }
        return ret;
    }

    public boolean datesMonthEqual() {
        boolean ret = false;
        if (startingDate != null && endingDate != null) {
            if (startingDate.getMonth() == endingDate.getMonth()) 
                ret = true;
        }
        return ret;
    }

    public boolean datesYearEqual() {
        boolean ret = false;
        if (startingDate != null && endingDate != null) {
            if (startingDate.getYear() == endingDate.getYear()) 
                ret = true;
        }
        return ret;
    }

    public void checkWhatDatesSet() {
        if (!checkStartDate() && !checkEndDate()) 
            noDatesSet();
        else if (!checkStartDate() && checkEndDate()) {
            boolean deer = false;
            while (!deer) { 
                run.p("There's no starting date set yet, would you like to set that up now?");
                System.out.print("(y/n) ");
                String input = k.nextLine();

                if (input.equalsIgnoreCase("y")) { //Set starting date
                    noStartDateSet();
                    deer = true;
                } else if (input.equalsIgnoreCase("n")) { //Not setting date
                    run.p("");
                    deer = true;
                } else 
                    run.p("Invalid input\n");
            }
        } 
        else if (checkStartDate() && !checkEndDate()) {
            boolean deer = false;
            while (!deer) {
                run.p("There's no ending date set yet, would you like to set that up now?");
                System.out.print("(y/n) ");
                String input = k.nextLine();

                if (input.equalsIgnoreCase("y")) { //Setting ending date
                    noEndDateSet();
                    deer = true;
                } else if (input.equalsIgnoreCase("n")) { //Not setting date
                    run.p("");
                    deer = true;
                } else 
                    run.p("Invalid input\n");
            }
        }
    }

    public void noDatesSet() {
        boolean deer = false;
        while (!deer) { 
            run.p("There's no starting date set yet, would you like to set that up now?");
            System.out.print("(y/n) ");
            String input = k.nextLine();

            if (input.equalsIgnoreCase("y")) { //Set starting date
                noStartDateSet();
                deer = true;
            } else if (input.equalsIgnoreCase("n")) { //Not setting date
                run.p("");
                deer = true;
            } else 
                run.p("Invalid input\n");
        }

        deer = false;
        while (!deer) {
            run.p("There's no ending date set yet, would you like to set that up now?");
            System.out.print("(y/n) ");
            String input = k.nextLine();

            if (input.equalsIgnoreCase("y")) { //Setting ending date
                noEndDateSet();
                deer = true;
            } else if (input.equalsIgnoreCase("n")) { //Not setting date
                run.p("");
                deer = true;
            } else 
                run.p("Invalid input\n");
        }
    }

    public void noStartDateSet() {
        run.clear();
        boolean x = false;
        while(!x) {
            run.pb("Set Starting date:\n");

            textoptions.monthChoice();
            int month = k.nextInt();
            System.out.print("\nMonth Selected: " + textoptions.numberToMonth(month));

            System.out.print("\nDay: ");
            int day = k.nextInt();

            System.out.print("Year: ");
            int year = k.nextInt();

            date a = new date(month,day,year);
            if(a.check(a.getMonth(), a.getDay(), a.getYear()) 
                && compareEndDate(a)) {
                run.clear();
                run.p("Date set successfully!");
                run.p("Starting date: " + month + "/" + day + "/" + year);
                run.p("");
                setStartDate(a);
                x = true;
                
                for(int i = 0; i < getArraySize(); i++) {
                    if (!checkDateBounds(getEntry(i).getDate())) {
                        run.p("Entry no longer in bounds, removing...");
                        String name = getEntry(i).getName();
                        double amount = getEntry(i).getAmount();
                        date date = getEntry(i).getDate();
                        removeEntry(name,amount,date);
                        run.p("Removed!\n");
                    } 
                }
            } else {
                run.clear();
                run.p("Not valid date\n");      
            }                
        }
    }

    public void noEndDateSet() {
        run.clear();
        boolean x = false;
        while(!x) {
            run.pb("Set Ending date:\n");

            textoptions.monthChoice();
            int month = k.nextInt();
            System.out.print("\nMonth Selected: " + textoptions.numberToMonth(month));

            System.out.print("\nDay: ");
            int day = k.nextInt();

            System.out.print("Year: ");
            int year = k.nextInt();

            date a = new date(month,day,year);
            if(a.check(a.getMonth(), a.getDay(), a.getYear()) 
                && compareStartDate(a)) {
                run.clear();
                run.p("Date set successfully!");
                run.p("Ending date: " + month + "/" + day + "/" + year);
                run.p("");
                setEndDate(a);
                x = true;
                
                for (int i = 0; i < getEarningArraySize(); i++) {
                    if (!checkDateBounds(getEarning(i).getDate())) {
                        run.p("Earning no longer in bounds, removing...");
                        String name = getEarning(i).getName();
                        double amount = getEarning(i).getAmount();
                        date date = getEarning(i).getDate();
                        removeEarning(name,amount,date);
                        run.p("Removed!\n");
                    }
                }
            } else {
                run.clear();
                run.p("Not valid date\n");       
            }               
        }
    }

    public void readFile() { //Reading in the file
        String firstLine = "";
        String line = "";
        boolean reset = false;
        int counter = 0;
        
        File f = new File(FILEPATH);
        String[] files = f.list();
        if (files.length != 0) {
            run.pb("Which file would you like to select?");
            for(int i = 0; i < files.length; i++) {
                if (files[i].equalsIgnoreCase("budget_tracking.txt")) {
                   
                    run.p((i+1) + ". Default " + "\033[3m(budget_tracking.txt)\033[0m"); 
                    
                } else
                    run.p((i+1) + ". " + files[i]);
            }
            run.p((files.length+1) + ". Quit Program");
            int choice = k.nextInt();
            if (choice == (files.length+1)) {
                run.p("\nQuitting program, goodbye");
                System.exit(0);
            } else {
                FILE = files[choice-1];
            }
        } else {
            FILE = "budget_tracking.txt";
            run.p("Setting up new file...");
        }
        
        wait(500);
        System.out.print("\nReading file " + FILE);
        boolean done = false;
        int count1 = 0;
        while (!done) {
            if (count1 == 3) {
                done = true;
            }
            System.out.print(".");
            wait(1000);
            count1++;
        }
        System.out.println("");

        //Removing Spendings and Earnings
        while(spendings.getSize() > 0) 
            spendings.removeEntry(spendings.getEntry(0).getName(), spendings.getEntry(0).getAmount(), spendings.getEntry(0).getDate());
        
        while(earnings.getSize() > 0) 
            earnings.removeEntry(earnings.getEarning(0).getName(), earnings.getEarning(0).getAmount(), earnings.getEarning(0).getDate());
        
        try { //Reading in file
            //File f = new File("/Users/lmao/Desktop/Coding Projects/Budget Tracking/budget_tracking/files");
            Scanner fileScanner = new Scanner(new File(FILEPATH + FILE));
            //PrintStream print = new File(FILE).list();
            if (fileScanner.hasNextLine()) {
                boolean tampered = false;
                if (counter == 0) {
                    firstLine = fileScanner.nextLine();
                    if (!firstLine.equalsIgnoreCase("budgettrackingprogram")){ //Checking if file has been tampered
                        System.out.println("File has been tampered with, resetting it...\n");
                        setUpFile();
                        reset = true;
                        tampered = true;
                    }
                }
                while(fileScanner.hasNextLine() && !tampered) { //Reading
                    line = fileScanner.nextLine();
                    if (line.startsWith("Starting Date:")) { //Reading starting date
                        String[] splitLine = line.split(DELIM);
                        if(splitLine.length == 2) {
                            String date = splitLine[1];
                            int seperator = date.indexOf(SEPERATOR);
                            String monthString = date.substring(0,seperator);
                            String everythingElse = date.substring(seperator + 1);
                            int month = Integer.parseInt(monthString);
                            seperator = everythingElse.indexOf(SEPERATOR);
                            String dayString = everythingElse.substring(0,seperator);
                            String yearString = everythingElse.substring(seperator + 1);
                            int day = Integer.parseInt(dayString);
                            int year = Integer.parseInt(yearString);
                            date a = new date(month, day, year);
                            if (a.check(month, day, year)) 
                                startingDate = a;
                            else {
                                startingDate = null;
                                System.out.println("File has been tampered with, would you like to reset the start date or reset the file?");
                                boolean hu = false;
                                while (!hu) {
                                    System.out.println("1. Reset date");
                                    System.out.println("2. Reset file");
                                    int choice = k.nextInt();
                                    System.out.println(choice);
                                    if (choice == 1) { //Reset date
                                        boolean xo = false;
                                        while(!xo) {
                                            System.out.println("\nSet Starting date:");
                                            System.out.print("Month: ");
                                            int montha = k.nextInt();
                                            System.out.print("Day: ");
                                            int daya = k.nextInt();
                                            System.out.print("Year: ");
                                            int yeara = k.nextInt();
                                            date cat = new date(montha,daya,yeara);
                                            if(cat.check(cat.getMonth(), cat.getDay(), cat.getYear()) 
                                               && compareEndDate(cat)) {
                                                setStartDate(cat);
                                                xo = true;
                                                hu = true;
                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();
                                                System.out.println("New Starting Date: " + cat.print() + "\n");
                                            } else 
                                                System.out.println("Not valid date\n");
                                        }
                                    } else if (choice == 2) { //Reset file
                                        tampered = true;
                                        setUpFile();
                                        hu = true;
                                        System.out.print("\033[H\033[2J");
                                        System.out.flush();
                                        System.out.println("File reset!\n");
                                    } else 
                                        System.out.println("Not valid input\n");
                                }
                            }
                        } else 
                            startingDate = null;
                    } else if (line.startsWith("Ending Date:")) { //Reading ending date
                        String[] splitLine = line.split(DELIM);
                        if(splitLine.length == 2) {
                            String date = splitLine[1];
                            int seperator = date.indexOf(SEPERATOR);
                            String monthString = date.substring(0,seperator);
                            String everythingElse = date.substring(seperator + 1);
                            int month = Integer.parseInt(monthString);
                            seperator = everythingElse.indexOf(SEPERATOR);
                            String dayString = everythingElse.substring(0,seperator);
                            String yearString = everythingElse.substring(seperator + 1);
                            int day = Integer.parseInt(dayString);
                            int year = Integer.parseInt(yearString);
                            date a = new date(month, day, year);
                            if (a.check(month, day, year)) 
                                endingDate = a;
                            else {
                                startingDate = null;
                                System.out.println("File has been tampered with, would you like to reset the end date or reset the file?");
                                boolean hu = false;
                                tampered = true;
                                while (!hu) {
                                    System.out.println("1. Reset date");
                                    System.out.println("2. Reset file");
                                    int choice = k.nextInt();
                                    if (choice == 1) { //Reset date
                                        boolean xo = false;
                                        while(!xo) {
                                            System.out.println("\nSet Ending date:");
                                            System.out.print("Month: ");
                                            int montha = k.nextInt();
                                            System.out.print("Day: ");
                                            int daya = k.nextInt();
                                            System.out.print("Year: ");
                                            int yeara = k.nextInt();
                                            date cat = new date(montha,daya,yeara);
                                            if(cat.check(cat.getMonth(), cat.getDay(), cat.getYear()) 
                                               && compareStartDate(cat)) {
                                                setEndDate(cat);
                                                xo = true;
                                                hu = true;
                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();
                                                System.out.println("New Ending Date: " + cat.print() + "\n");
                                            } else 
                                                System.out.println("Not valid date\n");
                                        }
                                    } else if (choice == 2) { //Reset file
                                        tampered = true;
                                        hu = true;
                                        setUpFile();
                                        run.clear();
                                        System.out.println("File reset!\n");
                                    } else 
                                        System.out.println("Not valid input\n");
                                }
                            }
                        } else 
                            endingDate = null;
                    } else if (line.equalsIgnoreCase("Earnings:") && (reset == false)) {
                        while(!line.equalsIgnoreCase("")) {
                            line = fileScanner.nextLine();
                            String[] splitLine = line.split(DELIM);
                            if (splitLine.length > 2) {
                                String name = splitLine[0];
                                String amountS = splitLine[1];
                                String date = splitLine[2];
                                double amount = Double.parseDouble(amountS);
                                int seperator = date.indexOf(SEPERATOR);
                                String monthString = date.substring(0,seperator);
                                String everythingElse = date.substring(seperator + 1);
                                int month = Integer.parseInt(monthString);
                                seperator = everythingElse.indexOf(SEPERATOR);
                                String dayString = everythingElse.substring(0,seperator);
                                String yearString = everythingElse.substring(seperator + 1);
                                int day = Integer.parseInt(dayString);
                                int year = Integer.parseInt(yearString);
                                date a = new date(month, day, year);
                                addAlreadyEarning(name,amount,a);
                                //run.p("Earning added: " + name + " " + amount + " " + a.printFull());
                            } else 
                                break;
                        }
                    } else if (line.equalsIgnoreCase("Entries:") && (reset == false)) { //Reading in entries
                        int count = 0;
                        while(fileScanner.hasNextLine()) {
                            if (count > 1000) { //Max 1000 entries
                                System.out.println("Infinite while loop, resetting file...\n");
                                setUpFile();
                            }
                            line = fileScanner.nextLine();
                            String[] splitLine = line.split(DELIM);
                            if (splitLine.length > 2) {
                                String name = splitLine[0];
                                String amountS = splitLine[1];
                                String date = splitLine[2];
                                double amount = Double.parseDouble(amountS);
                                int seperator = date.indexOf(SEPERATOR);
                                String monthString = date.substring(0,seperator);
                                String everythingElse = date.substring(seperator + 1);
                                int month = Integer.parseInt(monthString);
                                seperator = everythingElse.indexOf(SEPERATOR);
                                String dayString = everythingElse.substring(0,seperator);
                                String yearString = everythingElse.substring(seperator + 1);
                                int day = Integer.parseInt(dayString);
                                int year = Integer.parseInt(yearString);
                                date a = new date(month, day, year);
                                addAlreadyEntry(name,amount,a);
                                //run.p("Spendings added: " + name + " " + amount + " " + a.printFull());
                                count++;
                            } else 
                                break;
                        }
                    }
                    counter++;
                }
                if (!tampered) 
                    System.out.println("Success!\n");
            } else {
                System.out.println("Setting up file...\n");
                setUpFile();
            }
            wait(500);
            fileScanner.close();
        //Two exceptions that could happen:
        } catch (FileNotFoundException ex) {
            System.out.println("Setting up file...\n");
            setUpFile();
            System.out.println("Success!\n");
        } catch (NumberFormatException ex) {
            System.out.println("File formatted incorrectly, resetting...\n");
            setUpFile();
            System.out.println("Success!\n");
        }
    }

    public void setUpFile() { //Set up blank file
        startingDate = null;
        endingDate = null;
        try {
            PrintWriter fileWriter = new PrintWriter(new FileOutputStream(FILEPATH + FILE));
            fileWriter.write("budgettrackingprogram\n");
            fileWriter.write("\n");
            fileWriter.write("Starting Date:\t");
            fileWriter.write("\n");
            fileWriter.write("Ending Date:\t");
            fileWriter.write("\n");
            fileWriter.write("\nEarnings:\n");
            fileWriter.write("\nEntries:\n");
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveFile() { //"Saving" file
        ArrayList<String> copy = new ArrayList<String>();
        try {
            Scanner fileReader = new Scanner(new File(FILEPATH + FILE));
            for (int i = 0; fileReader.hasNextLine(); i++) {
                String line = fileReader.nextLine();
                copy.add(line);
            }
            fileReader.close();
        } catch (FileNotFoundException exception) {
            run.p("Somethings wrong, goodbye");
            System.exit(0);
        }

        try {
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(FILEPATH + FILE));
            for(int i = 0; i < copy.size(); i++) {
                fileWriter.write(copy.get(i) + "\n");
            }
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveToNewFile(String fileName) {
        ArrayList<String> copy = new ArrayList<String>();
        try {
            Scanner fileReader = new Scanner(new File(FILEPATH + FILE));
            while(fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                copy.add(line);
            }
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            BufferedWriter fileWriter = new BufferedWriter( new FileWriter(FILEPATH + fileName));
            for(int i = 0; i < copy.size(); i++) {
                fileWriter.write(copy.get(i) + "\n");
            }
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("File renamed to " + fileName + "...");
        System.out.println("Resetting file...");
        setUpFile();
        System.out.println("New file created!\n");
    }

    public void printFile() { //Print out file
        ArrayList<String> print = new ArrayList<String>();
        try {
            Scanner t = new Scanner(new File(FILEPATH + FILE));
            while (t.hasNextLine()) {
                String line = t.nextLine();
                print.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        run.p("FILE: " + FILE + ":\n");
        for(int i = 0; i < print.size(); i++) {
            System.out.println(print.get(i));
        }
        System.out.println("");
    }

    public void resetFile() { //Reset file
        System.out.println("Resetting file...\n");
        setUpFile();
    }

    public void addEntry(String name, double amount, date date) { //Adding entry
        spendings.addEntry(name, amount, date);
        try {
            BufferedWriter a = new BufferedWriter(new FileWriter(FILE,true));
            a.append(name + "\t" + amount + "\t" + date.print() + "\n");
            a.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addAlreadyEntry(String name, double amount, date date) { //Add entry from file
        spendings.addAlreadyEntry(name, amount, date);
    }

    public void addEarning(String name, double amount, date date) { //Adding entry
        earnings.addEntry(name, amount, date);
        ArrayList<String> copy = new ArrayList<String>();
        try { //Read in file
            Scanner fileReader = new Scanner(new File(FILE));
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                if (line.equalsIgnoreCase("Earnings:")) {
                    copy.add(line);
                    while(fileReader.hasNextLine()) {
                        String lines = fileReader.nextLine();
                        if (lines.equalsIgnoreCase("")) {
                            copy.add(name + "\t" + amount + "\t" + date.print() + "\n");
                            break;
                        } else 
                            copy.add(lines);
                    }
                } else 
                    copy.add(line);
            }
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try { //Write to file
            BufferedWriter fileWriter = new BufferedWriter( new FileWriter(FILE));
            for(int i =0; i < copy.size(); i++) {
                fileWriter.write(copy.get(i) + "\n");
            }
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addAlreadyEarning(String name, double amount, date date) { //Add entry from file
        earnings.addAlreadyEntry(name, amount, date);
    }

    public void removeEntry(String name, double amount, date date) { //Removing entry
        spendings.removeEntry(name, amount, date);
        ArrayList<String> copy = new ArrayList<String>();
        try {
            Scanner fileReader = new Scanner(new File(FILE));
            for (int i = 0; fileReader.hasNextLine(); i++) {
                String line = fileReader.nextLine();
                if (!line.equalsIgnoreCase(name + "\t" + amount + "\t" + date.print())) 
                    copy.add(line);
            }
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(FILE));
            for(int i =0; i < copy.size(); i++) {
                fileWriter.write(copy.get(i) + "\n");
            }
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeEarning(String name, double amount, date date) { //Removing entry
        earnings.removeEntry(name, amount, date);
        ArrayList<String> copy = new ArrayList<String>();
        try {
            Scanner fileReader = new Scanner(new File(FILE));
            for (int i = 0; fileReader.hasNextLine(); i++) {
                String line = fileReader.nextLine();
                if (!line.equalsIgnoreCase(name + "\t" + amount + "\t" + date.print())) 
                    copy.add(line);
            }
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(FILE));
            for(int i =0; i < copy.size(); i++) {
                fileWriter.write(copy.get(i) + "\n");
            }
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printEntries() { //Print out entries
        spendings.printData();
    }

    public void printEarnings() {
        earnings.printData();
    }

    public void sortByDateLHSpending() { //Print by date, low->high
        spendings.sortByDateLH();
        System.out.println("");
    } 

    public void sortByDateHLSpending() { //Print by date, high->low
        spendings.sortByDateHL();
        System.out.println("");
    }

    public void sortByDateLHEarning() { //Print by date, low->high
        earnings.sortByDateLH();
        System.out.println("");
    }

    public void sortByDateHLEarning() { //Print by date, high->low
        earnings.sortByDateHL();
        System.out.println("");
    }

    public void sortAmountLHSpending() { //Print by amount, low->high
        spendings.sortAmountLH();
        System.out.println("");
    }

    public void sortAmountHLSpending() { //Print by amount, high->low
        spendings.sortAmountHL();
        System.out.println("");
    }

    public void sortAmountLHEarning() { //Print by amount, low->high
        earnings.sortAmountLH();
        System.out.println("");
    }

    public void sortAmountHLEarning() { //Print by amount, high->low
        earnings.sortAmountHL();
        System.out.println("");
    }

    public void printRandom() { //Print random entry
        n = new Random();
        ArrayList<entry> combined = new ArrayList<entry>();
        for(int i = 0; i < spendings.getSize(); i++)
            combined.add(spendings.getEntry(i));
        for (int i = 0; i < earnings.getSize(); i++)
            combined.add(earnings.getEarning(i));
        if (combined.size()== 0) {
            System.out.println("No entries yet!");
        } else {
            int choice = n.nextInt(combined.size());
            if (choice < spendings.getSize()) 
                System.out.print(combined.get(choice).printFullSpending()+"\n");
            else 
                System.out.print(combined.get(choice).printFullEarning()+"\n");
        }   
    }

    public double totalSpent() { //Get total spendings
        return spendings.totalSpent();
    }

    public double totalSpentFood() { //Get total spendings on food
        return spendings.totalSpentFood();
    }

    public double totalSpentGas() { //Get total spendings on gas
        return spendings.totalSpentGas();
    }

    public double totalSpentClothes() { //Get total spendings on clothes
        return spendings.totalSpentClothes();
    }

    public double totalSpentGecko() { //Get total spendings on gecko
        return spendings.totalSpentGecko();
    }

    public double totalSpentNintendo() { //Get total spendings on nintendo
        return spendings.totalSpentNintendo();
    }

    public double totalSpentOther() { //Get total spendings on other things
        return spendings.totalSpentOther();
    }

    public double totalSpentSplice() { //Get total spendings on splice
        return spendings.totalSpentSplice();
    }

    public double totalSpentMovies() {
        return spendings.totalSpentMovies();
    }

    public double totalSpentPlant() {
        return spendings.totalSpentPlant();
    }

    public double totalSpentCVS() {
        return spendings.totalSpentCVS();
    }

    public double totalSpentRent() {
        return spendings.totalSpentRent();
    }

    public double totalSpentUtilities() {
        return spendings.totalSpentUtilities();
    }

    public double totalEarned() {
        return earnings.totalEarned();
    }

    public double totalEarnedVicars() {
        return earnings.totalEarnedVicars();
    }

    public double totalEarnedPublix() {
        return earnings.totalEarnedPublix();
    }

    public double totalEarnedPoshmark() {
        return earnings.totalEarnedPoshmark();
    }

    public double totalEarnedDepop() {
        return earnings.totalEarnedDepop();
    }

    public double totalEarnedShipt() {
        return earnings.totalEarnedShipt();
    }

    public double totalEarnedUSC() {
        return earnings.totalEarnedUSC();
    }

    public double totalEarnedStreaming() {
        return earnings.totalEarnedStreaming();
    }

    public double totalEarnedOther() {
        return earnings.totalEarnedOther();
    }

    public void printCategory() { //Print by various categories
        spendings.printCategory();
    }

    public void printCategoryEarnings() {
        earnings.printCategoryEarnings();
    }

    public String printIndex(int i) { //Get index of array
        return spendings.getIndex(i);
    }

    public String printIndey(int i) {
        return earnings.getIndey(i);
    }

    public entry getEntry(int i) { //Get entry at index of array
        return spendings.getEntry(i);
    }

    public entry getEarning(int i) {
        return earnings.getEarning(i);
    }

    public static void wait(int ms) {
    try
    {
        Thread.sleep(ms);
    }
    catch(InterruptedException ex)
    {
        Thread.currentThread().interrupt();
    }
    }
}
