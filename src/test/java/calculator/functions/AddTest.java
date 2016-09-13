package calculator.functions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by james on 9/13/16.
 */
public class AddTest {
    Add cut = null; // class under test

    @Before
    public void setup() {
        cut = new Add();
    }

    @After
    public void teardown() {
        cut = null;
    }


    @Test
    public void test1() {
       assertEquals(3,cut.eval(1,2));
    }

}
