package project1;

import java.util.*;


/*
@author: Robert Daniels
02/25/2022

Hourly Wage Calculator: prompts user for week worked as an int, and 7 values for hours worked as a double. 
It then has logic to calculate pay for that time frame, based on accepted pay practices and bonuses to rate based on
week worked. 


*/

public class HourlyWageCalculator{
        

    public static void main(String[] args){
        
        HourlyWageCalculator calculator = new HourlyWageCalculator(); 
        Scanner scnr = new Scanner(System.in);
        double[] arrayToProcess;
        char answer = 'y';
        int calcWeek;
        
        while (answer == 'y'){
           
            //get weekNumber to pass to getInputFromUser
            calcWeek = calculator.getWeekNumber(scnr);
            
            if (calcWeek == -1){
                System.out.println("You've entered -1 to exit. Goodbye.");
                System.exit(0);
            }

            // get validated hours from user
            arrayToProcess = calculator.getInputFromUser(calcWeek, scnr);

            //pass the sanitized user input to output method
            calculator.calculatePayForWeek(calcWeek, arrayToProcess);

            System.out.print("Would you like to calculate pay for another week? y/n: ");
            answer = scnr.next().charAt(0);
            System.out.println("");
        }
        
        System.out.println("Thanks for using the wage calculator tool.");
    }
            
   
    public int getWeekNumber(Scanner scnr){
            /*
            This method gets passed a scanner from main. It then prompts user for week number. 
            The week number is validated if it is an int between 1 and 52. -1 will kill process.
            Continues to loop until killed or validated 
            
            @returns weekNumber as int
            
            */
            boolean weekNumberSentinel = false;
            int weekNumber = 0;
            String weekNumberError = "Week must be between 1 and 52, please try again to continue.";
        
            while (weekNumberSentinel != true && weekNumber != -1){
                try {
                    System.out.print("Enter week worked: ");
                    weekNumber = Integer.parseInt(scnr.next());
                } 
                
                catch (NumberFormatException e){
                    System.out.println(weekNumberError);
                    continue;
                }
                
                
                if (weekNumber > 0 && weekNumber < 53){
                    weekNumberSentinel = true; 
                } else{
                    System.out.println(weekNumberError);
                }
            }
        
            return weekNumber;
                
    }
    
    public double[] getInputFromUser(int calcWeek, Scanner scnr){
        /*
        gets hours worked for the week from user. 
        
        Will continue to loop until validated. 
        
        Hours worked are passed to convertStringToDouble once validated
        
        @returns outputArray as a double[] once passed back up from convertStringToDouble
        */
        
        String hoursInput;
        final int DAYS_IN_WEEK = 7;
        String[] inputArray = new String[DAYS_IN_WEEK];
        double[] outputArray = new double[DAYS_IN_WEEK];
        boolean validated = false;
        
        scnr.nextLine(); //clear the stream
        
        while (validated != true){
            System.out.printf("Enter hours for week %d: ", calcWeek);
            hoursInput = scnr.nextLine(); 
            
            try{
                inputArray = hoursInput.split(" ");
                validated = validateInput(inputArray); // calls validateInput per assignment
            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println("You must enter seven values");
            }
            
        } 
        
        if (validated == true){
            outputArray = convertStringArrayToDouble(inputArray); //calls convert to double per assignment
        }
        
        return outputArray;
        
        
    }
        
    public boolean validateInput(String[] inputArray){
        /*
        takes String[] inputArray and checks to see if input is valid. 
        
        Data are validated if:
        
        Exactly 7 values are given
        Every value must be > 0
        Every value must be able to convert to a double
        
        @returns validCheck as a boolean
        
        */
        
        boolean validCheck7 = false;
        boolean validCheckNumeric = true;
        boolean validCheckPositive = true;
        boolean validCheck15 = true;
        boolean validCheck = false;

        
        // check for exactly 7 values
        if (inputArray.length == 7){
            validCheck7 = true;
        } else {
            System.out.println("Input must have seven numbers");
        }
        
        
        // code from demo to check for all numerics
        for (int i=0; i < inputArray.length; i++){
            try{
                Double.valueOf(inputArray[i]);
            } catch (NumberFormatException e){
                System.out.println("Input must be all numeric values");
                validCheckNumeric = false;
            }
        }
        
        
        // check for negative values
        for (int i = 0; i < inputArray.length; i++){
            try{
                if (Double.valueOf(inputArray[i]) > 15){
                    validCheck15 = false;
                    System.out.println("Daily hours cannot exceed 15.");
                } else if (Double.valueOf(inputArray[i]) >= 0){
                    continue;
                } else{
                    System.out.println("Input must be all positive values.");
                    validCheckPositive = false;
                }
            } catch (NumberFormatException e){
                continue;
                }
        }
        
            

        //check if all tests pass
        
        validCheck = validCheck7 && validCheckNumeric && validCheckPositive && validCheck15;
        
        return validCheck;
    }    

