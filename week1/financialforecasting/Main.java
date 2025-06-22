public class Main {
    public static void main(String[] args) {
        double initial = 1000.0;
        double rate = 0.05;
        int years = 10;

        System.out.println("Recursive Forecast");
        double result = FinancialForecaster.forecastValue(initial,rate,years);
        System.out.printf("Future Value after %d years: ₹%.2f\n",years,result);
        System.out.println("\nOptimized Forecast");
        double[] memo = new double[years + 1];
        double resultMemo = FinancialForecaster.forecastValueMemo(initial,rate,years,memo);
        System.out.printf("Future Value after %d years: ₹%.2f\n",years,resultMemo);
    }
}
