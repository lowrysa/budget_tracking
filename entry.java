public class entry {
    private String name;
    private double amount;
    private date date;

    public entry() {} //Default constructor

    public entry (String a, double b, date c) { //Edited constructor
        name = a;
        amount = b;
        date = c;
    }

    public String getName() { //Get name 
        return name; 
    }

    public void setName (String a) { //Set name
        if (a.equalsIgnoreCase("")) 
            name = "Na";
        else 
            name = a;
    }

    public double getAmount() { //Get amount
        return amount;
    }

    public void setAmount (double b) { //Set amount
        if (b > 0.0)
            amount = b;
        else
            amount = 0.0;
    }

    public date getDate() { //Get date
        return date;
    }

    public void setDate(date c) { //Set date
        if (c.check(c.getMonth(), c.getDay(), c.getYear())) 
            date = c;
        else 
            date = new date(0, 0, 0);
    }

    public void setDate(int a, int b, int c) { //Set date
        date d = new date(a, b, c);
        if (d.check(d.getMonth(), d.getDay(), d.getYear())) 
            date = d;
        else   
            date = new date(0, 0, 0);
    }

    public void remove(entry a) { //Remove entry
        a.setName("null");
        a.setAmount(-1);
        a.setDate(null);
    }

    public String print() { //Print entry
        return name + " $" + amount + " " + date.print();
    }

    public String printFull() { //Print full entry
        return "Paid $" + amount + " for " + name + " on " + date.printFull();
    }
}
