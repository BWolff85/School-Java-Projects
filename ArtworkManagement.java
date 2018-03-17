package artwork;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.InputMismatchException;
/**
 *
 * @author Brittany Wolff
 */
public class ArtworkManagement {
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String filename = "src/artwork/artwork_info.txt";
        int userOption = 0;
        do {
            try {
                Artwork[] museum = getArtFromFile(filename);
            
                System.out.println("Choose an option:\n\n1. Artwork information\n2. Update location\n3. Exit");
                userOption = input.nextInt();
                switch (userOption) {
                    case 1:
                        System.out.println("Please enter an artwork id: ");
                        input.nextLine();
                        String displayId = input.nextLine();
                        artworkInformation(museum, displayId);
                        userOption = 0;
                        break;
                    case 2:
                        System.out.println("Please enter an artwork id: ");
                        input.nextLine();
                        String updateId = input.nextLine();
                        updateLocation(museum, updateId);
                        break;
                    case 3:
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("You have not selected a valid option. Please try again!");
                }
            } catch (FileNotFoundException e) {
                System.out.println("Cant seem to find that file");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("You cannot access that index of the array");
            } catch (InputMismatchException e) {
                String bad_input = input.next();
                System.out.println("You must select 1, 2, or 3");
            }
        } while (userOption != 3);

        
    }
    
    private static void updateLocation(Artwork[] museum, String id) {
        Scanner input = new Scanner(System.in);
        Artwork artPiece = null;
        for (Artwork art : museum) {
            if (art.getID().equals(id)) {
                artPiece = art;
                System.out.println("Please enter a new location");
                String location = input.nextLine();
                artPiece.setLocation(location);
            }
        }
        if (artPiece == null) {
            System.out.println("You have not entered a valid id");
        } else {
            System.out.println(artPiece.toString());
        }
    }
    
    private static void artworkInformation(Artwork[] museum, String id) {
        Artwork artPiece = null;
        for (Artwork art : museum) {
            if (art.getID().equals(id)) {
                artPiece = art;
            }
        }
        if (artPiece == null) {
            System.out.println("You have not entered a valid id");
        } else {
            System.out.println(artPiece.toString());
        }
    }
    
    private static Artwork[] getArtFromFile(String filename) throws FileNotFoundException, ArrayIndexOutOfBoundsException{
        Scanner scanner = new Scanner(new File(filename));
        int num_records = scanner.nextInt();
        System.out.println(num_records);
        Artwork[] museum = new Artwork[num_records];
        int counter = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] artInfo = line.split(", ");
            if (artInfo.length < 4)
                continue;
            int year = Integer.parseInt(artInfo[2]);
            museum[counter] = new Artwork(artInfo[0], artInfo[1], year, artInfo[3]);
            counter++;
        }
        
        return museum;
    }
}
