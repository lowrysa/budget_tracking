import java.util.Random;
public class backend {
    private entryArray array;
    private Random n;
    public backend() {
        init();
    }

    public void init() {
        array = new entryArray();
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

    public void sortAlphabeticallyAZ() {

    }

    public void sortAlphabeticallyZA() {

    }

    public void sortByDateLH() {

    } 

    public void sortByDateHL() {

    }

    public void sortAmountLH() {

    }

    public void sortAmountHL() {

    }

    public void printRandom() {
        n = new Random();
        int choice = n.nextInt(array.getSize());
        array.randomEntry(choice);
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
}
