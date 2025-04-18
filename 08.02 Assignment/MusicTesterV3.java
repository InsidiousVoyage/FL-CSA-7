


/**
 * Tests the Music Class with sorting and searching.
 *
 * @author Johann Mansfield
 * @version 3/2/2025
 */
public class MusicTesterV3
 {
    public static void main(String[] args)
    {
        Music[] music = new Music[10];

        music[0] = new Music("Beat It", 1982, "Michael Jackson");
        music[1] = new Music("Sweet Child O' Mine", 1987, "Guns N' Roses");
        music[2] = new Music("Dream On", 1973, "Aerosmith");
        music[3] = new Music("September", 1978, "Earth, Wind & Fire");
        music[4] = new Music("Bohemian Rhapsody", 1975, "Queen");
        music[5] = new Music("Hotel California", 1976, "Eagles");
        music[6] = new Music("Stairway to Heaven", 1971, "Led Zeppelin");
        music[7] = new Music("Imagine", 1971, "John Lennon");
        music[8] = new Music("Purple Rain", 1984, "Prince");
        music[9] = new Music("Billie Jean", 1983, "Michael Jackson");

        System.out.println("Complete Music Library:");
        printMusic(music);

        // Sorting by title
        System.out.println("\nSorting by Title:");
        insertionSortByTitle(music);
        printMusic(music);

        // Sorting by year
        System.out.println("\nSorting by Year:");
        selectionSortByYear(music);
        printMusic(music);

        // Sorting by artist
        System.out.println("\nSorting by Artist:");
        mergeSortByArtist(music, 0, music.length - 1);
        printMusic(music);

        // Testing search methods
        System.out.println("\nSearching for 'Bohemian Rhapsody':");
        binarySearchByTitle(music, "Bohemian Rhapsody");

        System.out.println("\nSearching for songs from 1971:");
        binarySearchByYear(music, 1971);

        System.out.println("\nSearching for songs by 'Michael Jackson':");
        binarySearchByArtist(music, "Michael Jackson");
    }

    public static void printMusic(Music[] songs) 
    {
        System.out.printf("%-25s %-6s %-20s \n", "Title", "Year", "Artist");
        System.out.println("--------------------------------------------------------");
        for (Music song : songs) 
        {
            System.out.println(song);
        }
    }

    // Sorting methods
    public static void insertionSortByTitle(Music[] songs) 
    {
        for (int i = 1; i < songs.length; i++) 
        {
            Music key = songs[i];
            int j = i - 1;
            while (j >= 0 && songs[j].getTitle().compareTo(key.getTitle()) > 0) 
            {
                songs[j + 1] = songs[j];
                j--;
            }
            songs[j + 1] = key;
        }
    }

    public static void selectionSortByYear(Music[] songs) 
    {
        for (int i = 0; i < songs.length - 1; i++) 
        {
            int minIndex = i;
            for (int j = i + 1; j < songs.length; j++)
            {
                if (songs[j].getYear() < songs[minIndex].getYear()) 
                {
                    minIndex = j;
                }
            }
            Music temp = songs[i];
            songs[i] = songs[minIndex];
            songs[minIndex] = temp;
        }
    }

    public static void mergeSortByArtist(Music[] songs, int left, int right) 
    {
        if (left < right)
        {
            int mid = (left + right) / 2;
            mergeSortByArtist(songs, left, mid);
            mergeSortByArtist(songs, mid + 1, right);
            merge(songs, left, mid, right);
        }
    }

    private static void merge(Music[] songs, int left, int mid, int right) 
    {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Music[] leftArray = new Music[n1];
        Music[] rightArray = new Music[n2];

        for (int i = 0; i < n1; i++) leftArray[i] = songs[left + i];
        for (int i = 0; i < n2; i++) rightArray[i] = songs[mid + 1 + i];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) 
        {
            if (leftArray[i].getArtist().compareTo(rightArray[j].getArtist()) <= 0) {
                songs[k] = leftArray[i];
                i++;
            } else {
                songs[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) songs[k++] = leftArray[i++];
        while (j < n2) songs[k++] = rightArray[j++];
    }

    // Binary Search Methods
    public static int binarySearchByTitle(Music[] songs, String title)
    {
        int high = songs.length;
        int low = -1;
        int probe;
        
        while(high - low >1)
        {
            probe = (high + low)/2;
            if( songs[probe].getArtist().compareTo(title) > 0)
                high = probe;
            else
                low = probe;
        }
        
        if ((low >= 0) && (songs[low].getArtist().compareTo(title) == 0))
            return low;
        else 
            return -1;
    }

    public static void binarySearchByYear(Music[] songs, int year) 
    {
        int high = songs.length;
        int low = -1;
        int probe;
        
        while(high - low > 1)
        {
            probe = (high + low)/2;
            
            if (songs[probe].getYear().compareTo(year) > 0)
                high = probe;
            else
            {
                low = probe;
                if(songs[probe].getYear().compareTo(year) == 0)
                break;
            }
        }
        
        if (low >= 0) && (songs[low].getYear().compareTo(toFind) == 0))
        {
            linearPrintLoc(songs, low, year);
        }
        else
            System.out.println("Not found: " + toFind);
    }
    public static void binarySearchByArtist(Music[] songs, String artist) 
    {
        for (Music song : songs) {
            if (song.getArtist().equals(artist)) {
                System.out.println(song);
            }
        }
    }
}
