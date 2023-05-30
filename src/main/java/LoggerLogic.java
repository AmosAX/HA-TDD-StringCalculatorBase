import java.util.ArrayList;
import java.util.List;

public class LoggerLogic implements Logger {
    private List<Integer> loggedNumbers = new ArrayList<>();

    public List<Integer> getLoggedNumbers() {
        return loggedNumbers;
    }

    @Override
    public void log(Integer number) {
        System.out.println("Add() was called and a large number was found!: "+number);
        loggedNumbers.add(number);
    }

}
