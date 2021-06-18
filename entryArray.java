import java.util.ArrayList;
public class entryArray {
    private ArrayList<entry> array;

    public entryArray() {
        array = new ArrayList<>();
    }

    public void addEntry(String name, double amount, date date) {
        entry a = new entry();
        a.setAmount(amount);
        a.setName(name);
        a.setDate(date);
        array.add(a);
        System.out.println("Added Successfully!");
    }

    public void removeEntry(String name, double amount, date date) {
        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase(name) &&
                array.get(i).getAmount() == amount &&
                array.get(i).getDate().getMonth() == date.getMonth() &&
                array.get(i).getDate().getDay() == date.getDay() &&
                array.get(i).getDate().getYear() == date.getYear()) {
                    array.get(i).remove(array.get(i));
                    System.out.println("Removed!");
                    break;
            } else
                System.out.println("Not found!");
        }
    }

    public void printData() {
        if (array.isEmpty()) {
            System.out.println("No entries");
            return;
        } 
        for(int i = 0; i < array.size(); i++) {
            array.get(i).print();
        }
    }
}   
