class Solution:
    def fib(self, N: int) -> int:
        P = [0] * (N+1)
        if (N == 0):
            return 0
        if(N == 1):
            return 1
        P[1] = 1

        for i in range(2, N+1):
            P[i] = P[i-1] + P[i-2]
        return P[N]
