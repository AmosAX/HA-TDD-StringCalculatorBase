import java.util.stream.Stream;

public class StringCalculatorImpl implements StringCalculator {

    @Override
    public int add(String input) {
        //TODO implement

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
