
    public class Math_Application_Main {

        private ServiceCalculator calcService;

        public void setCalService(ServiceCalculator calcService)
        {
            this.calcService = calcService;
        }

        public double add(double num1, double num2)
        {
            return calcService.add(num1,num2);
        }

        public double subtract(double num1, double num2)
        {
            return calcService.subtract(num1,num2);
        }

        public double multiply(double num1, double num2)
        {
            return calcService.multiply(num1,num2);
        }

        public double divide(double num1, double num2)
        {
            return calcService.divide(num1, num2);
        }
    }

