package Katas;


public class SumOfPositive {

    public static void main(String args[]){

        int answer = 0;

        int[] arr = {1, 2, 3, 4, 5};

        for (int i = 0; i < arr.length; ++i){
            if (arr[i] > 0){
                answer += arr[i];
            }
        }

        System.out.println(answer);
    }
    
}
