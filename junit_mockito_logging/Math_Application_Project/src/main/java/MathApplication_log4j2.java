import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MathApplication_log4j2 {

    private static final Logger LOGGER = LogManager.getLogger(MathApplication_log4j2.class);

    private static Junit_main mathApplicationJunit = new Junit_main();

    private static void basicLoggerMethods(){
        System.out.println("\nLogger Methods: ");
        LOGGER.debug("Debug Message Logged !!!");
        LOGGER.info("Info Message Logged !!!");
        LOGGER.warn("Warning Message Logged !!!");
        LOGGER.fatal("Fatal Message Logged !!!");
        LOGGER.error("Error Message Logged !!!", new NullPointerException("NullError"));
    }

    public static void logCalculator(Double num1, Double num2){

        Double ans;

        System.out.println("\nCalculator: "+num1 + ", "+num2);

        ans = mathApplicationJunit.add(num1, num2);
        LOGGER.info("Addition: "+ans);

        ans = mathApplicationJunit.subtract(num1, num2);
        LOGGER.info("Subtraction: "+ans);

        ans = mathApplicationJunit.multiply(num1, num2);
        LOGGER.info("Multiplication: "+ans);

        ans = mathApplicationJunit.divide(num1, num2);
        LOGGER.info("Division: " + ans);

    }

    public static void main(String[] args)
    {
        basicLoggerMethods();

        Double num1 = 40.0, num2 = 20.0;
        logCalculator(num1, num2);

        num1 = 20.0; num2 = 0.0;
        logCalculator(num1, num2);

    }
}
