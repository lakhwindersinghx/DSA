public class LeetCode121 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        LeetCode121 x = new LeetCode121();
        System.out.println(x.maxProfit(prices));

    }

    public int maxProfit(int[] prices) {
        int smallest = Integer.MAX_VALUE;
        int biggest = Integer.MIN_VALUE;
        int cheapestIndex = 0;
        int bestDayIndex = 0;
        int profit = 0;
        for (int buy = 0; buy < prices.length; buy++) {
            if (prices[buy] < smallest) {
                smallest = prices[buy];
                cheapestIndex = buy; //1 in our case
            }
        }
        for (int sell = cheapestIndex+1; sell < prices.length; sell++) {
            if (prices[sell] > biggest) {
                biggest = prices[sell];
                bestDayIndex = sell;
            }
        }
        return profit=biggest-smallest;
    }
}

