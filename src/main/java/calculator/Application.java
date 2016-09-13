package calculator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import java.util.Map;

/**
 * Created by james on 9/13/16.
 */
@Configuration
@ComponentScan
public class Application {

    public static void main(String[] args) {
        System.out.println("hello there James!");
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

        Calculator calculator = (Calculator) context.getBean(Calculator.class);
        Map<String,Object> functions = context.getBeansWithAnnotation(Function.class);

        // crude attempt to demomstrate loading in functions. users could add in
        // their own defined ones if they so choose
        for (Object function: functions.values()) {
            calculator.register((BinaryOp) function);
        }

        int result = calculator.run("2 * 11 + 3 + 2");
        System.out.println("\n result is " + result);
    }
}


