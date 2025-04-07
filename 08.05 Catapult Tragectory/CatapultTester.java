/**
 * Purpose: Main class to test the Catapult simulation and print distance table.
 * 
 * Author Johann Mansfield
 * Version 03/25/2025
 * Purpose: Main class to test the Catapult simulation and print distance table.
 */

public class CatapultTester 
{
    public static void main(String[] args) 
    {
        int[] speedArray = {20, 25, 30, 35, 40, 45, 50}; // in MPH
        int[] angleArray = {25, 30, 35, 40, 45, 50};     // in degrees
        double[][] twoDimArray = new double[speedArray.length][angleArray.length];

        Catapult catapult = new Catapult();

        // Fill 2D array with distance calculations
        for (int i = 0; i < speedArray.length; i++) 
        {
            for (int j = 0; j < angleArray.length; j++) 
            {
                // Convert speed from MPH to m/s: 1 MPH = 0.44704 m/s
                int speedMS = (int)(speedArray[i] * 0.44704);
                twoDimArray[i][j] = catapult.calcDistance(speedMS, angleArray[j]) * 3.28084; // convert m to ft
            }
        }

        printResults(twoDimArray, speedArray, angleArray);
    }

    // Prints the 2D array in formatted output
    public static void printResults(double[][] array, int[] speedArray, int[] angleArray)
    {
        System.out.printf("%6s", "MPH");
        for (int angle : angleArray) 
        {
            System.out.printf("%12s", angle + " deg");
        }
        System.out.println();
        System.out.println("==============================================================");

        for (int i = 0; i < array.length; i++)
        {
            System.out.printf("%6d", speedArray[i]);
            for (int j = 0; j < array[i].length; j++) 
            {
                System.out.printf("%12.2f", array[i][j]);
            }
            System.out.println();
        }
    }
}