
public class textoptions {
    public textoptions() {}

    public void greetings() {
        //System.out.println("Welcome to the budget tracking program!");
        //p("*******************************************************************************************");
        //p("*                                                                                         *");
        //System.out.print("*                         ");
        run.p("\n\n");
        System.out.println("░██╗░░░░░░░██╗███████╗██╗░░░░░░█████╗░░█████╗░███╗░░░███╗███████╗  ████████╗░█████╗░  ████████╗██╗░░██╗███████╗");
        System.out.println("░██║░░██╗░░██║██╔════╝██║░░░░░██╔══██╗██╔══██╗████╗░████║██╔════╝  ╚══██╔══╝██╔══██╗  ╚══██╔══╝██║░░██║██╔════╝");
        System.out.println("░╚██╗████╗██╔╝█████╗░░██║░░░░░██║░░╚═╝██║░░██║██╔████╔██║█████╗░░  ░░░██║░░░██║░░██║  ░░░██║░░░███████║█████╗░░");
        System.out.println("░░████╔═████║░██╔══╝░░██║░░░░░██║░░██╗██║░░██║██║╚██╔╝██║██╔══╝░░  ░░░██║░░░██║░░██║  ░░░██║░░░██╔══██║██╔══╝░░");
        System.out.println("░░╚██╔╝░╚██╔╝░███████╗███████╗╚█████╔╝╚█████╔╝██║░╚═╝░██║███████╗  ░░░██║░░░╚█████╔╝  ░░░██║░░░██║░░██║███████╗");
        System.out.println("░░░╚═╝░░░╚═╝░░╚══════╝╚══════╝░╚════╝░░╚════╝░╚═╝░░░░░╚═╝╚══════╝  ░░░╚═╝░░░░╚════╝░  ░░░╚═╝░░░╚═╝░░╚═╝╚══════╝");
        System.out.println("██████╗░██╗░░░██╗██████╗░░██████╗░███████╗████████╗  ████████╗██████╗░░█████╗░░█████╗░██╗░░██╗██╗███╗░░██╗░██████╗░");
        System.out.println("██╔══██╗██║░░░██║██╔══██╗██╔════╝░██╔════╝╚══██╔══╝  ╚══██╔══╝██╔══██╗██╔══██╗██╔══██╗██║░██╔╝██║████╗░██║██╔════╝░");
        System.out.println("██████╦╝██║░░░██║██║░░██║██║░░██╗░█████╗░░░░░██║░░░  ░░░██║░░░██████╔╝███████║██║░░╚═╝█████═╝░██║██╔██╗██║██║░░██╗░");
        System.out.println("██╔══██╗██║░░░██║██║░░██║██║░░╚██╗██╔══╝░░░░░██║░░░  ░░░██║░░░██╔══██╗██╔══██║██║░░██╗██╔═██╗░██║██║╚████║██║░░╚██╗");
        System.out.println("██████╦╝╚██████╔╝██████╔╝╚██████╔╝███████╗░░░██║░░░  ░░░██║░░░██║░░██║██║░░██║╚█████╔╝██║░╚██╗██║██║░╚███║╚██████╔╝");
        System.out.println("╚═════╝░░╚═════╝░╚═════╝░░╚═════╝░╚══════╝░░░╚═╝░░░  ░░░╚═╝░░░╚═╝░░╚═╝╚═╝░░╚═╝░╚════╝░╚═╝░░╚═╝╚═╝╚═╝░░╚══╝░╚═════╝░");
        System.out.println("██████╗░██████╗░░█████╗░░██████╗░██████╗░░█████╗░███╗░░░███╗");
        System.out.println("██╔══██╗██╔══██╗██╔══██╗██╔════╝░██╔══██╗██╔══██╗████╗░████║");
        System.out.println("██████╔╝██████╔╝██║░░██║██║░░██╗░██████╔╝███████║██╔████╔██║");
        System.out.println("██╔═══╝░██╔══██╗██║░░██║██║░░╚██╗██╔══██╗██╔══██║██║╚██╔╝██║");
        System.out.println("██║░░░░░██║░░██║╚█████╔╝╚██████╔╝██║░░██║██║░░██║██║░╚═╝░██║");
        System.out.println("╚═╝░░░░░╚═╝░░╚═╝░╚════╝░░╚═════╝░╚═╝░░╚═╝╚═╝░░╚═╝╚═╝░░░░░╚═╝");
        //System.out.print("                         *");
        //p("*                                                                                         *");
        //p("*******************************************************************************************");
        p("");
    }

