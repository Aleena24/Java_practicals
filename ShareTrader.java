public class ShareTrader {

    // Static variable to store the maximum profit
    private static int maxProfit;

    // Static method to find the maximum profit based on stock prices
    public static int findMaxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            // Not enough data to make transactions
            return 0;
        }

        maxProfit = 0;
        int n = prices.length;

        // Iterate through all possible transactions
        for (int firstBuy = 0; firstBuy < n - 1; firstBuy++) {
            for (int firstSell = firstBuy + 1; firstSell < n; firstSell++) {
                // Calculate profit for the first transaction
                int profit1 = prices[firstSell] - prices[firstBuy];

                // Iterate through the remaining transactions
                for (int secondBuy = firstSell + 1; secondBuy < n - 1; secondBuy++) {
                    for (int secondSell = secondBuy + 1; secondSell < n; secondSell++) {
                        // Calculate profit for the second transaction
                        int profit2 = prices[secondSell] - prices[secondBuy];

                        // Update maxProfit if the sum of profits is greater
                        maxProfit = Math.max(maxProfit, profit1 + profit2);
                    }
                }
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        // Example usage
        int[] stockPrices = {3, 8, 5, 1, 7, 8};
        int result = findMaxProfit(stockPrices);
        System.out.println("Maximum Profit: " + result);
    }
}
