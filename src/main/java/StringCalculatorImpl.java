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
            int total;
            return total = Stream.of (input.split(",")).mapToInt(Integer::parseInt).sum();
        }
        return Integer.parseInt(input);
    }
}
