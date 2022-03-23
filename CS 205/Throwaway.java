
import java.util.*;
import java.io.*;

public class Throwaway{

    public static void main(String[] args){

        String myString = "123 5941";
        Scanner scnr = new Scanner(myString);
        

        System.out.println(scnr.next());

        File testFile = new File("KansasTownsPop1.txt");

        try{

        
        
        Scanner scnrFile = new Scanner(testFile);
        StringWriter stringStream = new StringWriter();
        PrintWriter printStream = new PrintWriter(stringStream);
        String fullName = "";

        while (scnrFile.hasNext()){
            printStream.print(scnrFile.nextLine());
            fullName = stringStream.toString();
            System.out.println(fullName);
        }

        } catch (FileNotFoundException e){
            System.out.println("couldn't find file");
        }

    }
}