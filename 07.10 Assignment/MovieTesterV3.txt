
/**
 * Tests the movie class and sorts the information.
 *
* @author Johann Mansfield
 * @version 2/23/2025
 */
public class MovieTesterV3
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
        selectionSortTitle(movies, 1);
        printMovies(movies);

        System.out.println("\nSorting by Year (Descending):");
        selectionSortYear(movies, 2);
        printMovies(movies);

        System.out.println("\nSorting by Studio (Ascending):");
        selectionSortStudio(movies, 1);
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

    public static void selectionSortTitle(Movie[] movies, int order)
    {
        int n = movies.length;
        for (int i = 0; i < n - 1; i++) 
        {
            int index = i;
            for (int j = i + 1; j < n; j++) 
            {
                if ((order == 1 && movies[j].getTitle().compareTo(movies[index].getTitle()) < 0) || 
                    (order == 2 && movies[j].getTitle().compareTo(movies[index].getTitle()) > 0)) 
                {
                    index = j;
                }
            }
            Movie temp = movies[i];
            movies[i] = movies[index];
            movies[index] = temp;
        }
    }

    public static void selectionSortYear(Movie[] movies, int order)
    {
        int n = movies.length;
        for (int i = 0; i < n - 1; i++) 
        {
            int index = i;
            for (int j = i + 1; j < n; j++) 
            {
                if ((order == 1 && movies[j].getYear() < movies[index].getYear()) || 
                    (order == 2 && movies[j].getYear() > movies[index].getYear())) 
                {
                    index = j;
                }
            }
            Movie temp = movies[i];
            movies[i] = movies[index];
            movies[index] = temp;
        }
    }

    public static void selectionSortStudio(Movie[] movies, int order)
    {
        int n = movies.length;
        for (int i = 0; i < n - 1; i++) 
        {
            int index = i;
            for (int j = i + 1; j < n; j++) 
            {
                if ((order == 1 && movies[j].getStudio().compareTo(movies[index].getStudio()) < 0) || 
                    (order == 2 && movies[j].getStudio().compareTo(movies[index].getStudio()) > 0)) 
                {
                    index = j;
                }
            }
            Movie temp = movies[i];
            movies[i] = movies[index];
            movies[index] = temp;
        }
    }
}


