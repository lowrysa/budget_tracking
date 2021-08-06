import java.util.ArrayList;
public class earningArray {
    private ArrayList<entry> array;

    public earningArray() { //Constructor
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
            System.out.println("No earnings yet!\n");
            return;
        } 
        for(int i = 0; i < array.size(); i++) 
            System.out.println(array.get(i).print());
        System.out.println("");
    }

    public int getSize() { //Get size of array
        return array.size();
    }

    public double totalEarned() { //Get total earnings
        double ret = 0.0;
        for (int i = 0; i < array.size(); i++) {
            ret += array.get(i).getAmount();
        }
        return ret;
    }

    public double totalEarnedVicars() { //Get total spendings on gas
        double ret = 0.0;
        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("Vicars")) {
                ret += array.get(i).getAmount();
            } 
        }
        return ret;
    }

    public double totalEarnedPublix() { //Get total spendings on gas
        double ret = 0.0;
        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("Publix")) {
                ret += array.get(i).getAmount();
            } 
        }
        return ret;
    }

    public double totalEarnedPoshmark() { //Get total spendings on gas
        double ret = 0.0;
        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("Poshmark")) {
                ret += array.get(i).getAmount();
            } 
        }
        return ret;
    }

    public double totalEarnedDepop() { //Get total spendings on gas
        double ret = 0.0;
        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("Depop")) {
                ret += array.get(i).getAmount();
            } 
        }
        return ret;
    }

    public double totalEarnedShipt() { //Get total spendings on gas
        double ret = 0.0;
        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("Shipt")) {
                ret += array.get(i).getAmount();
            } 
        }
        return ret;
    }

    public double totalEarnedUSC() { //Get total spendings on gas
        double ret = 0.0;
        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("USC")) {
                ret += array.get(i).getAmount();
            } 
        }
        return ret;
    }

    public double totalEarnedStreaming() { //Get total spendings on gas
        double ret = 0.0;
        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("Streaming")) {
                ret += array.get(i).getAmount();
            } 
        }
        return ret;
    }

    public double totalEarnedOther() { //Get total spendings on other things
        double ret = 0.0;
        for(int i = 0; i < array.size(); i++) {
            if (!array.get(i).getName().equalsIgnoreCase("Vicars") &&
                !array.get(i).getName().equalsIgnoreCase("Publix") &&
                !array.get(i).getName().equalsIgnoreCase("Poshmark") &&
                !array.get(i).getName().equalsIgnoreCase("Depop") &&
                !array.get(i).getName().equalsIgnoreCase("Shipt") &&
                !array.get(i).getName().equalsIgnoreCase("Streaming") &&
                !array.get(i).getName().equalsIgnoreCase("USC")) 
                    ret += array.get(i).getAmount();
        }
        return ret;
    }

    public void printCategoryEarnings() { //Sort and print categories
        ArrayList<entry> vicars = new ArrayList<>();
        ArrayList<entry> publix = new ArrayList<>();
        ArrayList<entry> usc = new ArrayList<>();
        ArrayList<entry> poshmark = new ArrayList<>();
        ArrayList<entry> depop = new ArrayList<>();
        ArrayList<entry> streaming = new ArrayList<>();
        ArrayList<entry> shipt = new ArrayList<>();
        ArrayList<entry> other = new ArrayList<>();
        

        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("vicars")) 
                vicars.add(array.get(i));
        }

        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("publix")) 
                publix.add(array.get(i));
        }

        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("usc")) 
                usc.add(array.get(i));
        }

        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("poshmark")) 
                poshmark.add(array.get(i));
        }

        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("depop")) 
                depop.add(array.get(i));
        }

        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("shipt")) 
                shipt.add(array.get(i));
        }

        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equalsIgnoreCase("streaming")) 
                vicars.add(array.get(i));
        }

        for(int i = 0; i < array.size(); i++) {
            if (!array.get(i).getName().equalsIgnoreCase("Vicars") &&
            !array.get(i).getName().equalsIgnoreCase("Publix") &&
            !array.get(i).getName().equalsIgnoreCase("Poshmark") &&
            !array.get(i).getName().equalsIgnoreCase("Depop") &&
            !array.get(i).getName().equalsIgnoreCase("Shipt") &&
            !array.get(i).getName().equalsIgnoreCase("Streaming") &&
            !array.get(i).getName().equalsIgnoreCase("USC")) 
                    other.add(array.get(i));
        }

        if(!vicars.isEmpty()) {
            System.out.println("Vicars:");
            for(int i = 0; i < vicars.size(); i++) 
                System.out.println(vicars.get(i).print());
            System.out.println("");
        }

        if(!publix.isEmpty()) {
            System.out.println("Publix");
            for(int i = 0; i < publix.size(); i++) 
                System.out.println(publix.get(i).print());
            System.out.println("");
        }

        if(!poshmark.isEmpty()) {
            System.out.println("Poshmark:");
            for(int i = 0; i < poshmark.size(); i++) 
                System.out.println(poshmark.get(i).print());
            System.out.println("");
        }

        if(!depop.isEmpty()) {
            System.out.println("Depop");
            for(int i = 0; i < depop.size(); i++) 
                System.out.println(depop.get(i).print());
            System.out.println("");
        }

        if(!shipt.isEmpty()) {
            System.out.println("Shipt");
            for(int i = 0; i < shipt.size(); i++) 
                System.out.println(shipt.get(i).print());
            System.out.println("");
        }

        if(!usc.isEmpty()) {
            System.out.println("USC:");
            for(int i = 0; i < usc.size(); i++) 
                System.out.println(usc.get(i).print());
            System.out.println("");
        }

        if(!streaming.isEmpty()) {
            System.out.println("Streaming:");
            for(int i = 0; i < streaming.size(); i++) 
                System.out.println(streaming.get(i).print());
            System.out.println("");
        }
        
        if (!other.isEmpty()) {
            System.out.println("Other:");
            for(int i = 0; i < other.size(); i++) 
                System.out.println(other.get(i).print());
            System.out.println("");
        }
    }

    public String getIndey(int i) { //Print full entry at index
        return array.get(i).printFull();
    }

    public entry getEarning(int i) { //Get entry at index
        return array.get(i);
    }
}
