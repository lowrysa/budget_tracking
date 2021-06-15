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
        if (a != "") {
            name = a;
        } else {
            name = "Na";
        }
    }
}
