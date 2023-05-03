import java.util.stream.Stream;

public class StringCalculatorImpl implements StringCalculator {

    @Override
    public int add(String input) {
        //TODO implement

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
