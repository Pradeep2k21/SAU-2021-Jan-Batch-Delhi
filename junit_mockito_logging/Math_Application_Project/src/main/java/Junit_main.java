
public class Junit_main implements ServiceCalculator{

    @Override
    public double add(double number1, double number2) {
        return number1+number2;
    }

    @Override
    public double subtract(double number1, double number2) {
        return number1-number2;
    }

    @Override
    public double multiply(double number1, double number2) {
        return number1*number2;
    }

    @Override
    public double divide(double number1, double number2) {
        return number1/number2;
    }
}
