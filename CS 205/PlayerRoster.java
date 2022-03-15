import java.util.Scanner;


public class PlayerRoster {
    /**
     * @Author Robert Daniels
     * 
     *  Java lab, user can input exactly 5 jerseys and corresponding ratings, has menu to update/output those
     * ratings. No error checking or handling user input cases. 
     */
    public static void main(String[] args){
        
        Scanner scnr = new Scanner(System.in);
        int[][] userInput = new int[6][3];

        // prompt for 5 pairs of numbers, store jersey number and rating in 2d array
        userInput = getUserInput(scnr, userInput);
        outputRoster(userInput);
        // TODO start here at #2, to print main menu. needs to loop, so will need a boolean or sentinel 

    }

    public static int[][] getUserInput(Scanner scnr, int[][] userInput){
        /**
         * Per lab, no error checking, no handling user input beyond basic 5 int pairs
         * first take jersey in 2d array, then take rating
         * 
         * @param Scanner object System.in
         * @param int[][] userInput, initialized empty 2d array
         */


        for (int i = 1; i <= 5; ++i){
            
            System.out.printf("Enter player %d's jersey number\n", i);
            userInput[i][1] = scnr.nextInt();
            System.out.printf("Enter player %d's rating\n", i);
            userInput[i][2] = scnr.nextInt();
        }
        return userInput;
    }

    public static void outputRoster(int[][] userInput){
        /**
         * Takes userInput 2d array and outputs roster per assignment
         * 
         * @param int[][] userInput from getUserInput
         */

        System.out.println("");
        System.out.println("ROSTER");
        for (int i = 1; i <= 5; ++i){
            System.out.printf("Player %d -- Jersey number: %d, Rating: %d\n", i, userInput[i][1], userInput[i][2]);
        }

    }


}
