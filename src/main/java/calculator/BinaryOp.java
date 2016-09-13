package calculator;


/**
 * Created by james on 9/13/16.
 */
public interface BinaryOp {
    Number eval(int op1, int op2);
    Integer getPrecedence();
    String getSymbol();
}
