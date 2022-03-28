package UnmanagedWork;

import java.io.*;
import java.util.*;

public class Ch9Towns {
    public static void main(String[] args) throws Exception {
        
        try{
            readTownsFile("KansasTownsPop1.txt");
        } catch (IOException eIO){
            System.out.println("File Not Found");
        }
        
    }

    /**
     * Very basic implementation of reading in items, non-hashmap. Prints out list of towns
     * and at the end of the list the sum of all of their populations
     * 
     * @param filePath as a file to check <String: Town Name> <int: townPopulation> /n
     * @throws IOException
     */

    public static void readTownsFile(String filePath) throws IOException{

            File inFile = new File(filePath);
            Scanner scnr = new Scanner(inFile);
            int townPop = 0;
            int townPopSum = 0;

            while (scnr.hasNextLine()){
                System.out.print(scnr.next());
                System.out.print(" ");
                townPop = scnr.nextInt();
                System.out.print(" ");
                townPopSum += townPop;
            }

            System.out.println(townPopSum);
            scnr.close();
    }
}
