def reverse_number(x):
    x_reversed = ""
    x_str = str(x)
    sign = ""
    if x_str[0] == "-":
        sign = "-"
        x_str = x_str[1:]

    for d in x_str:
        x_reversed = d + x_reversed
    x_reversed_int = int(sign + x_reversed)
    lower_bound = -2 ** 31
    upper_bound = 2 ** 31 - 1

    if x_reversed_int < lower_bound or x_reversed_int > upper_bound:
        return 0
    return x_reversed_int



class Solution:
    def reverse(self, x: int) -> int:
        return reverse_number(x)
