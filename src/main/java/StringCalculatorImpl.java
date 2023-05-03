import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringCalculatorImpl implements StringCalculator {

    @Override
    public int add(String input) {
        //TODO implement

        //if the strings starts with this we got a specific user delimiter
        if(input.startsWith("//")){
            char userDelimiter = input.charAt(2);
            String userDelimiterString = String.valueOf(userDelimiter);
            input = input.replace(userDelimiterString,",");
            //now that we have used the delimiter we can start the string without it
            input = input.substring(input.indexOf('\n') + 1);


            //System.out.println("The final input is" + input);
        }

        //Deal with the newlines by replacing them with commas
        input = input.replace("\n", ",");

        if(input.isEmpty()){
            return 0;
        }
        else if(input.contains(",")){

            IntStream test = Stream.of (input.split(",")).mapToInt(Integer::parseInt);

            int[] numbersFromString = test.toArray();
            List<Integer> negatives = getNegativeNumbers(numbersFromString);

            if(!checkForNegative(numbersFromString)){
                throw new RuntimeException("Can't use negative numbers" + negatives.toString());
            }

            int total;
            return total = Stream.of (input.split(",")).mapToInt(Integer::parseInt).sum();
        }
        return Integer.parseInt(input);
    }

    public static boolean checkForNegative(int []arr){

        //declare boolean to check for negative or 0
        boolean flag = false;
        // check is there any negative numbers or 0
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] <= -1){
                flag = true;
                break;
            }
        }
        if(!flag) {
            //System.out.println("Array do not contain 0 or a negative number.");
            return true;
        }
        else
            //System.out.println("Array contain 0 or a negative number.");
        return false;
    }

    public static List<Integer> getNegativeNumbers(int[] numbers) {

        // variables
        boolean flag = false;
        int i = 0;

        List<Integer> NegativeNumberlist = new ArrayList <Integer>();


        // check is there any negative numbers?
        for (i = 0; i < numbers.length; i++) {
            if(numbers[i] < 0){
                NegativeNumberlist.add(numbers[i]);
            }
        }
        return NegativeNumberlist;
    }
}

