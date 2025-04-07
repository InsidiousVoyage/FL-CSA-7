/**
 * Starter code for the Hurricane Tester
 * APCS Team 2020
 * 
 *  Johann Mansfield
 *  2/14/2025
 */ 
 
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
public class HurricaneTester

{

    public static void main(String[] args) throws IOException
    {
        //read data from text file & put in an array
        File fileName = new File("hurricanedata.txt");
        Scanner inFile = new Scanner(fileName);
        int numValues = 0;
        final double knotsToMPH = 1.15078;
    
        
        //count number of lines in text file
        while (inFile.hasNextLine() )
        {
            inFile.nextLine();
            numValues++;
        }
        inFile.close();
        
        
        //initialize arrays based on lines counted in text file
        int [] years = new int[numValues];
        String [] months = new String[numValues];
        int [] pressures = new int[numValues];
        double [] windSpeeds = new double[numValues];
        String [] names = new String[numValues];
        int[] cat = new int[numValues];
        
        //read and assign data from text file to the arrays
        inFile = new Scanner(fileName);
        int index = 0;
        while(inFile.hasNext() )
        {
            years[index] = inFile.nextInt();
            months[index] = inFile.next();
            pressures[index] = inFile.nextInt();
            windSpeeds[index] = inFile.nextDouble();
            names[index] = inFile.next();
            index++;
        }
        inFile.close();
        
        
        //create an array to store the categories for each hurricane        
        
        
        //convert the values in the windspeed array to MPH, use the converted windspeeds to fill the categories array
        for (int i = 0; i< numValues; i++)
        {
            windSpeeds[i] *= knotsToMPH;
            
                if (windSpeeds[i] >= 157) cat[i] = 5;
            else if (windSpeeds[i] >=130) cat[i] = 4;
            else if (windSpeeds[i] >= 111) cat[i] = 3;
            else if (windSpeeds[i] >= 96) cat[i] = 2;
            else if (windSpeeds[i] >= 74) cat[i] = 1;
            else cat[i] = 0;
        }
        
        //user prompted for range of years
        Scanner input = new Scanner(System.in);
        System.out.print("Enter start year: ");
        int startYear = input.nextInt();
        System.out.print("Enter end year: ");
        int endYear = input.nextInt();
        input.close();
         
        //create a Hurricane ArrayList of hurricane objects that are in the user's requested range
        ArrayList<Hurricane> hurricanes = new ArrayList<>();

        for (int i = 0; i < numValues; i++){
            if (years[i] >= startYear && years[i] <= endYear) {
                hurricanes.add(new Hurricane(years[i], names[i], months[i], cat[i], pressures[i], windSpeeds[i]));
            }
        }
        //print the hurricanes in the user's requested range
        System.out.printf("%-5s %-10s %-5s %-10s %-10s\n", "Year", "Hurricane", "Cat", "Pressure(mb)", "Wind Speed(MPH)");
        System.out.println("====================================================================");
        
        for (Hurricane h : hurricanes) {
            System.out.println(h);
        }
        
        //calculate and display the summary data using the ArrayList
        displayStats(hurricanes);
     }
     
    public static void displayStats(ArrayList<Hurricane> hurricanes) 
    {
        if (hurricanes.isEmpty()) 
        {
            System.out.println("\nNo hurricanes found in the given range.");
            return;
        }

        double totalWindSpeed = 0;
        double totalPressure = 0;
        double totalCategory = 0;
        int minCat = Integer.MAX_VALUE;
        int maxCat = Integer.MIN_VALUE;
        int minYear = Integer.MAX_VALUE;
        int maxYear = Integer.MIN_VALUE;
        int minPressure = Integer.MAX_VALUE;
        int maxPressure = Integer.MIN_VALUE;
        double minWindSpeed = Double.MAX_VALUE;
        double maxWindSpeed = Double.MIN_VALUE;
        int[] categoryCount = new int[6];  

        for (Hurricane h : hurricanes)
        {
            totalWindSpeed += h.getWindspeed();
            totalPressure += h.getPressure();
            totalCategory += h.getCat();

            minCat = Math.min(minCat, h.getCat());
            maxCat = Math.max(maxCat, h.getCat());
            
            minYear = Math.min(minYear, h.getYear());
            maxYear = Math.max(maxYear, h.getYear());
            
            minPressure = Math.min(minPressure, h.getPressure());
            maxPressure = Math.max(maxPressure, h.getPressure());
            
            minWindSpeed = Math.min(minWindSpeed, h.getWindspeed());
            maxWindSpeed = Math.max(maxWindSpeed, h.getWindspeed());
    
            categoryCount[h.getCat()]++;
        }

        double avgCategory = totalCategory / hurricanes.size();
        double avgPressure = totalPressure / hurricanes.size();
        double avgWindSpeed = totalWindSpeed / hurricanes.size();

        System.out.println("==================================================================");
        System.out.printf("Average: \t%-6.1f %-10.1f %-14.2f\n", avgCategory, avgPressure, avgWindSpeed);
        System.out.printf("Minimum: \t%-6d %-10d %-14.2f\n", minCat, minPressure, minWindSpeed);
        System.out.printf("Maximum: \t%-6d %-10d %-14.2f\n", maxCat, maxPressure, maxWindSpeed);

        System.out.println("\nSummary of Categories:");
        for (int i = 1; i <= 5; i++) 
        {
            System.out.printf("    Cat %d: %d\n", i, categoryCount[i]);
        }
    }


}