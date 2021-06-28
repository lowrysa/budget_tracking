import java.util.Random;
public class backend {
    private entryArray array;
    private Random n;
    public date startingDate;
    public date endingDate;

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
        if(a.check(a.getMonth(), a.getDay(), a.getYear())) 
            startingDate = a;
        else
            startingDate = new date(0,0,0);
    }

    public void setEndDate(date a) {
        if(a.check(a.getMonth(), a.getDay(), a.getYear())) 
            endingDate = a;
        else
            endingDate = new date(0,0,0);
    }

    public void readFile() {

    }

    public void saveFile() {

    }

    public void addEntry(String name, double amount, date date) {
        array.addEntry(name, amount, date);
    }

    public void removeEntry(String name, double amount, date date) {
        array.removeEntry(name, amount, date);
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

    public void printCategory() {
        array.printCategory();
    }
}
