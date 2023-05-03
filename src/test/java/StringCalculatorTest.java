import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    public void beforeEach() {
        calculator = new StringCalculatorImpl();
    }

    @Test
    public void testEmptyStringReturnsZero() {
        Assertions.assertEquals(0, calculator.add(""));
    }

    //Gjorda tester
    @Test
    public void testSingleNumberReturnsNumber(){
        Assertions.assertEquals(1,calculator.add("1"));
        Assertions.assertEquals(0, calculator.add("0"));
        Assertions.assertEquals(9,calculator.add("9"));
        Assertions.assertEquals(11, calculator.add("11"));

    }
    @Test
    public void testMultipleNumbersSplitByComma(){
        Assertions.assertEquals(3, calculator.add("1,2"));
        Assertions.assertEquals(12, calculator.add("4,8"));
        Assertions.assertEquals(14, calculator.add("11,3"));
    }
    @Test
    public void testUnknownAmountOfNumbers(){
        Assertions.assertEquals(3,calculator.add("1,1,1"));
        Assertions.assertEquals(102,calculator.add("90,5,6,1"));
    }

    @Test
    public void testNewLineAdd(){
        Assertions.assertEquals(6, calculator.add("1\n2,3"));
        Assertions.assertEquals(14, calculator.add("5\n9"));
    }

    @Test
    public void testUserMadeDelimiter(){
        Assertions.assertEquals(3, calculator.add("//;\n1;2"));
        Assertions.assertEquals(12, calculator.add("//€\n6€6"));
        Assertions.assertEquals(24, calculator.add("//€\n6€6€6€6"));
    }
}
