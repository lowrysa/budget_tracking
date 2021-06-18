public class backend {
    private entryArray array;
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
}
