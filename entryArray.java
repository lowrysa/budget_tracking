import java.util.ArrayList;
import java.util.Collections;
public class entryArray {
    private ArrayList<entry> array;

    public entryArray() { //Constructor
        array = new ArrayList<>();
    }

    public void addEntry(String name, double amount, date date) { //Adding entry
        entry a = new entry();
        a.setAmount(amount);
        a.setName(name);
        a.setDate(date);
        array.add(a);
        System.out.println("Added Successfully!");
    }

    public void addAlreadyEntry(String name, double amount, date date) { //Adding entry from file
        entry a = new entry();
        a.setAmount(amount);
        a.setName(name);
        a.setDate(date);
        array.add(a);
    }

    public void removeEntry(String name, double amount, date date) { //Remove entry
        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase(name) &&
                array.get(i).getAmount() == amount &&
                array.get(i).getDate().getMonth() == date.getMonth() &&
                array.get(i).getDate().getDay() == date.getDay() &&
                array.get(i).getDate().getYear() == date.getYear()) {
                    array.remove(i);
                    return;
            } 
        }
        System.out.println("Not found!");
    }

    public void printData() { //Print data
        if (array.isEmpty()) {
            System.out.println("No spendings yet!");
            return;
        } 
        for(int i = 0; i < array.size(); i++) 
            System.out.println(array.get(i).print());
        System.out.println("");
    }

    public int getSize() { //Get size of array
        return array.size();
    }

    public double totalSpent() { //Get total spendings
        double ret = 0.0;
        for (int i = 0; i < array.size(); i++) {
            ret += array.get(i).getAmount();
        }
        return ret;
    }

    public double totalSpentFood() { //Get total spendings on food
        double ret = 0.0;
        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("eat out")
                || array.get(i).getName().equalsIgnoreCase("groceries")
                || array.get(i).getName().equalsIgnoreCase("ice cream")) {
                ret += array.get(i).getAmount();
            } 
        }
        return ret;
    }

    public double totalSpentGas() { //Get total spendings on gas
        double ret = 0.0;
        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("gas")) {
                ret += array.get(i).getAmount();
            } 
        }
        return ret;
    }
    
    public double totalSpentClothes() { //Get total spendings on clothes
        double ret = 0.0;
        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("clothes")) {
                ret += array.get(i).getAmount();
            } 
        }
        return ret;
    }

    public double totalSpentGecko() { //Get total spendings on gecko
        double ret = 0.0;
        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("gecko")) {
                ret += array.get(i).getAmount();
            } 
        }
        return ret;
    }

    public double totalSpentNintendo() { //Get total spendings on nintendo
        double ret = 0.0;
        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("nintendo")) {
                ret += array.get(i).getAmount();
            } 
        }
        return ret;
    }

    public double totalSpentSplice() { //Get total spendings on splice
        double ret = 0.0;
        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("splice")) {
                ret += array.get(i).getAmount();
            } 
        }
        return ret;
    }

    public double totalSpentMovies() { //Get total spendings on movies
        double ret = 0.0;
        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("movies")) {
                ret += array.get(i).getAmount();
            } 
        }
        return ret;
    }

    public double totalSpentPlant() { //Get total spendings on plants
        double ret = 0.0;
        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("plant")) {
                ret += array.get(i).getAmount();
            } 
        }
        return ret;
    }

    public double totalSpentCVS() { //Get total spendings on cvs
        double ret = 0.0;
        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("cvs")) {
                ret += array.get(i).getAmount();
            } 
        }
        return ret;
    }
    public double totalSpentRent() { //Get total spendings on rent
        double ret = 0.0;
        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("Rent")) {
                ret += array.get(i).getAmount();
            } 
        }
        return ret;
    }

    public double totalSpentUtilities() { //Get total spendings on utilities
        double ret = 0.0;
        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("Utilities")) {
                ret += array.get(i).getAmount();
            } 
        }
        return ret;
    }


    public double totalSpentOther() { //Get total spendings on other things
        double ret = 0.0;
        for(int i = 0; i < array.size(); i++) {
            if (!array.get(i).getName().equalsIgnoreCase("Eat Out") &&
                !array.get(i).getName().equalsIgnoreCase("groceries") &&
                !array.get(i).getName().equalsIgnoreCase("ice cream") &&
                !array.get(i).getName().equalsIgnoreCase("nintendo") &&
                !array.get(i).getName().equalsIgnoreCase("clothes") &&
                !array.get(i).getName().equalsIgnoreCase("Gas") &&
                !array.get(i).getName().equalsIgnoreCase("Gecko") &&
                !array.get(i).getName().equalsIgnoreCase("Splice") &&
                !array.get(i).getName().equalsIgnoreCase("Movies") &&
                !array.get(i).getName().equalsIgnoreCase("Plant") &&
                !array.get(i).getName().equalsIgnoreCase("CVS") &&
                !array.get(i).getName().equalsIgnoreCase("Rent") &&
                !array.get(i).getName().equalsIgnoreCase("Utilities") &&
                !array.get(i).getName().equalsIgnoreCase("Nintendo")) 
                    ret += array.get(i).getAmount();
        }
        return ret;
    }

    public void sortByDateLH() { //Sort and print by date, low->high
        ArrayList<entry> newArray = new ArrayList<>();
        for(int i = 0; i < array.size(); i++) //Copy Array over
            newArray.add(array.get(i));
        
        boolean done = false;
        while(!done) {
            int flip = 0;
            for(int i = 0; i < newArray.size() - 1; i++) {
                if(newArray.get(i+1) == null) {
                    break;
                }
                if (newArray.get(i).getDate().getYear() > newArray.get(i + 1).getDate().getYear()) {
                    Collections.swap(newArray, i, i+1);
                    flip++;
                } else if (newArray.get(i).getDate().getMonth() > newArray.get(i + 1).getDate().getMonth()) {
                    Collections.swap(newArray, i, i+1);
                    flip++;
                } else if (newArray.get(i).getDate().getDay() > newArray.get(i + 1).getDate().getDay()) {
                    Collections.swap(newArray, i, i+1);
                    flip++;
                }
            }
            if(flip == 0) {
                done = true;
            }
        }

        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Oldest to Newest:");
        for(int i = 0; i < newArray.size(); i++) //Print newArray
            System.out.println(newArray.get(i).print());
        
    }

    public void sortByDateHL() { //Sort and print by date, high->low
        ArrayList<entry> newArray = new ArrayList<>();
        for(int i = 0; i < array.size(); i++) //Copy Array over
            newArray.add(array.get(i));
        
        boolean done = false;
        int a = 0;
        while(!done) {
            int flip = 0;
            for(int i = 0; i < newArray.size() - 1; i++) {
                if(newArray.get(i+1) == null) {
                    break;
                }
                if (newArray.get(i).getDate().getYear() < newArray.get(i + 1).getDate().getYear()) {
                    Collections.swap(newArray, i, i+1);
                    flip++;
                } else if (newArray.get(i).getDate().getMonth() < newArray.get(i + 1).getDate().getMonth()) {
                    Collections.swap(newArray, i, i+1);
                    flip++;
                } else if (newArray.get(i).getDate().getDay() < newArray.get(i + 1).getDate().getDay()) {
                    Collections.swap(newArray, i, i+1);
                    flip++;
                }
            }
            if(flip == 0) {
                done = true;
            }
        }

        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Newest to Oldest:");
        for(int i = 0; i < newArray.size(); i++) //Print newArray
            System.out.println(newArray.get(i).print());
        
    }

    public void sortAmountLH() { //Sort and print by amount, low->high
        ArrayList<entry> newArray = new ArrayList<>();
        for(int i = 0; i < array.size(); i++) //Copy Array over
            newArray.add(array.get(i));
        
        boolean done = false;
        while(!done) {
            int flip = 0;
            for(int i = 0; i < newArray.size() - 1; i++) {
                if(newArray.get(i+1) == null) {
                    break;
                }
                if (newArray.get(i).getAmount() > newArray.get(i + 1).getAmount()) {
                   Collections.swap(newArray, i, i+1);
                   flip++;
                }
            }
            if(flip == 0) {
                done = true;
            }
        }

        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Low to High:");
        for(int i = 0; i < newArray.size(); i++) //Print newArray
            System.out.println(newArray.get(i).print());
        
    }

    public void sortAmountHL() { //Sort and print, high->low
        ArrayList<entry> newArray = new ArrayList<>();
        for(int i = 0; i < array.size(); i++) //Copy Array over
            newArray.add(array.get(i));
    
        boolean done = false;
        while(!done) {
            int flip = 0;
            for(int i = 0; i < newArray.size() - 1; i++) {
                if(newArray.get(i+1) == null) {
                    break;
                }
                if (newArray.get(i).getAmount() < newArray.get(i + 1).getAmount()) {
                   Collections.swap(newArray, i, i+1);
                   flip++;
                }
            }
            if(flip == 0) {
                done = true;
            }
        }

        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("High to Low:");
        for(int i = 0; i < newArray.size(); i++) //Print newArray
            System.out.println(newArray.get(i).print());
        
    }

    public void printCategory() { //Sort and print categories
        ArrayList<entry> eatOut = new ArrayList<>();
        ArrayList<entry> groceries = new ArrayList<>();
        ArrayList<entry> iceCream = new ArrayList<>();
        ArrayList<entry> gas = new ArrayList<>();
        ArrayList<entry> clothes = new ArrayList<>();
        ArrayList<entry> gecko = new ArrayList<>();
        ArrayList<entry> nintendo = new ArrayList<>();
        ArrayList<entry> splice = new ArrayList<>();
        ArrayList<entry> movies = new ArrayList<>();
        ArrayList<entry> plant = new ArrayList<>();
        ArrayList<entry> cvs = new ArrayList<>();
        ArrayList<entry> rent = new ArrayList<>();
        ArrayList<entry> utilities = new ArrayList<>();
        ArrayList<entry> other = new ArrayList<>();

        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("eat out")) 
                eatOut.add(array.get(i));
        }

        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("groceries")) 
                groceries.add(array.get(i));
        }

        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("ice cream")) 
                iceCream.add(array.get(i));
        }

        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("gas")) 
                gas.add(array.get(i));
        }

        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("clothes")) 
                clothes.add(array.get(i));
        }

        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("gecko")) 
                gecko.add(array.get(i));
        }

        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("nintendo")) 
                nintendo.add(array.get(i));
        }

        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("splice")) 
                splice.add(array.get(i));
        }

        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("movies")) 
                movies.add(array.get(i));
        }

        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("plant")) 
                plant.add(array.get(i));
        }

        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("cvs")) 
                cvs.add(array.get(i));
        }

        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("rent")) 
                rent.add(array.get(i));
        }

        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("utilities")) 
                utilities.add(array.get(i));
        }

        for(int i = 0; i < array.size(); i++) {
            if (!array.get(i).getName().equalsIgnoreCase("Eat Out") &&
                !array.get(i).getName().equalsIgnoreCase("groceries") &&
                !array.get(i).getName().equalsIgnoreCase("ice cream") &&
                !array.get(i).getName().equalsIgnoreCase("nintendo") &&
                !array.get(i).getName().equalsIgnoreCase("clothes") &&
                !array.get(i).getName().equalsIgnoreCase("Gas") &&
                !array.get(i).getName().equalsIgnoreCase("Gecko") &&
                !array.get(i).getName().equalsIgnoreCase("Splice") &&
                !array.get(i).getName().equalsIgnoreCase("Movies") &&
                !array.get(i).getName().equalsIgnoreCase("Plant") &&
                !array.get(i).getName().equalsIgnoreCase("CVS") &&
                !array.get(i).getName().equalsIgnoreCase("utlities") &&
                !array.get(i).getName().equalsIgnoreCase("Rent") &&
                !array.get(i).getName().equalsIgnoreCase("Nintendo")) 
                    other.add(array.get(i));
        }

        if(!eatOut.isEmpty()) {
            System.out.println("Eat Out:");
            for(int i = 0; i < eatOut.size(); i++) 
                System.out.println(eatOut.get(i).print());
            System.out.println("");
        }
        
        if (!groceries.isEmpty()) {
            System.out.println("Groceries:");
            for(int i = 0; i < groceries.size(); i++) 
                System.out.println(groceries.get(i).print());
            System.out.println("");
        }
        
        if (!iceCream.isEmpty()) {
            System.out.println("Ice Cream:");
            for(int i = 0; i < iceCream.size(); i++) 
               System.out.println(iceCream.get(i).print());
            System.out.println("");
        }
        
        if (!gas.isEmpty()) {
            System.out.println("Gas:");
            for(int i = 0; i < gas.size(); i++) 
                System.out.println(gas.get(i).print());
            System.out.println("");
        }
        
        if (!clothes.isEmpty()) {
            System.out.println("Clothes:");
            for(int i = 0; i < clothes.size(); i++) 
                System.out.println(clothes.get(i).print());
            System.out.println("");
        }
        
        if (!gecko.isEmpty()) {
            System.out.println("Gecko:");
            for(int i = 0; i < gecko.size(); i++) 
                System.out.println(gecko.get(i).print());
            System.out.println("");
        }
        
        if (!nintendo.isEmpty()) {
            System.out.println("Nintendo:");
            for(int i = 0; i < nintendo.size(); i++) 
                System.out.println(nintendo.get(i).print());
            System.out.println("");
        }

        if (!splice.isEmpty()) {
            System.out.println("Splice:");
            for(int i = 0; i < splice.size(); i++) 
                System.out.println(splice.get(i).print());
            System.out.println("");
        }

        if (!movies.isEmpty()) {
            System.out.println("Movies:");
            for(int i = 0; i < movies.size(); i++) 
                System.out.println(movies.get(i).print());
            System.out.println("");
        }

        if (!plant.isEmpty()) {
            System.out.println("Plants:");
            for(int i = 0; i < plant.size(); i++) 
                System.out.println(plant.get(i).print());
            System.out.println("");
        }

        if (!cvs.isEmpty()) {
            System.out.println("CVS:");
            for(int i = 0; i < cvs.size(); i++) 
                System.out.println(cvs.get(i).print());
            System.out.println("");
        }

        if (!rent.isEmpty()) {
            System.out.println("Rent:");
            for(int i = 0; i < cvs.size(); i++) 
                System.out.println(rent.get(i).print());
            System.out.println("");
        }

        if (!utilities.isEmpty()) {
            System.out.println("Utilities:");
            for(int i = 0; i < cvs.size(); i++) 
                System.out.println(utilities.get(i).print());
            System.out.println("");
        }
        
        if (!other.isEmpty()) {
            System.out.println("Other:");
            for(int i = 0; i < other.size(); i++) 
                System.out.println(other.get(i).print());
            System.out.println("");
        }
    }

    public String getIndex(int i) { //Print full entry at index
        return array.get(i).printFull();
    }

    public entry getEntry(int i) { //Get entry at index
        return array.get(i);
    }
}   
