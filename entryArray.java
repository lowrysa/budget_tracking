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
            System.out.println(array.get(i).print());
        }
    }

    public int getSize() {
        return array.size();
    }

    public void randomEntry(int i) {
        //System.out.println(i);
        System.out.println(array.get(i).printFull());
    }

    public double totalSpent() {
        double ret = 0.0;
        for (int i = 0; i < array.size(); i++) {
            ret += array.get(i).getAmount();
        }
        return ret;
    }

    public double totalSpentFood() {
        double ret = 0.0;
        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("food")) {
                ret += array.get(i).getAmount();
            } 
        }
        return ret;
    }

    public double totalSpentGas() {
        double ret = 0.0;
        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("gas")) {
                ret += array.get(i).getAmount();
            } 
        }
        return ret;
    }
    
    public double totalSpentClothes() {
        double ret = 0.0;
        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("clothes")) {
                ret += array.get(i).getAmount();
            } 
        }
        return ret;
    }

    public double totalSpentGecko() {
        double ret = 0.0;
        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("gecko")) {
                ret += array.get(i).getAmount();
            } 
        }
        return ret;
    }

    public double totalSpentNintendo() {
        double ret = 0.0;
        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("nintendo")) {
                ret += array.get(i).getAmount();
            } 
        }
        return ret;
    }

    public double totalSpentOther() {
        double ret = 0.0;
        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName() != ("Food") &&
                array.get(i).getName() != ("Nintendo") &&
                array.get(i).getName() != ("Clothes") &&
                array.get(i).getName() != ("Gas") &&
                array.get(i).getName() != ("Gecko") &&
                array.get(i).getName() != ("Nintendo")) {
                ret += array.get(i).getAmount();
            } 
        }
        return ret;
    }
}   
