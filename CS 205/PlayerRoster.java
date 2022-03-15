import java.util.Scanner;


public class PlayerRoster {
    /**
     * @Author Robert Daniels
     * 
     *  Java lab, user can input exactly 5 jerseys and corresponding ratings, has menu to update/output those
     * ratings. No error checking or handling user input cases. All static methods. 
     */
    public static void main(String[] args){
        
        Scanner scnr = new Scanner(System.in);
        int[][] userInput = new int[6][3];
        boolean userExit = false;

        // prompt for 5 pairs of numbers, store jersey number and rating in 2d array
        userInput = getUserInput(scnr, userInput);
        outputRoster(userInput);

        // output the menu 

        while (userExit != true){
            userExit = menuOption(scnr, userInput);
        }
        


    }

    public static int[][] getUserInput(Scanner scnr, int[][] userInput){
        /**
         * Per lab, no error checking, no handling user input beyond basic 5 int pairs
         * first take jersey in 2d array, then take rating. 2d array is UNIT indexed, not zero indexed. 
         * 
         * @param Scanner object System.in
         * @param int[][] userInput, initialized empty 2d array
         */


        for (int i = 1; i <= 5; ++i){
            
            System.out.printf("Enter player %d's jersey number:\n", i);
            userInput[i][1] = scnr.nextInt();
            System.out.printf("Enter player %d's rating:\n", i);
            userInput[i][2] = scnr.nextInt();
            System.out.println("");
        }
        return userInput;
    }

    public static void outputRoster(int[][] userInput){
        /**
         * Takes userInput 2d array and outputs roster per assignment
         * 
         * @param int[][] userInput from getUserInput jersey number and ratings
         */

        System.out.println("ROSTER");
        for (int i = 1; i <= 5; ++i){
            System.out.printf("Player %d -- Jersey number: %d, Rating: %d\n", i, userInput[i][1], userInput[i][2]);
        }

    }

    public static void updatedRating(Scanner scnr, int[][] userInput){
        /**
         * Allows user to update the rating for a given jersey number. Assumes jersey numbers are unique
         * 
         * @param Scanner object System.in
         * @param 2d int array userInput, original data passed to main jersey/rating
         */

         int jerseyInput;
         int newRating;
         int playerIndex = 0; // yes, this is very bad

         System.out.println("Enter a jersey number:");

         jerseyInput = scnr.nextInt();

         for (int i = 1; i <= 5; ++i){
             if ( userInput[i][1] == jerseyInput){
                 playerIndex = i;
                 break;
             }
         }

         System.out.println("Enter a new rating for player:");

         newRating = scnr.nextInt();

         userInput[playerIndex][2] = newRating;

    }

    public static void outputPlayersAboveRating(Scanner scnr, int[][] userInput){
        /**
         * Asks user for a rating, loops through 2d array with basic for statement and outputs all values
         * above the rating.
         * 
         * @param Scanner System.in
         * @param 2d int array userInput passed down from main, jersey/rating
         */

         int userRatingChoice;

         System.out.println("Enter a rating:");

         userRatingChoice = scnr.nextInt();
        
         System.out.println("ABOVE " + userRatingChoice);
         
         for (int i = 1; i <= 5; ++i){

            if (userInput[i][2] > userRatingChoice){
                System.out.printf("Player %d -- Jersey number: %d, Rating: %d\n", i, userInput[i][1], userInput[i][2]);
            }
         }
    }

    public static void replacePlayer(Scanner scnr, int[][] userInput){
        /**
         * allows user to enter a jersey number. if jersey number exists, the player at that index has jersey number
         * and rating replaced by user. 
         * 
         * @param Scanner System.in
         * @param 2d int array userInput passed from main()
         */

         int oldJersey;
         int newJersey;
         int playerIndex = 0; // still bad, but not as bad. 
         int newRating;

         System.out.println("Enter a jersey number:");

         oldJersey = scnr.nextInt();

         for (int i = 1; i <= 5; ++i){
            if (userInput[i][1] == oldJersey){
                playerIndex = i;
                break;
            }
         }

         if (playerIndex != 0){ // if the jersey number exists in the data do this
            System.out.println("Enter a new jersey number:");
            newJersey = scnr.nextInt();
            System.out.println("Enter a rating for the new player:");
            newRating = scnr.nextInt();

            userInput[playerIndex][1] = newJersey;
            userInput[playerIndex][2] = newRating;
         }

    }

    public static boolean menuOption(Scanner scnr, int[][] userInput){
        /**
         * Handles the menu functionality, based on user input, then runs the related method. 
         * 
         * @param Scanner System.in passed from main()
         * 
         * @return menuExit boolean, to kill menu loop if user hits q case
         * 
         */
        boolean menuExit = false;
        char userMenuChoice;
        
        System.out.println("");
        System.out.println("MENU");
        System.out.println("u - Update player rating");
        System.out.println("a - Output players above a rating");
        System.out.println("r - Replace player");
        System.out.println("o - Output roster");
        System.out.println("q - Quit");
        System.out.println("\nChoose an option:");

        userMenuChoice = scnr.next().charAt(0);

        switch (userMenuChoice){
            case 'u': updatedRating(scnr, userInput);
                      break;
            case 'a': outputPlayersAboveRating(scnr, userInput);
                      break;
            case 'r': replacePlayer(scnr, userInput);
                      break;
            case 'o': outputRoster(userInput);
                      break;
            case 'q': menuExit = true;
                      break;
            default:  System.out.println("incorrect choice. please try again");  
        }

        return menuExit;

    }


}
