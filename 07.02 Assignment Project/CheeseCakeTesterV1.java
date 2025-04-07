/**
 * Tests the CheeseCakeV1 Class
 *
 * @author Johann Mansfield
 * @version 2/10/2025
 */


import java.util.ArrayList;
public class CheeseCakeTesterV1 {
    public static void main(String[] args) {
        // Initializing and declaring an ArrayList and adding in objects as elements
        ArrayList<CheeseCakeV1> cakeList = new ArrayList<>();

        // Adding sample cheesecakes
        cakeList.add(new CheeseCakeV1("Blueberry", 5));
        cakeList.add(new CheeseCakeV1("Strawberry", 6));
        cakeList.add(new CheeseCakeV1("Cherry", 4));
        cakeList.add(new CheeseCakeV1("Jalapeno", 1));
        cakeList.add(new CheeseCakeV1("Dill Pickle", 2));
        cakeList.add(new CheeseCakeV1("Fig", 3));

        // Printing the table format
        System.out.println("|       Cheese Cake Data          |             Ingredient Calculations             |");
        System.out.println("| Index  |Quantity|  Flavor       | Cream Cheese | Servings |   Sugar   |  Vanilla  |");
        System.out.println("|--------|--------|---------------|--------------|----------|-----------|-----------|");

        // Using a for loop to print out the objects' data
        for (int index = 0; index < cakeList.size(); index++) {
            System.out.printf("|  %-5d | %s%n", index, cakeList.get(index).toString());
        }
    }
}
