import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class StringCalculatorTest {

    private StringCalculator calculator;
    private LoggerLogic mockLog;


    @BeforeEach
    public void beforeEach() {
        this.mockLog = new LoggerLogic();
        this.calculator = new StringCalculatorImpl(mockLog);

    }

    @Test
    public void testMainWelcomeAndHelpText() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        Calculator.main();
        String output = outputStream.toString();
        assertEquals("Welcome to the calculator!\n", output);
        assertEquals("please enter the numbers.\n", output);

        System.setOut(System.out);
    }
    @Test
    public void testMainMethodWithInput() {

    }


    @Test
    public void testLoggerIsCalledForNumbersAbove1000WithMockitoVerify() {

        // Create a mock logger
        Logger mockLogger = mock(Logger.class);
        // Create an instance of StringCalculator and inject the mock logger
        StringCalculator stringCalculator = new StringCalculatorImpl(mockLogger);
        stringCalculator.add("1,2000,3");
        verify(mockLogger).log(2000);
        verify(mockLogger, times(1)).log(2000);
    }


    @Test
    public void testAddMethodLogsMultipleNumbersGreaterThan1000() {
        calculator.add("1,2000,3000,4");

        List<Integer> loggedNumbers = mockLog.getLoggedNumbers();
        assertEquals(2, loggedNumbers.size());
        assertEquals(2000, loggedNumbers.get(0));
        assertEquals(3000, loggedNumbers.get(1));
    }


    @Test
    public void testEmptyStringReturnsZero() {
        assertEquals(0, calculator.add(""));
    }

    //Gjorda tester
    @Test
    public void testSingleNumberReturnsNumber(){
        assertEquals(1,calculator.add("1"));
        assertEquals(0, calculator.add("0"));
        assertEquals(9,calculator.add("9"));
        assertEquals(11, calculator.add("11"));

    }
    @Test
    public void testMultipleNumbersSplitByComma(){
        assertEquals(3, calculator.add("1,2"));
        assertEquals(12, calculator.add("4,8"));
        assertEquals(14, calculator.add("11,3"));
    }
    @Test
    public void testUnknownAmountOfNumbers(){
        assertEquals(3,calculator.add("1,1,1"));
        assertEquals(102,calculator.add("90,5,6,1"));
    }

    @Test
    public void testNewLineAdd(){
        assertEquals(6, calculator.add("1\n2,3"));
        assertEquals(14, calculator.add("5\n9"));
    }

    @Test
    public void testUserMadeDelimiter(){
        assertEquals(3, calculator.add("//;\n1;2"));
        assertEquals(12, calculator.add("//€\n6€6"));
        assertEquals(24, calculator.add("//€\n6€6€6€6"));
    }

    @Test
    public void testRaiseExcepetionOnNegativeNumbers(){

        try{
            calculator.add("-1,2");
            Assertions.fail("this should raise an exception");
        } catch (RuntimeException ex){
            //good
        }
    }
    @Test
    public void testRaiseExcepetionOnNegativeNumbersWithMessage(){

        try{
            calculator.add("-1,-2");
            Assertions.fail("this should raise an exception");
        } catch (RuntimeException ex){
            assertEquals("Can't use negative numbers[-1, -2]", ex.getMessage());
        }

    }

}

