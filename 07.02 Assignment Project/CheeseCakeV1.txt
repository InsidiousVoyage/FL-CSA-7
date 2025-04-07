public class CheeseCakeV1 {
    private int myQuantity, myServings, myCreamCheese, myVanilla;
    private double mySugar;
    private String myFlavor;

    /**
     * Constructor for objects of type CheeseCakeV1
     * @param flavor
     * @param quantity
     */
    public CheeseCakeV1(String flavor, int quantity) {
        myFlavor = flavor;
        myQuantity = quantity;
        calcTotalServings();
        calcCreamCheese();
        calcSugar();
        calcVanilla();
    }

    /**
     * Mutator method to calculate the number of servings
     */
    public void calcTotalServings() {
        myServings = myQuantity * 16;
    }

    /**
     * Mutator method to calculate the Cream Cheese Needed
     */
    public void calcCreamCheese() {
        myCreamCheese = myQuantity * 32;
    }

    /**
     * Mutator method to calculate the Vanilla Needed
     */
    public void calcVanilla() {
        myVanilla = myQuantity * 1;
    }

    /**
     * Mutator method to calculate the Sugar Needed
     */
    public void calcSugar() {
        mySugar = myQuantity * (1.0 / 3.0);
    }

    /**
     * Getter methods
     */
    public int getQuantity() {
        return myQuantity;
    }

    public String getFlavor() {
        return myFlavor;
    }

    public double getSugar() {
        return mySugar;
    }

    public int getCreamCheese() {
        return myCreamCheese;
    }

    public int getVanilla() {
        return myVanilla;
    }

    public int getServings() {
        return myServings;
    }

    public String toString() {
        return String.format("  %-4d |  %-12s | %-12d | %-8d | %-9.2f | %-9d |",
            myQuantity, myFlavor, myCreamCheese, myServings, mySugar, myVanilla);
    }
}
