package com.hphan.array;

public class MaxProfitStock_121
{
    public int maxProfit(int[] prices)
    {
	if (prices.length == 0)
	    return 0;

	int minPrice = prices[0], maxProfit = 0;

	for (int i = 1; i < prices.length; i++)
	{
	    minPrice = minPrice < prices[i] ? minPrice : prices[i];
	    if (prices[i] - minPrice > maxProfit)
		maxProfit = prices[i] - minPrice;
	}
	return maxProfit;
    }
}
