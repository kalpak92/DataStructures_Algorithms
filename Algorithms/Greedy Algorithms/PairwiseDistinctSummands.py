# Uses python3
import sys


def optimal_summands(n):
    """Pairwise Distinct Summands.
    The goal of this problem is to represent a given positive integer n as
    a sum of as many pairwise distinct positive integers as possible.
    Samples:
    >>> optimal_summands(6)
    3
    1 2 3
    >>> optimal_summands(8)
    3
    1 2 5
    """
    summands = [1]
    n -= 1
    while n:
        last_element = summands[-1]
        # Safe move: check whether the incremented last element can be used as
        # the next summand.
        if (last_element + 1) * 2 <= n:
            n -= last_element + 1
            summands.append(last_element + 1)
        else:
            if last_element >= n:
                n += summands.pop()
            summands.append(n)
            n = 0

    return summands


if __name__ == "__main__":
    input = sys.stdin.readline()
    n = int(input)
    summands = optimal_summands(n)
    print(len(summands))
    for x in summands:
        print(x, end=" ")
    print("\n")
