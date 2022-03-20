package Ch9KansasTowns;

import java.io.*;
import java.util.*;

public class KansasTowns {
    
    public static void main(String[] args){
        /**
         * Ch9 lab: practice with file io and exceptions. 
         * Reads a relative file reference as a string (hardcoded)
         * and outputs the string component and the sum of the values
         * Underlying file is <String>cityName <int>population
         * All static methods 
         * 
         * @author Robert Daniels
         */

        //TODO the file paths are not ideal. It needs to look inside subfolders, not the main project folder. 
        
        String fileName = "KansasTownsPop1.txt";
        try{
            readTownsFile(fileName);
        }
        catch(IOException eIO){
            System.out.printf("readTownsFile() couldn't access %s \n", fileName);
        }

    }

    public static void readTownsFile(String fileName) throws IOException{
        /**
         * Checks if provided file exists, if so, loop through the file
         * and output the cities and total population sum of cities. 
         * 
         * File is standardized <String>City <int>Population
         * 
         * @param fileName as String. relative file path from main
         * 
         */
        
        File fileIn = new File(fileName);

        if ( fileIn.exists() ){
            Scanner inputFileScnr = new Scanner(fileIn);
            String inputLine;
            HashMap<String, Integer> cityPop = new HashMap<String, Integer>();
            int totalPopulation = 0; // TODO possible logic error

            while (inputFileScnr.hasNextLine()){
                inputLine = inputFileScnr.nextLine();
                String[] splitArray = inputLine.split(" ");

                cityPop.put(splitArray[0], Integer.parseInt(splitArray[1]));
            }

            for (int i : cityPop.values()){
                totalPopulation += i;
            }
            
            System.out.print("The total population of ");
            for (String i : cityPop.keySet()){
                System.out.print(i + " ");
            }
            System.out.println("is " + totalPopulation);

        } else{
            throw new IOException("File does not exists in an accessible format.");
        }

    }
}
