"""
Max Profit With K Transactions

You are given an array of integers representing the prices of a single stock on various days (each index in 
the array represents a different day). You are also given an integer k, which represents the number of transactions 
you are allowed to make. One transaction consists of buying the stock on a given day and selling it on another, later day. 

Write a function that returns the maximum profit that you can make buying and selling the stock, given k transactions. 

Note that you can only hold 1 share of the stock at a time; in other words, you cannot buy more than 1 share of the stock 
on any given day, and you cannot buy a share of the stock if you are still holding another share.

Sample input: [5, 11, 3, 50, 60, 90], 2
Sample output: 93 (Buy: 5, Sell: 11; Buy: 3, Sell: 90)
"""


def maxProfitWithKTransactions(prices, k):
    # Write your code here.
    # IDEA: determine the "profit ranges". A profit range is a segment that keeps going up every single day
    # based on how many profit ranges we have, we split these so that we meet the K transactions
    # if profit ranges = 1 and K=2 then we split the profit ranges in half and just pick the first and last points of each partition :)
    # in the example we have profit ranges = 2 and k = 2, that's why we return (5, 11) and (3, 90) because these are the min and max points in each profit range.
    pass