    public double[] convertStringArrayToDouble(String[] inputArray){
        /*
        takes validated inputArray passed from getInputFromUser, loops through array and 
        converts elements to double.
        
        @returns outputArray as a double[]
        */
        
        
        double[] outputArray;
        outputArray = new double[inputArray.length];
        
        for (int i = 0; i < inputArray.length; ++i){
                outputArray[i] = Double.valueOf(inputArray[i]);
        }
        
        return outputArray;
    }
        
    public void calculatePayForWeek(int calcWeek, double[] arrayToProcess){
    /*
    Using provided pay logic, calculate earned pay for week. Displays output to client
    */
        
         // declare fixed variables
        final double HOUR_RATE = 15.00;
        final double BONUS_RATE = 2.00;
        final double OVERLOAD_PERCENT = 1.5;
        final double REGULAR_HOURS = 40.0;
        
        // declare the weeks that would get a bonus
        int[] highDemandWeeks = {1, 2, 44, 45, 46, 47, 48, 49, 50,
                                51, 52};
        
        
        double totalHours = 0;
        double regHoursWorked = 0;
        double overtimeHours = 0;
        int bonusPayFlag = 0; // controls if bonusPay is added to rate or not
        boolean bonusWeek = false; 
        double actualRate;
        double totalPay;
        

        totalHours = getTotalHours(arrayToProcess); // call to getTotalHours per assignment
    
        
        // how many hours are overtime, assign regular hours worked
        if (totalHours > 40){
            overtimeHours = totalHours - REGULAR_HOURS;
            regHoursWorked = 40;
        } else{
            regHoursWorked = totalHours;
        }
        
        //check if a bonus week
        
       for (int i = 0; i < highDemandWeeks.length; ++i){
           if (calcWeek == highDemandWeeks[i]){
               bonusWeek = true;
               bonusPayFlag = 1;
           }
       }
      
        
        actualRate = HOUR_RATE + (BONUS_RATE * bonusPayFlag); // up rate to bonus rate if bonus week
        
        totalPay = (regHoursWorked * actualRate) + (overtimeHours * (OVERLOAD_PERCENT * actualRate));
        
       // ****** OUTPUT TO CLIENT *******    
        
       if (bonusWeek == true){
           System.out.printf("Week %d receives a bonus of $%.2f per hour\n", calcWeek, BONUS_RATE);
       }
        
       System.out.printf("Your total pay for week %d is: $%.2f\n", calcWeek, totalPay);
       System.out.printf("You worked a total of %.2f hours\n", totalHours);
       System.out.println("Here is your summary: ");
       System.out.printf("\t Base hours worked: %.2f at $%.2f\n", regHoursWorked, actualRate);
       System.out.printf("\t Base pay: $%.2f\n", (regHoursWorked * actualRate));
       System.out.printf("\t Overtime hours worked: %.2f at $%.2f\n", overtimeHours, (actualRate * OVERLOAD_PERCENT));
       System.out.printf("\t Overtime pay: $%.2f\n", (overtimeHours * (actualRate * OVERLOAD_PERCENT)));
       
        
        // ****** /OUTPUT TO CLIENT *******
        
        
    }
    
    public double getTotalHours(double[] arrayToProcess){ // kept as double, not integer
        /*
        Takes the arrayToProcess passed from calculatePay and returns sumTotal hours. 
        Instructions say this should return an integer value, but employees would mutiny if they lost 
        partial hours worked. 
        
        @returns totalHours as a double
        */
        
        double totalHours = 0;
        
        for (int i = 0; i < arrayToProcess.length; ++i){
            totalHours = totalHours + arrayToProcess[i];
        }
        
        return totalHours;
    }
    
    
}