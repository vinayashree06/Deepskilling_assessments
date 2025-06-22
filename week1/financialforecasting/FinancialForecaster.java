public class FinancialForecaster {
    public static double forecastValue(double initialValue,double growthRate,int periods) {
        if (periods == 0) {
            return initialValue;
        }
        return forecastValue(initialValue,growthRate, periods - 1) * (1 + growthRate);
    }
 public static double forecastValueMemo(double initialValue, double growthRate, int periods, double[] memo) {
        if (periods == 0) return initialValue;
        if (memo[periods] != 0) return memo[periods];
        memo[periods] = forecastValueMemo(initialValue, growthRate, periods - 1, memo) * (1 + growthRate);
        return memo[periods];
    }
}
