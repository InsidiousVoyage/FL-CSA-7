
/**
 * Tests the movie class and sorts the information.
 *
* @author Johann Mansfield
 * @version 2/23/2025
 */
public class MovieTesterV2
 {
    public static void main(String[] args)
    {
        Movie[] movies = {
            new Movie("Inception", 2010, "Warner Bros."),
            new Movie("The Lion King", 1994, "Disney"),
            new Movie("Interstellar", 2014, "Paramount"),
            new Movie("The Dark Knight", 2008, "Warner Bros."),
            new Movie("Finding Nemo", 2003, "Pixar"),
            new Movie("Avatar", 2009, "20th Century Fox"),
            new Movie("Titanic", 1997, "Paramount"),
            new Movie("Toy Story", 1995, "Pixar"),
            new Movie("Frozen", 2013, "Disney"),
            new Movie("Shrek", 2001, "DreamWorks")
        };

        System.out.println("Original Movie List:");
        printMovies(movies);

        System.out.println("\nSorting by Title (Ascending):");
        sortByTitle(movies);
        printMovies(movies);

        System.out.println("\nSorting by Year (Descending):");
        sortByYear(movies);
        printMovies(movies);

        System.out.println("\nSorting by Studio (Ascending):");
        sortByStudio(movies);
        printMovies(movies);
    }

    public static void printMovies(Movie[] movies)
    {
        System.out.printf("\n%-30s %-4s   %-20s\n", "Title", "Year", "Studio");
        System.out.println("=============================================================");
        for (Movie movie : movies) 
        {
            System.out.println(movie);
        }
    }

    public static void sortByTitle(Movie[] movies) 
    {
        for (int i = 1; i < movies.length; i++)
        {
            Movie next = movies[i];
            int j = i;
            while (j > 0 && next.getTitle().compareTo(movies[j - 1].getTitle()) < 0)
            {
                movies[j] = movies[j - 1];
                j--;
            }       
            movies[j] = next;
        }
      }

    public static void sortByYear(Movie[] movies) 
    {
        for (int i = 1; i < movies.length; i++) 
        {
            Movie next = movies[i];
            int j = i;            
            while (j > 0 && next.getYear() > movies[j - 1].getYear()) 
            {
                movies[j] = movies[j - 1];
                j--;
            }       
            movies[j] = next;
        }
    }


    public static void sortByStudio(Movie[] movies) 
    {
        for (int i = 1; i < movies.length; i++) {
            Movie next = movies[i];
            int j = i;
            while (j > 0 && next.getStudio().compareTo(movies[j - 1].getStudio()) < 0) {
                movies[j] = movies[j - 1];
                j--;
            }
            movies[j] = next;
        }
    }

}

