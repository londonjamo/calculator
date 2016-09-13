package calculator;

import calculator.functions.Add;
import calculator.functions.Subtract;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

/**
 * Created by james on 9/13/16.
 */
public class CalculatorTest {
    @Test
    public void testPrecedence() {
        Add add = new Add();
        Subtract subtract = new Subtract();
        Calculator cut = new Calculator();
        assertFalse(cut.isLowerPrecedence(add,subtract));
    }
}
