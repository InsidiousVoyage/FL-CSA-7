
/**
 * Write a description of class ElectionTesterV2 here.
 *
 * @author Johann Mansfield
 * @version 2/17/2025
 */
import java.util.ArrayList;

public class ElectionTesterV2 
{
    public static void main(String[] args) 
    {
        // Step 1: Create an ArrayList of Candidate objects
        ArrayList<Candidate> candidates = new ArrayList<>();
        candidates.add(new Candidate("Tony Stark", 3691));
        candidates.add(new Candidate("Henry Pym", 2691));
        candidates.add(new Candidate("B____ B____", 1962));
        candidates.add(new Candidate("S____ R____", 1491));
        candidates.add(new Candidate("C____ D____", 1968));

        // Step 2: Print raw election data
        System.out.println("Raw Election Data:");
        for (Candidate c : candidates) 
        {
            System.out.println(c);
        }

        // Step 3: Calculate total votes
        int totalVotes = getTotalVotes(candidates);

        // Step 4: Print formatted election results
        printResults(candidates, totalVotes);
    }

    // Method to calculate total votes
    public static int getTotalVotes(ArrayList<Candidate> candidates) 
    {
        int sum = 0;
        for (Candidate c : candidates) 
        {
            sum += c.getVotes();
        }
        return sum;
    }

    // Method to print the results in a table format
    public static void printResults(ArrayList<Candidate> candidates, int totalVotes) 
    {
        System.out.println("\nElection Results:\n");
        System.out.printf("%-20s %-10s %-10s\n", "Candidate", "Votes", "% of Total");
        System.out.println("=======================================");

        for (Candidate c : candidates) 
        {
            double percentage = (c.getVotes() * 100.0) / totalVotes;
            System.out.printf("%-20s %-10d %-10.2f\n", c.getName(), c.getVotes(), percentage);
        }

        System.out.println("\nThe total number of votes is: " + totalVotes);
    }
}

