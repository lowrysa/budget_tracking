public class entry {
    private String name;
    private double amount;
    private date date;

    public entry() {}

    public entry (String a, double b, date c) {
        name = a;
        amount = b;
        date = c;
    }

    public String getName() {
        return name;
    }

    public void setName (String a) {
        if (a.equalsIgnoreCase("")) 
            name = a;
        else 
            name = "Na";
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount (double b) {
        if (b > 0.0)
            amount = b;
        else
            amount = 0.0;
    }

    public date getDate() {
        return date;
    }

    public void setDate(date c) {
        if (c.check(c.getMonth(), c.getDay(), c.getYear())) 
            date = c;
        else 
            date = new date(0, 0, 0);
    }

    public void setDate(int a, int b, int c) {
        date d = new date(a, b, c);
        if (d.check(d.getMonth(), d.getDay(), d.getYear())) 
            date = d;
        else   
            date = new date(0, 0, 0);
    }

    public void remove(entry a) {
        a.setName("null");
        a.setAmount(-1);
        a.setDate(null);
    }

    public String print() {
        return name + " " + amount + " " + date.print() +"\n";
    }

    public String printFull() {
        return "Paid " + amount + " for " + name + " on " + date.printFull() + "\n";
    }
}
