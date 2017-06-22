# Uses python3
import sys
from collections import namedtuple

Segment = namedtuple('Segment', 'start end')


def optimal_points(segments):
    """Covering Segments by Points.
    You are given a set of segments on a line and your goal is to mark as
    few points on a line as possible so that each segment contains at least
    one marked point.
    Samples:
    >>> segments = [
    ... Segment(start=1, end=3),
    ... Segment(start=2, end=5),
    ... Segment(start=3, end=6)]
    >>> optimal_points(segments)
    1
    3
    >>> # Explanation: In this sample, we have three segments:
    >>> # [1, 3], [2, 5], [3, 6] (of length 2, 3, 3 respectively). All of them
    >>> # contain the point with coordinate 3: 1 ≤ 3 ≤ 3, 2 ≤ 3 ≤ 5, 3 ≤ 3 ≤ 6.
    >>> segments = [
    ... Segment(start=4, end=7),
    ... Segment(start=1, end=3),
    ... Segment(start=2, end=5),
    ... Segment(start=5, end=6)]
    >>> optimal_points(segments)
    2
    3 6
    >>> # Explanation: The second and the third segments contain the point with
    >>> # coordinate 3 while the first and the fourth segments contain the point
    >>> # with coordinate 6. All the four segments cannot be covered by a single
    >>> # point, since the segments [1, 3] and [5, 6] are disjoint.
    """
    # Sort segments by the right endpoint.
    sorted_segments = sorted(segments, key=lambda x: x.end)

    points = []
    while sorted_segments:
        # Place the first point to the right endpoint of the first segment.
        # Remove the segment, since it's considered as covered one.
        segment = sorted_segments.pop(0)
        point = segment.end
        points.append(point)

        # Check whether the point hit the other segments.
        for s in sorted_segments[:]:
            if s.start <= point <= s.end:
                sorted_segments.remove(s)

    return points


if __name__ == "__main__":
    input = sys.stdin.readline()
    n, *data = map(int, input.split())
    
    '''
    So inp will be a list of the entered space delimited numbers.
    For python2 simply replace input() with raw_input()

    How it works?
    input() accepts a string from STDIN. 
    split() splits the string about whitespace character and returns a list of strings.
    map()passes each element of the 2nd argument to the first argument and returns a map object
    Finally list()converts the map to a list
    '''
    segments = list(
        map(lambda x: Segment(x[0], x[1]), zip(data[::2], data[1::2])))

    points = optimal_points(segments)
    print(len(points))
    for p in points:
        print(p, end=" ")