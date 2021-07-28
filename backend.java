import java.util.Random;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
public class backend {
    private entryArray array;
    private Random n;
    public date startingDate;
    public date endingDate;
    //private ArrayList<String> entries;
    private static final String FILE = "budget_tracking.txt";
    private static final String DELIM = "\t";
    private static final String SEPERATOR = "/";


    public backend() {
        init();
    }

    public void init() {
        array = new entryArray();
    }

    public date getStartDate() {
        return startingDate;
    }

    public date getEndDate() {
        return endingDate;
    }

    public void setStartDate(date a) {
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

    public void setStartFile(date a, date old) {
        ArrayList<String> copy = new ArrayList<>();
        try {
            Scanner fileReader = new Scanner(new File(FILE));
            for (int i = 0; fileReader.hasNextLine(); i++) {
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

        try {
            BufferedWriter fileWriter = new BufferedWriter( new FileWriter(FILE));
            for(int i =0; i < copy.size(); i++) {
                fileWriter.write(copy.get(i) + "\n");
            }
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setEndDate(date a) {
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

    public void setEndFile(date a, date old) {
        ArrayList<String> copy = new ArrayList<>();
        try {
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

        try {
            BufferedWriter fileWriter = new BufferedWriter( new FileWriter(FILE));
            for(int i =0; i < copy.size(); i++) {
                fileWriter.write(copy.get(i) + "\n");
            }
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean checkDates() {
        if (startingDate == null) 
            return false;
        else
            return true;
    }

    public boolean checkEndDate() {
        if (endingDate == null) 
            return false;
         else
            return true;
    }

    public boolean checkDateBounds(date a) {
        if (!checkEndDate() && !checkDates()) {
            return true;
        } else if (!checkEndDate()) {
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
        } else if (!checkDates()) {
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
        } else {
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
            } else {
                System.out.println("Date not within bounds");
                return false;
            }
        }
    }

    public boolean compareStartDate(date b) {
        if (!checkDates()) {
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

    public boolean compareEndDate(date b) {
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

    public void readFile() {
        //entries = new ArrayList<>();
        String firstLine = "";
        String line = "";
        boolean reset = false;
        int counter = 0;
        try {
            Scanner fileScanner = new Scanner(new File(FILE));
            if (fileScanner.hasNextLine()) {
                if (counter == 0) {
                    firstLine = fileScanner.nextLine();
                    if (!firstLine.equalsIgnoreCase("budgettrackingprogram")){
                        System.out.println("File has been tampered with, resetting it...\n");
                        setUpFile();
                        reset = true;
                    }
                }
                while(fileScanner.hasNextLine()) {
                    line = fileScanner.nextLine();
                    if (line.startsWith("Starting Date:")) {
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
                            startingDate = a;
                        } else {
                            startingDate = null;
                        }
                    } else if (line.startsWith("Ending Date:")) {
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
                            endingDate = a;
                        } else {
                            endingDate = null;
                        }
                    } else if (line.equalsIgnoreCase("Entries:") && (reset == false)) {
                        int count = 0;
                        while(fileScanner.hasNextLine()) {
                            if (count > 1000) {
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
                                count++;
                            } else 
                                break;
                        }
                    }
                    counter++;
                }
            } else {
                System.out.println("Setting up file...\n");
                setUpFile();
            }
            fileScanner.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Setting up file...\n");
            setUpFile();
        } catch (NumberFormatException ex) {
            System.out.println("File formatted incorrectly, resetting...\n");
            setUpFile();
        }
    }

    public void setUpFile() {
        startingDate = null;
        endingDate = null;
        try {
            PrintWriter fileWriter = new PrintWriter(new FileOutputStream(FILE));
            fileWriter.write("budgettrackingprogram\n");
            fileWriter.write("\n");
            fileWriter.write("Starting Date:\t");
            fileWriter.write("\n");
            fileWriter.write("Ending Date:\t");
            fileWriter.write("\n");
            fileWriter.write("\nEntries:\n");
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void saveFile() {
        ArrayList<String> copy = new ArrayList<>();
        try {
            Scanner fileReader = new Scanner(new File(FILE));
            for (int i = 0; fileReader.hasNextLine(); i++) {
                String line = fileReader.nextLine();
                copy.add(line);
            }
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            BufferedWriter fileWriter = new BufferedWriter( new FileWriter(FILE));
            for(int i =0; i < copy.size(); i++) {
                fileWriter.write(copy.get(i) + "\n");
            }
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addEntry(String name, double amount, date date) {
        array.addEntry(name, amount, date);
        try {
            BufferedWriter a = new BufferedWriter(new FileWriter(FILE,true));
            a.append(name + "\t" + amount + "\t" + date.print() + "\n");
            a.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addAlreadyEntry(String name, double amount, date date) {
        array.addAlreadyEntry(name, amount, date);
    }

    public void removeEntry(String name, double amount, date date) {
        array.removeEntry(name, amount, date);
        ArrayList<String> copy = new ArrayList<>();
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

    public void printEntries() {
        array.printData();
    }

    public void sortByDateLH() {
        array.sortByDateLH();
        System.out.println("");
    } 

    public void sortByDateHL() {
        array.sortByDateHL();
        System.out.println("");
    }

    public void sortAmountLH() {
        array.sortAmountLH();
        System.out.println("");
    }

    public void sortAmountHL() {
        array.sortAmountHL();
        System.out.println("");
    }

    public void printRandom() {
        n = new Random();
        if (array.getSize() == 0) {
            System.out.println("No entries yet!");
        } else {
            int choice = n.nextInt(array.getSize());
            //System.out.println(choice);
            array.randomEntry(choice);
        }  
    }

    public double totalSpent() {
        return array.totalSpent();
    }

    public double totalSpentFood() {
        return array.totalSpentFood();
    }

    public double totalSpentGas() {
        return array.totalSpentGas();
    }

    public double totalSpentClothes() {
        return array.totalSpentClothes();
    }

    public double totalSpentGecko() {
        return array.totalSpentGecko();
    }

    public double totalSpentNintendo() {
        return array.totalSpentNintendo();
    }

    public double totalSpentOther() {
        return array.totalSpentOther();
    }

    public double totalSpentSplice() {
        return array.totalSpentSplice();
    }

    public void printCategory() {
        array.printCategory();
    }

    public void printFile() {
        ArrayList<String> print = new ArrayList<>();
        try {
            Scanner t = new Scanner(new File(FILE));
            while (t.hasNextLine()) {
                String line = t.nextLine();
                print.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(FILE + ":\n");
        for(int i = 0; i < print.size(); i++) {
            System.out.println(print.get(i));
        }
        System.out.println("");
    }

    public void resetFile() {
        System.out.println("Resetting file...\n");
        setUpFile();
    }
}
