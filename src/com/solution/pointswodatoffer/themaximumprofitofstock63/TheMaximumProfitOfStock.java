package com.solution.pointswodatoffer.themaximumprofitofstock63;

public class TheMaximumProfitOfStock {

}

class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;
        if (n <= 1) {
            return 0;
        }

        int min = prices[0];
        int max = 0;
        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            min = Math.min(min, prices[i - 1]);
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
            max = Math.max(max, dp[i]);
        }
        return max;

    }
}

/**
 * 用变量代替数组，降低空间复杂度
 */
class Solution2 {
    public int maxProfit(int[] prices) {

        int n = prices.length;
        if (n <= 1) {
            return 0;
        }

        int min = prices[0];
        int temp = 0;
        int max = 0;

        for (int i = 1; i < n; i++) {
            min = Math.min(min, prices[i - 1]);
            temp = Math.max(temp, prices[i] - min);
            max = Math.max(max, temp);
        }
        return max;

    }
}

/**
 * 优化初始化
 */
class Solution3 {
    public int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int profit = 0;

        for (int price : prices) {
            minPrice = Math.max(minPrice, price);
            profit = Math.max(profit, price - minPrice);
        }

        return profit;

    }
}

/**
 * 不使用数学函数以减少时间
 */
class Solution4 {
    public int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int profit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if ((price - minPrice) > profit) {
                profit = price - minPrice;
            }
        }

        return profit;
    }
}