    public void foodChoice() {
        clear();
        run.pb("What kind of food purchase?");
        p("1. Eat Out");
        p("2. Groceries");
        p("3. Ice Cream");
    }

    public void printLoop() {
        run.pb("What would you like to do? (Page 1/2)");
        p("1. Print entries");
        p("2. Check stats");
        p("3. Add a spending");
        p("4. Add an earning");
        p("5. Remove spending");
        p("6. Remove earning");
        p("7. Show random entry");
        p("8. Next page");
        p("9. Quit program");
    }

    public void printLoop2() {
        run.pb("What would you like to do? (Page 2/2)");
        p("1. Check/Change dates");
        p("2. Print file");
        p("3. Reset file");
        p("4. Change file");
        p("8. Previous page");
        p("9. Quit program");
    }
    

    public void firstChoice() {
        run.pb("\nHow would you like to print?");
        p("1. Print by date");
        p("2. Print by amount");
        p("3. Print by category");
        p("4. Print Spendings");
        p("5. Print Earnings");
        p("9. Back");
    }

    public void dateChoice() {
        clear();
        run.pb("How would you like to sort?");
        p("1. Spendings -> Sort by oldest to newest");
        p("2. Spendings -> Sort by newest to oldest");
        p("3. Earnings -> Sort by oldest to newest");
        p("4. Earnings -> Sort by newest to oldest");
        p("9. Back");
    }

    public void amountChoice() {
        clear();
        run.pb("How would you like to sort?");
        p("1. Spendings -> Sort by low to high");
        p("2. Spendings -> Sort by high to low");
        p("3. Earnings -> Sort by low to high");
        p("4. Earnings -> Sort by high to low");
        p("9. Back");
    }

    public void whatTypeOfEntry() {
        run.pb("\nWhat Type of Spending is it?");
        p("1. Food");
        p("2. Gas");
        p("3. Clothes");
        p("4. Gecko");
        p("5. Nintendo");
        p("6. Splice");
        p("7. Movies");
        p("8. Plants");
        p("9. CVS");
        p("10. Rent");
        p("11. Utilities");
        p("12. Other");
        p("13. Back");
    }

    public void whatTypeOfEarning() {
        run.pb("\nWhat Type of Earning is it?");
        p("1. Vicars");
        p("2. Publix");
        p("3. Poshmark");
        p("4. Depop");
        p("5. Shipt");
        p("6. USC");
        p("7. Streaming");
        p("8. Other");
        p("9. Back");
    }

    public void monthChoice() {
        run.pi("Select the correct month:");
        p("1. January");
        p("2. February");
        p("3. March");
        p("4. April");
        p("5. May");
        p("6. June");
        p("7. July");
        p("8. August");
        p("9. September");
        p("10. October");
        p("11. November");
        p("12. December");
    }

    public String numberToMonth(int aInt) {
        String ret = "";

        if (aInt == 1) 
            ret = "January";
        else if (aInt == 2) 
            ret = "February";
        else if (aInt == 3) 
            ret = "March";
        else if (aInt == 4) 
            ret = "April";
        else if (aInt == 5) 
            ret = "May";
        else if (aInt == 6) 
            ret = "June";
        else if (aInt == 7) 
            ret = "July";
        else if (aInt == 8) 
            ret = "August";
        else if (aInt == 9) 
            ret = "September";
        else if (aInt == 10) 
            ret = "October";
        else if (aInt == 11) 
            ret = "November";
        else if (aInt == 12) 
            ret = "December";
        else 
            ret = "";

        if (ret.equals("")) {
            ret = "Something went wrong here...";
        }
        return ret;
    }

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void p(String s) {
        System.out.println(s);
    }
}
