
import java.util.ArrayList;
import java.util.Collections;
public class earningArray {
    private ArrayList<entry> array;
    private ArrayList<String> categories;

    public earningArray() { //Constructor
        array = new ArrayList<entry>();
        categories = new ArrayList<String>();
    }

    public void addEntry(String name, double amount, date date) { //Adding entry
        entry a = new entry();
        a.setAmount(amount);
        a.setName(name);
        a.setDate(date);
        array.add(a);
        System.out.println("Added an Earning of " + name + " for $" + run.roundNumber(amount) + " on " + date.print());
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
        if (array.size() > 4)
            run.p("\n\n");
        for(int i = 0; i < array.size(); i++) 
            System.out.println(array.get(i).print());
        run.p("");
    }

    public int getSize() { //Get size of array
        return array.size();
    }

    public ArrayList<String> getCategories() {
        return categories;
    }
    
    public void addCategory(String aCategory) {
        if (!aCategory.equalsIgnoreCase("")) 
            categories.add(aCategory);
    }

    public void printCategories() {
        for(int i = 0; i < categories.size(); i++) 
            run.p(categories.get(i));
    }

    public double totalEarned() { //Get total earnings
        double ret = 0.0;
        for (int i = 0; i < array.size(); i++) {
            ret += array.get(i).getAmount();
        }
        return ret;
    }

    public double totalEarnedCategory(String aCategorie) {
        double ret = 0.0;
        if (aCategorie.equalsIgnoreCase("Other")) {
            for(int i = 0; i < array.size(); i++) {
                boolean triggered = true;
                for (int j = 0; j < categories.size(); j++) {
                    if (array.get(i).getName().equalsIgnoreCase(categories.get(j))) {
                        triggered = true;
                        break;
                    }
                }
                if (!triggered) 
                    ret += array.get(i).getAmount();
            }
        } else {
            for(int i = 0; i < array.size(); i++) {
                if (array.get(i).getName().equalsIgnoreCase(aCategorie)) {
                    ret += array.get(i).getAmount();
                }
            }
        }
        return ret;
    }


    // public double totalEarnedVicars() { //Get total spendings on gas
    //     double ret = 0.0;
    //     for(int i = 0; i < array.size(); i++) {
    //         if (array.get(i).getName().equalsIgnoreCase("Vicars")) {
    //             ret += array.get(i).getAmount();
    //         } 
    //     }
    //     return ret;
    // }

    // public double totalEarnedPublix() { //Get total spendings on gas
    //     double ret = 0.0;
    //     for(int i = 0; i < array.size(); i++) {
    //         if (array.get(i).getName().equalsIgnoreCase("Publix")) {
    //             ret += array.get(i).getAmount();
    //         } 
    //     }
    //     return ret;
    // }

    // public double totalEarnedPoshmark() { //Get total spendings on gas
    //     double ret = 0.0;
    //     for(int i = 0; i < array.size(); i++) {
    //         if (array.get(i).getName().equalsIgnoreCase("Poshmark")) {
    //             ret += array.get(i).getAmount();
    //         } 
    //     }
    //     return ret;
    // }

    // public double totalEarnedDepop() { //Get total spendings on gas
    //     double ret = 0.0;
    //     for(int i = 0; i < array.size(); i++) {
    //         if (array.get(i).getName().equalsIgnoreCase("Depop")) {
    //             ret += array.get(i).getAmount();
    //         } 
    //     }
    //     return ret;
    // }

    // public double totalEarnedShipt() { //Get total spendings on gas
    //     double ret = 0.0;
    //     for(int i = 0; i < array.size(); i++) {
    //         if (array.get(i).getName().equalsIgnoreCase("Shipt")) {
    //             ret += array.get(i).getAmount();
    //         } 
    //     }
    //     return ret;
    // }

    // public double totalEarnedUSC() { //Get total spendings on gas
    //     double ret = 0.0;
    //     for(int i = 0; i < array.size(); i++) {
    //         if (array.get(i).getName().equalsIgnoreCase("USC")) {
    //             ret += array.get(i).getAmount();
    //         } 
    //     }
    //     return ret;
    // }

