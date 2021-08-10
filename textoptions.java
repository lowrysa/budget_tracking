public class textoptions {
    public textoptions() {}

    public void greetings() {
        //p("*******************************************************************************************");
        //p("*                                                                                         *");
        //System.out.print("*                         ");
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
        p("What kind of food purchase?");
        p("1. Eat Out");
        p("2. Groceries");
        p("3. Ice Cream");
    }

    public void printLoop() {
        p("What would you like to do? (Page 1/2)");
        p("1. Print entries");
        p("2. Check stats");
        p("3. Add spending");
        p("4. Add earning");
        p("5. Remove spending");
        p("6. Remove earning");
        p("7. Show random entry");
        p("8. Next page");
        p("9. Quit program");
    }

    public void printLoop2() {
        p("What would you like to do? (Page 2/2)");
        p("1. Print file");
        p("2. Reset file");
        p("3. Check/Change dates");
        p("8. Previous page");
        p("9. Quit program");
    }
    

    public void firstChoice() {
        p("How would you like to print?");
        p("1. Print by date");
        p("2. Print by amount");
        p("3. Print by category");
        p("4. Print Spendings");
        p("5. Print Earnings");
        p("9. Back");
    }

    public void dateChoice() {
        clear();
        p("How would you like to sort?");
        p("1. Spendings -> Sort by oldest to newest");
        p("2. Spendings -> Sort by newest to oldest");
        p("3. Earnings -> Sort by oldest to newest");
        p("4. Earnings -> Sort by newest to oldest");
        p("9. Back");
    }

    public void amountChoice() {
        clear();
        p("How would you like to sort?");
        p("1. Spendings -> Sort by low to high");
        p("2. Spendings -> Sort by high to low");
        p("3. Earnings -> Sort by low to high");
        p("4. Earnings -> Sort by high to low");
        p("9. Back");
    }

    public void whatTypeOfEntry() {
        p("\nWhat Type of Entry is it?");
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
        p("\nWhat Type of Earning is it?");
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
        p("Select the correct month:");
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

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void p(String s) {
        System.out.println(s);
    }
}
