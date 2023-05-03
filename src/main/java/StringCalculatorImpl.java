public class StringCalculatorImpl implements StringCalculator {

    @Override
    public int add(String input) {
        //TODO implement
        if(input.isEmpty()){
            return 0;
        }
        if(!input.isEmpty()){
            return Integer.valueOf(input);
        }
        return -1;
    }
}
