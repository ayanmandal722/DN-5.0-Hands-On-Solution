public class FinancialForecast {
    // Recursive method to calculate future value
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue; // Base case: no more years left
        }
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }
    // Main method to test the forecasting
    public static void main(String[] args) {
        double initialInvestment = 10000.0; // Example: $10,000
        double annualGrowthRate = 0.05;     // Example: 5% growth per year
        int numberOfYears = 10;             // Forecast for 10 years

        double futureValue = calculateFutureValue(initialInvestment, annualGrowthRate, numberOfYears);

        System.out.printf("Future value after %d years: %.2f%n", numberOfYears, futureValue);
    }
}
