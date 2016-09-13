package calculator;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by james on 9/13/16.
 */
@Component
public class Calculator {

    Stack<Integer> values = new Stack<>();
    Stack<BinaryOp> operations = new Stack<>();

    Map<String, BinaryOp> functions = new HashMap<>();

    public Integer run(String expression) {
        StringTokenizer tokenizer = new StringTokenizer(expression);

        while (tokenizer.hasMoreElements()) {
            String token = tokenizer.nextToken();
            // poor error checking. either its a known function or a number.
            // if a real calculator this would be a lot more thorough
            if (functions.containsKey(token)) {
                //System.out.println("pushing token " + token);
                while (!operations.isEmpty()) {
                    if (isLowerPrecedence(operations.peek(), functions.get(token)) ) {
                        break;
                    }
                    doOperation();
                }
                operations.push(functions.get(token));
            } else {
                values.push(Integer.parseInt(token));
                //System.out.println("pushing value " + token);
            }
        }

        while (!operations.isEmpty()) {
            doOperation();
        }
        Integer result = values.pop();
        return result;
    }

    public boolean isLowerPrecedence(BinaryOp op1, BinaryOp op2) {
        if (op1.getPrecedence() < op2.getPrecedence()) {
            return true;
        }
        return false;
    }

    public Integer doOperation() {
        Integer op1 = values.pop();
        Integer op2 = values.pop();
        Number result = operations.pop().eval(op1, op2);
        values.push((Integer) result);
        return (Integer) result;
    }

    public void register(BinaryOp op) {
        System.out.println("registering " + op.getSymbol());
        this.functions.put(op.getSymbol(),op);
    }
}
