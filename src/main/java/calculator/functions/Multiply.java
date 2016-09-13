package calculator.functions;

import calculator.BinaryOp;
import calculator.Function;
import org.springframework.stereotype.Component;

/**
 * Created by james on 9/13/16.
 */
@Component
@Function
public class Multiply implements BinaryOp {

    public Number eval(int op1, int op2) {
        return op1 * op2;
    }

    public Integer getPrecedence() {
        return 20;
    }

    public String getSymbol() {
        return "*";
    }
}