    // public double totalEarnedStreaming() { //Get total spendings on gas
    //     double ret = 0.0;
    //     for(int i = 0; i < array.size(); i++) {
    //         if (array.get(i).getName().equalsIgnoreCase("Streaming")) {
    //             ret += array.get(i).getAmount();
    //         } 
    //     }
    //     return ret;
    // }

    // public double totalEarnedOther() { //Get total spendings on other things
    //     double ret = 0.0;
    //     for(int i = 0; i < array.size(); i++) {
    //         if (!array.get(i).getName().equalsIgnoreCase("Vicars") &&
    //             !array.get(i).getName().equalsIgnoreCase("Publix") &&
    //             !array.get(i).getName().equalsIgnoreCase("Poshmark") &&
    //             !array.get(i).getName().equalsIgnoreCase("Depop") &&
    //             !array.get(i).getName().equalsIgnoreCase("Shipt") &&
    //             !array.get(i).getName().equalsIgnoreCase("Streaming") &&
    //             !array.get(i).getName().equalsIgnoreCase("USC")) 
    //                 ret += array.get(i).getAmount();
    //     }
    //     return ret;
    // }

    public void printCategoryEarnings() { //Sort and print categories
        // for(int i = 0; i < earningCategories.size(); i++) {
        //     ArrayList<entry> i = new ArrayList<entry>()
        // }
        if (categories.size() != 0) {
            //All main categories
            for(int i = 0; i < categories.size(); i++) {
                ArrayList<entry> newArray = new ArrayList<entry>();
                for(int j = 0; j < array.size(); j++) {
                    if (array.get(j).getName().equalsIgnoreCase(categories.get(i))) 
                        newArray.add(array.get(j));
                }
                if (newArray.size() > 0) {
                    run.p("\n" + categories.get(i) + ": ");
                    for(int j = 0; j < newArray.size(); j++) 
                        run.p(newArray.get(j).printFullEarning());
                }
            }
            //Everything that doesn't fit into categories
            ArrayList<entry> otherArray = new ArrayList<entry>();
            for(int i = 0; i < array.size(); i++) {
                boolean triggered = false;
                for(int j = 0; j < categories.size(); j++) {
                    if (array.get(i).getName().equalsIgnoreCase(categories.get(j))) {
                        triggered = true;
                        break;
                    }
                }
                if(!triggered)
                    otherArray.add(array.get(i));
            }
            if (otherArray.size() > 0) {
                run.p("\nOther:");
                for(int j = 0; j < otherArray.size(); j++) 
                        run.p(otherArray.get(j).printFullEarning());
            }
        } else
            run.p("No entries yet!");
        
        // ArrayList<entry> vicars = new ArrayList<entry>();
        // ArrayList<entry> publix = new ArrayList<entry>();
        // ArrayList<entry> usc = new ArrayList<entry>();
        // ArrayList<entry> poshmark = new ArrayList<entry>();
        // ArrayList<entry> depop = new ArrayList<entry>();
        // ArrayList<entry> streaming = new ArrayList<entry>();
        // ArrayList<entry> shipt = new ArrayList<entry>();
        // ArrayList<entry> other = new ArrayList<entry>();
        

        // for(int i = 0; i < array.size(); i++) {
        //     if (array.get(i).getName().equalsIgnoreCase("vicars")) 
        //         vicars.add(array.get(i));
        // }

        // for(int i = 0; i < array.size(); i++) {
        //     if (array.get(i).getName().equalsIgnoreCase("publix")) 
        //         publix.add(array.get(i));
        // }

        // for(int i = 0; i < array.size(); i++) {
        //     if (array.get(i).getName().equalsIgnoreCase("usc")) 
        //         usc.add(array.get(i));
        // }

        // for(int i = 0; i < array.size(); i++) {
        //     if (array.get(i).getName().equalsIgnoreCase("poshmark")) 
        //         poshmark.add(array.get(i));
        // }

        // for(int i = 0; i < array.size(); i++) {
        //     if (array.get(i).getName().equalsIgnoreCase("depop")) 
        //         depop.add(array.get(i));
        // }

        // for(int i = 0; i < array.size(); i++) {
        //     if (array.get(i).getName().equalsIgnoreCase("shipt")) 
        //         shipt.add(array.get(i));
        // }

        // for(int i = 0; i < array.size(); i++) {
        //     if (array.get(i).getName().equalsIgnoreCase("streaming")) 
        //         vicars.add(array.get(i));
        // }

        // for(int i = 0; i < array.size(); i++) {
        //     if (!array.get(i).getName().equalsIgnoreCase("Vicars") &&
        //     !array.get(i).getName().equalsIgnoreCase("Publix") &&
        //     !array.get(i).getName().equalsIgnoreCase("Poshmark") &&
        //     !array.get(i).getName().equalsIgnoreCase("Depop") &&
        //     !array.get(i).getName().equalsIgnoreCase("Shipt") &&
        //     !array.get(i).getName().equalsIgnoreCase("Streaming") &&
        //     !array.get(i).getName().equalsIgnoreCase("USC")) 
        //             other.add(array.get(i));
        // }

        // run.p("\n\n");
        // if(!vicars.isEmpty()) {
        //     System.out.println("Vicars:");
        //     for(int i = 0; i < vicars.size(); i++) 
        //         System.out.println(vicars.get(i).print());
        //     System.out.println("");
        // }

        // if(!publix.isEmpty()) {
        //     System.out.println("Publix");
        //     for(int i = 0; i < publix.size(); i++) 
        //         System.out.println(publix.get(i).print());
        //     System.out.println("");
        // }

        // if(!poshmark.isEmpty()) {
        //     System.out.println("Poshmark:");
        //     for(int i = 0; i < poshmark.size(); i++) 
        //         System.out.println(poshmark.get(i).print());
        //     System.out.println("");
        // }

        // if(!depop.isEmpty()) {
        //     System.out.println("Depop");
        //     for(int i = 0; i < depop.size(); i++) 
        //         System.out.println(depop.get(i).print());
        //     System.out.println("");
        // }

        // if(!shipt.isEmpty()) {
        //     System.out.println("Shipt");
        //     for(int i = 0; i < shipt.size(); i++) 
        //         System.out.println(shipt.get(i).print());
        //     System.out.println("");
        // }

        // if(!usc.isEmpty()) {
        //     System.out.println("USC:");
        //     for(int i = 0; i < usc.size(); i++) 
        //         System.out.println(usc.get(i).print());
        //     System.out.println("");
        // }

        // if(!streaming.isEmpty()) {
        //     System.out.println("Streaming:");
        //     for(int i = 0; i < streaming.size(); i++) 
        //         System.out.println(streaming.get(i).print());
        //     System.out.println("");
        // }
        
        // if (!other.isEmpty()) {
        //     System.out.println("Other:");
        //     for(int i = 0; i < other.size(); i++) 
        //         System.out.println(other.get(i).print());
        //     System.out.println("");
        // }
    }

