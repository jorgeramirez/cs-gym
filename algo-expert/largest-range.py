"""
Write a function that takes in an array of integers and returns an array of length 2 
representing the largest range of numbers contained in that array. 
The first number in the output array should be the first number in the range while 
the second number should be the last number in the range. 

A range of numbers is defined as a set of numbers that come right after each 
other in the set of real integers.

For instance, the output array [2, 6] represents the range {2, 3, 4, 5, 6}, which is a 
range of length 5. Note that numbers do not need to be ordered or adjacent in the array in 
order to form a range. Assume that there will only be one largest range.


Sample input: [1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6]
Sample output: [0, 7]
"""


def get_delta(range_desc):
    """
    Computes the length of the given range. The lenght means how many numbers are in 
    the range.
    """
    if range_desc[0] < 0 and range_desc[1] >= 0:
        delta = abs(range_desc[0] - range_desc[1])

        if range_desc[1] == 0:
            delta += 1
        return delta
    return range_desc[1] - range_desc[0] + 1


def sort_array(array):
    array.sort()


def largest_range_v1(array):
    """
      Time: O(nlogn)
      Space: O(1)

      This alternative sorts the array first.
        1. sort the array
        2. iterate over the array and create groups of items that form a range
        3. return the largest group  
    """
    if array == None:
        return [0, 0]

    if len(array) == 0:
        return [0, 0]

    sort_array(array)
    range_found = [array[0], array[0]]
    current_range = [array[0], array[0]]

    for i in range(1, len(array)):
        delta = array[i] - current_range[1]

        if delta == 1 or delta == 0:  # delta=0 handles repited numbers
            current_range[1] = array[i]
        else:
            delta_current = get_delta(current_range)
            delta_found = get_delta(range_found)

            if delta_current > delta_found:
                range_found = current_range.copy()  # avoid reference issues!!!
            current_range[0] = array[i]
            current_range[1] = array[i]

    delta_current = get_delta(current_range)
    delta_found = get_delta(range_found)

    if delta_current > delta_found:
        return current_range
    return range_found


def largest_range_v2(array):
    """
    This alternative does not sort the input array.
    """
    pass


def largestRange(array):
    return largest_range_v1(array)
