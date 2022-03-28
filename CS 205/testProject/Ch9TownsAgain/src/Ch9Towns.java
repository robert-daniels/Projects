package testProject.Ch9TownsAgain.src;

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

    public static void readTownsFile(String filePath) throws IOException{

            File inFile = new File(filePath);
            Scanner scnr = new Scanner(inFile);
            int townPop = 0;
            int townPopSum = 0;

            while (scnr.hasNextLine()){
                System.out.print(scnr.next());
                System.out.print(" ");
                townPop = scnr.nextInt();
                System.out.print(townPop);
                System.out.print(" ");
                townPopSum += townPop;
            }

            System.out.println(townPopSum);
    }
}