    public String getIndey(int i) { //Print full entry at index
        return array.get(i).print();
    }

    public entry getEarning(int i) { //Get entry at index
        return array.get(i);
    }

    public void sortByDateLH() { //Sort and print by date, low->high
        ArrayList<entry> newArray = new ArrayList<entry>();
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

        run.clear();
        if (newArray.size() > 4)
            run.p("\n\n");
        System.out.println("Earnings Oldest to Newest:");
        for(int i = 0; i < newArray.size(); i++) //Print newArray
            System.out.println(newArray.get(i).print());
        
    }

    public void sortByDateHL() { //Sort and print by date, high->low
        ArrayList<entry> newArray = new ArrayList<entry>();
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

        run.clear();
        if (newArray.size() > 4)
            run.p("\n\n");
        System.out.println("Earnings Newest to Oldest:");
        for(int i = 0; i < newArray.size(); i++) //Print newArray
            System.out.println(newArray.get(i).print());
        
    }

    public void sortAmountLH() { //Sort and print by amount, low->high
        ArrayList<entry> newArray = new ArrayList<entry>();
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

        run.clear();
        if (newArray.size() > 4)
            run.p("\n\n");
        System.out.println("Earnings Low to High:");
        for(int i = 0; i < newArray.size(); i++) //Print newArray
            System.out.println(newArray.get(i).print());
        
    }

    public void sortAmountHL() { //Sort and print, high->low
        ArrayList<entry> newArray = new ArrayList<entry>();
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

        run.clear();
        if (newArray.size() > 4)
            run.p("\n\n");
        System.out.println("Earnings High to Low:");
        for(int i = 0; i < newArray.size(); i++) //Print newArray
            System.out.println(newArray.get(i).print());
        
    }
}
