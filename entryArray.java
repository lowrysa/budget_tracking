
import java.util.ArrayList;
import java.util.Collections;
public class entryArray {
    private ArrayList<entry> array;
    private ArrayList<String> categories;

    public entryArray() { //Constructor
        array = new ArrayList<entry>();
        categories = new ArrayList<String>();
    }

    public void addEntry(String name, double amount, date date) { //Adding entry
        entry a = new entry();
        a.setAmount(amount);
        a.setName(name);
        a.setDate(date);
        array.add(a);
        System.out.println("Added a Spending of " + name + " for $" + run.roundNumber(amount) + " on " + date.print());
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

    public double totalSpent() { //Get total earnings
        double ret = 0.0;
        for (int i = 0; i < array.size(); i++) {
            ret += array.get(i).getAmount();
        }
        return ret;
    }

    public double totalSpentCategory(String aCategory) {
        double ret = 0.0;
        if (aCategory.equalsIgnoreCase("Other")) {
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
                if (array.get(i).getName().equalsIgnoreCase(aCategory)) {
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

    public void printCategorySpendings() { //Sort and print categories
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

    // public double totalSpent() { //Get total spendings
    //     double ret = 0.0;
    //     for (int i = 0; i < array.size(); i++) {
    //         ret += array.get(i).getAmount();
    //     }
    //     return ret;
    // }

    // public double totalSpentFood() { //Get total spendings on food
    //     double ret = 0.0;
    //     for(int i = 0; i < array.size(); i++) {
    //         if (array.get(i).getName().equalsIgnoreCase("eat out")
    //             || array.get(i).getName().equalsIgnoreCase("groceries")
    //             || array.get(i).getName().equalsIgnoreCase("ice cream")) {
    //             ret += array.get(i).getAmount();
    //         } 
    //     }
    //     return ret;
    // }

    // public double totalSpentGas() { //Get total spendings on gas
    //     double ret = 0.0;
    //     for(int i = 0; i < array.size(); i++) {
    //         if (array.get(i).getName().equalsIgnoreCase("gas")) {
    //             ret += array.get(i).getAmount();
    //         } 
    //     }
    //     return ret;
    // }
    
    // public double totalSpentClothes() { //Get total spendings on clothes
    //     double ret = 0.0;
    //     for(int i = 0; i < array.size(); i++) {
    //         if (array.get(i).getName().equalsIgnoreCase("clothes")) {
    //             ret += array.get(i).getAmount();
    //         } 
    //     }
    //     return ret;
    // }

    // public double totalSpentGecko() { //Get total spendings on gecko
    //     double ret = 0.0;
    //     for(int i = 0; i < array.size(); i++) {
    //         if (array.get(i).getName().equalsIgnoreCase("gecko")) {
    //             ret += array.get(i).getAmount();
    //         } 
    //     }
    //     return ret;
    // }

    // public double totalSpentNintendo() { //Get total spendings on nintendo
    //     double ret = 0.0;
    //     for(int i = 0; i < array.size(); i++) {
    //         if (array.get(i).getName().equalsIgnoreCase("nintendo")) {
    //             ret += array.get(i).getAmount();
    //         } 
    //     }
    //     return ret;
    // }

    // public double totalSpentSplice() { //Get total spendings on splice
    //     double ret = 0.0;
    //     for(int i = 0; i < array.size(); i++) {
    //         if (array.get(i).getName().equalsIgnoreCase("splice")) {
    //             ret += array.get(i).getAmount();
    //         } 
    //     }
    //     return ret;
    // }

    // public double totalSpentMovies() { //Get total spendings on movies
    //     double ret = 0.0;
    //     for(int i = 0; i < array.size(); i++) {
    //         if (array.get(i).getName().equalsIgnoreCase("movies")) {
    //             ret += array.get(i).getAmount();
    //         } 
    //     }
    //     return ret;
    // }

    // public double totalSpentPlant() { //Get total spendings on plants
    //     double ret = 0.0;
    //     for(int i = 0; i < array.size(); i++) {
    //         if (array.get(i).getName().equalsIgnoreCase("plant")) {
    //             ret += array.get(i).getAmount();
    //         } 
    //     }
    //     return ret;
    // }

    // public double totalSpentCVS() { //Get total spendings on cvs
    //     double ret = 0.0;
    //     for(int i = 0; i < array.size(); i++) {
    //         if (array.get(i).getName().equalsIgnoreCase("cvs")) {
    //             ret += array.get(i).getAmount();
    //         } 
    //     }
    //     return ret;
    // }
    // public double totalSpentRent() { //Get total spendings on rent
    //     double ret = 0.0;
    //     for(int i = 0; i < array.size(); i++) {
    //         if (array.get(i).getName().equalsIgnoreCase("Rent")) {
    //             ret += array.get(i).getAmount();
    //         } 
    //     }
    //     return ret;
    // }

    // public double totalSpentUtilities() { //Get total spendings on utilities
    //     double ret = 0.0;
    //     for(int i = 0; i < array.size(); i++) {
    //         if (array.get(i).getName().equalsIgnoreCase("Utilities")) {
    //             ret += array.get(i).getAmount();
    //         } 
    //     }
    //     return ret;
    // }


    // public double totalSpentOther() { //Get total spendings on other things
    //     double ret = 0.0;
    //     for(int i = 0; i < array.size(); i++) {
    //         if (!array.get(i).getName().equalsIgnoreCase("Eat Out") &&
    //             !array.get(i).getName().equalsIgnoreCase("groceries") &&
    //             !array.get(i).getName().equalsIgnoreCase("ice cream") &&
    //             !array.get(i).getName().equalsIgnoreCase("nintendo") &&
    //             !array.get(i).getName().equalsIgnoreCase("clothes") &&
    //             !array.get(i).getName().equalsIgnoreCase("Gas") &&
    //             !array.get(i).getName().equalsIgnoreCase("Gecko") &&
    //             !array.get(i).getName().equalsIgnoreCase("Splice") &&
    //             !array.get(i).getName().equalsIgnoreCase("Movies") &&
    //             !array.get(i).getName().equalsIgnoreCase("Plant") &&
    //             !array.get(i).getName().equalsIgnoreCase("CVS") &&
    //             !array.get(i).getName().equalsIgnoreCase("Rent") &&
    //             !array.get(i).getName().equalsIgnoreCase("Utilities") &&
    //             !array.get(i).getName().equalsIgnoreCase("Nintendo")) 
    //                 ret += array.get(i).getAmount();
    //     }
    //     return ret;
    // }

    public void sortByDateLH() { //Sort and print by date, low->high
        ArrayList<entry> newArray = new ArrayList<entry>();
        for(int i = 0; i < array.size(); i++) //Copy Array over
            newArray.add(array.get(i));
        
        boolean done = false;
        while(!done) {
            int flip = 0;
            //run.p("Gotta go again");
            for(int i = 0; i < newArray.size() - 1; i++) {
                if(newArray.get(i+1) == null) {
                    break;
                }
                if (newArray.get(i).getDate().getYear() > newArray.get(i + 1).getDate().getYear()) {
                    //run.p("Swapping " + newArray.get(i).getDate().print() + " and " + newArray.get(i+1).getDate().print() + " because a");
                    Collections.swap(newArray, i, i+1);
                    flip++;
                } else if (newArray.get(i).getDate().getMonth() > newArray.get(i + 1).getDate().getMonth()) {
                    //run.p("Swapping " + newArray.get(i).getDate().print() + " and " + newArray.get(i+1).getDate().print() + " because b");
                    Collections.swap(newArray, i, i+1);
                    flip++;
                } else if (newArray.get(i).getDate().getDay() > newArray.get(i + 1).getDate().getDay() && 
                    newArray.get(i).getDate().getMonth() == newArray.get(i + 1).getDate().getMonth() && 
                    newArray.get(i).getDate().getYear() == newArray.get(i + 1).getDate().getYear()) {
                        //run.p("Swapping " + newArray.get(i).getDate().print() + " and " + newArray.get(i+1).getDate().print() + " because c");
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
        run.p("Oldest to Newest:");
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
                } else if (newArray.get(i).getDate().getDay() < newArray.get(i + 1).getDate().getDay() &&
                    newArray.get(i).getDate().getMonth() == newArray.get(i + 1).getDate().getMonth() && 
                    newArray.get(i).getDate().getYear() == newArray.get(i + 1).getDate().getYear()) {
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
        if (newArray.size() > 4)
            run.p("\n\n");
        System.out.println("Spendings Newest to Oldest:");
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
        System.out.println("Spendings Low to High:");
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
        System.out.println("Spendings High to Low:");
        for(int i = 0; i < newArray.size(); i++) //Print newArray
            System.out.println(newArray.get(i).print());
        
    }

    // public void printCategory() { //Sort and print categories
    //     ArrayList<entry> eatOut = new ArrayList<entry>();
    //     ArrayList<entry> groceries = new ArrayList<entry>();
    //     ArrayList<entry> iceCream = new ArrayList<entry>();
    //     ArrayList<entry> gas = new ArrayList<entry>();
    //     ArrayList<entry> clothes = new ArrayList<entry>();
    //     ArrayList<entry> gecko = new ArrayList<entry>();
    //     ArrayList<entry> nintendo = new ArrayList<entry>();
    //     ArrayList<entry> splice = new ArrayList<entry>();
    //     ArrayList<entry> movies = new ArrayList<entry>();
    //     ArrayList<entry> plant = new ArrayList<entry>();
    //     ArrayList<entry> cvs = new ArrayList<entry>();
    //     ArrayList<entry> rent = new ArrayList<entry>();
    //     ArrayList<entry> utilities = new ArrayList<entry>();
    //     ArrayList<entry> other = new ArrayList<entry>();

    //     for(int i = 0; i < array.size(); i++) {
    //         if (array.get(i).getName().equalsIgnoreCase("eat out")) 
    //             eatOut.add(array.get(i));
    //     }

    //     for(int i = 0; i < array.size(); i++) {
    //         if (array.get(i).getName().equalsIgnoreCase("groceries")) 
    //             groceries.add(array.get(i));
    //     }

    //     for(int i = 0; i < array.size(); i++) {
    //         if (array.get(i).getName().equalsIgnoreCase("ice cream")) 
    //             iceCream.add(array.get(i));
    //     }

    //     for(int i = 0; i < array.size(); i++) {
    //         if (array.get(i).getName().equalsIgnoreCase("gas")) 
    //             gas.add(array.get(i));
    //     }

    //     for(int i = 0; i < array.size(); i++) {
    //         if (array.get(i).getName().equalsIgnoreCase("clothes")) 
    //             clothes.add(array.get(i));
    //     }

    //     for(int i = 0; i < array.size(); i++) {
    //         if (array.get(i).getName().equalsIgnoreCase("gecko")) 
    //             gecko.add(array.get(i));
    //     }

    //     for(int i = 0; i < array.size(); i++) {
    //         if (array.get(i).getName().equalsIgnoreCase("nintendo")) 
    //             nintendo.add(array.get(i));
    //     }

    //     for(int i = 0; i < array.size(); i++) {
    //         if (array.get(i).getName().equalsIgnoreCase("splice")) 
    //             splice.add(array.get(i));
    //     }

    //     for(int i = 0; i < array.size(); i++) {
    //         if (array.get(i).getName().equalsIgnoreCase("movies")) 
    //             movies.add(array.get(i));
    //     }

    //     for(int i = 0; i < array.size(); i++) {
    //         if (array.get(i).getName().equalsIgnoreCase("plant")) 
    //             plant.add(array.get(i));
    //     }

    //     for(int i = 0; i < array.size(); i++) {
    //         if (array.get(i).getName().equalsIgnoreCase("cvs")) 
    //             cvs.add(array.get(i));
    //     }

    //     for(int i = 0; i < array.size(); i++) {
    //         if (array.get(i).getName().equalsIgnoreCase("rent")) 
    //             rent.add(array.get(i));
    //     }

    //     for(int i = 0; i < array.size(); i++) {
    //         if (array.get(i).getName().equalsIgnoreCase("utilities")) 
    //             utilities.add(array.get(i));
    //     }

    //     for(int i = 0; i < array.size(); i++) {
    //         if (!array.get(i).getName().equalsIgnoreCase("Eat Out") &&
    //             !array.get(i).getName().equalsIgnoreCase("groceries") &&
    //             !array.get(i).getName().equalsIgnoreCase("ice cream") &&
    //             !array.get(i).getName().equalsIgnoreCase("nintendo") &&
    //             !array.get(i).getName().equalsIgnoreCase("clothes") &&
    //             !array.get(i).getName().equalsIgnoreCase("Gas") &&
    //             !array.get(i).getName().equalsIgnoreCase("Gecko") &&
    //             !array.get(i).getName().equalsIgnoreCase("Splice") &&
    //             !array.get(i).getName().equalsIgnoreCase("Movies") &&
    //             !array.get(i).getName().equalsIgnoreCase("Plant") &&
    //             !array.get(i).getName().equalsIgnoreCase("CVS") &&
    //             !array.get(i).getName().equalsIgnoreCase("utlities") &&
    //             !array.get(i).getName().equalsIgnoreCase("Rent") &&
    //             !array.get(i).getName().equalsIgnoreCase("Nintendo")) 
    //                 other.add(array.get(i));
    //     }

    //     run.p("\n\n");
    //     if(!eatOut.isEmpty()) {
    //         System.out.println("Eat Out:");
    //         for(int i = 0; i < eatOut.size(); i++) 
    //             System.out.println(eatOut.get(i).print());
    //         System.out.println("");
    //     }
        
    //     if (!groceries.isEmpty()) {
    //         System.out.println("Groceries:");
    //         for(int i = 0; i < groceries.size(); i++) 
    //             System.out.println(groceries.get(i).print());
    //         System.out.println("");
    //     }
        
    //     if (!iceCream.isEmpty()) {
    //         System.out.println("Ice Cream:");
    //         for(int i = 0; i < iceCream.size(); i++) 
    //            System.out.println(iceCream.get(i).print());
    //         System.out.println("");
    //     }
        
    //     if (!gas.isEmpty()) {
    //         System.out.println("Gas:");
    //         for(int i = 0; i < gas.size(); i++) 
    //             System.out.println(gas.get(i).print());
    //         System.out.println("");
    //     }
        
    //     if (!clothes.isEmpty()) {
    //         System.out.println("Clothes:");
    //         for(int i = 0; i < clothes.size(); i++) 
    //             System.out.println(clothes.get(i).print());
    //         System.out.println("");
    //     }
        
    //     if (!gecko.isEmpty()) {
    //         System.out.println("Gecko:");
    //         for(int i = 0; i < gecko.size(); i++) 
    //             System.out.println(gecko.get(i).print());
    //         System.out.println("");
    //     }
        
    //     if (!nintendo.isEmpty()) {
    //         System.out.println("Nintendo:");
    //         for(int i = 0; i < nintendo.size(); i++) 
    //             System.out.println(nintendo.get(i).print());
    //         System.out.println("");
    //     }

    //     if (!splice.isEmpty()) {
    //         System.out.println("Splice:");
    //         for(int i = 0; i < splice.size(); i++) 
    //             System.out.println(splice.get(i).print());
    //         System.out.println("");
    //     }

    //     if (!movies.isEmpty()) {
    //         System.out.println("Movies:");
    //         for(int i = 0; i < movies.size(); i++) 
    //             System.out.println(movies.get(i).print());
    //         System.out.println("");
    //     }

    //     if (!plant.isEmpty()) {
    //         System.out.println("Plants:");
    //         for(int i = 0; i < plant.size(); i++) 
    //             System.out.println(plant.get(i).print());
    //         System.out.println("");
    //     }

    //     if (!cvs.isEmpty()) {
    //         System.out.println("CVS:");
    //         for(int i = 0; i < cvs.size(); i++) 
    //             System.out.println(cvs.get(i).print());
    //         System.out.println("");
    //     }

    //     if (!rent.isEmpty()) {
    //         System.out.println("Rent:");
    //         for(int i = 0; i < cvs.size(); i++) 
    //             System.out.println(rent.get(i).print());
    //         System.out.println("");
    //     }

    //     if (!utilities.isEmpty()) {
    //         System.out.println("Utilities:");
    //         for(int i = 0; i < cvs.size(); i++) 
    //             System.out.println(utilities.get(i).print());
    //         System.out.println("");
    //     }
        
    //     if (!other.isEmpty()) {
    //         System.out.println("Other:");
    //         for(int i = 0; i < other.size(); i++) 
    //             System.out.println(other.get(i).print());
    //         System.out.println("");
    //     }
    // }

    public String getIndex(int i) { //Print full entry at index
        return array.get(i).print();
    }

    public entry getEntry(int i) { //Get entry at index
        return array.get(i);
    }
}   
