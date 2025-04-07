
/**
 * Runs/Tests the candidate class
 *
 * @author Johann Mansfield
 * @version 2/17/2025
 */
public class ElectionTesterV3 {
    public static void main(String[] args) 
    {
        Candidate[] candidates = 
        {
            new Candidate("Tony Stark", 751),
            new Candidate("Henry Pym", 496),
            new Candidate("Bruce Banner", 303),
            new Candidate("S R", 225),
            new Candidate("C D", 81)
        };

        System.out.println("Initial Results:");
        printResults(candidates);

        System.out.println("\n Renaming Bruce Banner to Stan Lee");
        rename(candidates, "Bruce Banner", "Stan Lee");
        printResults(candidates);

        System.out.println("\n Updating Henry Pym's votes to 284");
        updateVotes(candidates, "Henry Pym", 284);
        printResults(candidates);

        System.out.println("\n Replacing C D with Peter Parker (votes: 500)");
        replaceCandidate(candidates, "C D", "Peter Parker", 500);
        printResults(candidates);
    }

    public static void rename(Candidate[] candidates, String oldName, String newName) 
    {
        for (Candidate c : candidates) 
        {
            if (c.getName().equals(oldName)) 
            {
                c.setName(newName);
                return;
            }
        }
    }

    public static void updateVotes(Candidate[] candidates, String name, int votes) 
    {
        for (Candidate c : candidates) 
        {
            if (c.getName().equals(name)) 
            {
                c.setVotes(votes);
                return;
            }
        }
    }

    public static void replaceCandidate(Candidate[] candidates, String oldName, String newName, int votes) 
    {
        for (Candidate c : candidates) 
        {
            if (c.getName().equals(oldName)) 
            {
                c.setName(newName);
                c.setVotes(votes);
                return;
            }
        }
    }

    public static int getTotalVotes(Candidate[] candidates) 
    {
        int total = 0;
        for (Candidate c : candidates) 
        {
            total += c.getVotes();
        }
        return total;
    }

    public static void printResults(Candidate[] candidates) 
    {
        int totalVotes = getTotalVotes(candidates);
        System.out.printf("\n%-15s %-10s %-10s\n", "Candidate", "Votes", "% of Total");
        System.out.println("=====================================");

        for (Candidate c : candidates) 
        {
            double percent = (c.getVotes() * 100.0) / totalVotes;
            System.out.printf("%-15s %-10d %-10.2f\n", c.getName(), c.getVotes(), percent);
        }

        System.out.println("\nTotal Votes: " + totalVotes);
    }
}



