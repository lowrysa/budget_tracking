public class date {
    private int month;
    private int day;
    private int year;

    public date() {}

    public date (int a, int b, int c) {
        if(check(a, b, c)) {
            this.setMonth(a);
            this.setDay(b);
            this.setYear(c);
        } else 
            System.out.println("Not a valid date");
    }

    public int getMonth() {
        return month;
    }

    public String getMonthFull() {
        String ret = "";
        if (month == 1) 
            ret = "January";
        else if (month == 2) 
            ret = "February";
        else if (month == 3) 
            ret = "March";
        else if (month == 4) 
            ret = "April";
        else if (month == 5) 
            ret = "May";
        else if (month == 6) 
            ret = "June";
        else if (month == 7) 
            ret = "July";
        else if (month == 8) 
            ret = "August";
        else if (month == 9) 
            ret = "September";
        else if (month == 10) 
            ret = "October";
        else if (month == 11) 
            ret = "November";
        else if (month == 12) 
            ret = "December";
        else if (month == 0) 
            ret = "Not a month";
        return ret;
    }

    public void setMonth(int a) {
        if (a > 0 && a < 13) 
            month = a;
        else 
            month = 0;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int b) {
        if (b > 0 && b < 32) 
            day = b;
        else 
            day = 0;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int c) {
        if (c > 1950 && c < 2022) 
            year = c;
        else 
            year = 0;
    }

    public String print () {
        return month + "/" + day + "/" + year;
    }

    public String printFull() {
        return getMonthFull() + " " + day + ", " + year;
    }

    public boolean check(int a, int b, int c) {
        boolean ret = true;
        if (a == 0 || b == 0 || c == 0) {
            //System.out.println("Not a valid date");
            ret = false;
        } else if (a == 2 && (b == 30 || b == 31)) {
            System.out.println("February doesn't have that many days.");
            ret = false;
        } else if (a == 2 && b == 29 && (c % 4 != 0 || c % 400 == 0)) {
            System.out.println("Not a leap year, not valid.");
            ret = false;
        } else if ((a == 4 && b == 31) || (a == 6 && b == 31) ||
            (a == 9 && b == 31) || (a == 11 && b == 31)) {
                System.out.println("That month does not have that many days.");
                ret = false;
        }
        return ret;
    }
}
