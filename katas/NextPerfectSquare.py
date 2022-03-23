import math


# TODO, logic error, math.sqrt(121) returns 11.0 float, should probably to sqrt - int(sqrt) == 0? test


def find_next_square(sq): 
    #return next square if sq is a square. -1 otherwise
    test1 = math.sqrt(sq)
    test2 = int(math.sqrt(sq))
    boolinstance = isinstance(math.sqrt(sq), int)

    if isinstance(math.sqrt(sq), int):
        nextInt = int(math.sqrt(sq) + 1)
        return [ nextInt * nextInt ]
    else:
        return -1

print(find_next_square(121)) 
