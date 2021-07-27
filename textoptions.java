public class textoptions {
    public textoptions() {}

    public void greetings() {
        p("*******************************************************************************************");
        p("*                                                                                         *");
        System.out.print("*                         ");
        System.out.print("Welcome to the budget tracking program!");
        System.out.print("                         *");
        p("*                                                                                         *");
        p("*******************************************************************************************");
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
        p("What would you like to do?");
        p("1. Print entries");
        p("2. Check stats");
        p("3. Add entry");
        p("4. Check dates");
        p("8. Show random entry");
        p("9. Quit program");
    }

    public void firstChoice() {
        p("How would you like to print?");
        p("1. Print by date");
        p("2. Print by amount");
        p("3. Print by category");
        p("4. Print in order of added");
        p("9. Back");
    }

    public void dateChoice() {
        clear();
        p("How would you like to sort?");
        p("1. Sort by oldest to newest");
        p("2. Sort by newest to oldest");
        p("9. Back");
    }

    public void amountChoice() {
        clear();
        p("How would you like to sort?");
        p("1. Sort by low to high");
        p("2. Sort by high to low");
        p("9. Back");
    }

    public void alphabeticChoice() {
        clear();
        p("How would you like to sort?");
        p("1. Sort from A->Z");
        p("2. Sort from Z->A");
        p("9. Back");
    }

    public void whatTypeOfEntry() {
        clear();
        p("What Type of Entry is it?");
        p("1. Food");
        p("2. Gas");
        p("3. Clothes");
        p("4. Gecko");
        p("5. Nintendo");
        p("6. Splice");
        p("8. Other");
        p("9. Back");
    }

    public void monthChoice() {
        clear();
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
