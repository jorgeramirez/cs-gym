
# return fibonacci of n. 
# fib(0) is 0, fib(1) is 1

P = {}

def fib(n):
	if n == 0:
		return 0
	if n == 1:
		return 1
	if(n in P):
		return P[n]
	P[n] = fib(n - 1) + fib(n - 2)
	return P[n]



if __name__ == "__main__":
	print("fib(0)", fib(0))
	print("fib(5)", fib(5))
	print("fib(2)", fib(2))
	print("fib(4)", fib(4))