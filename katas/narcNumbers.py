
def narcNumberChecker(n):
    '''Narc number is when the sum of its own digits raised to the power of the # of digits, is the number itself
        ex: 153 has 3 digits, and is narcissistic. 

        [1 ^ 3] + [5 ^ 3] + [3 ^ 3] = 1 + 125 + 27 = 153

        loop through the numbers digits, count how many there are, add them, compare to original param. 

        @param n as a non-negative integer


    '''

    providedN = n
    digitCount = 0
    sum = 0
    digitList = []
    

    while n != 0:
        digitList.append( n % 10 )
        n = n // 10
        digitCount += 1
        print(digitCount)
    
    for i in digitList:
        sum += (i ** digitCount)
        print(sum)

    return (sum == providedN)

print(narcNumberChecker(153))

# --------------------------------------------------------------------------
'''put to -shame- on this one. there was a much much easier solution'''

'''basically used the String tools. converted the int to a string to get the length (number of chars)
AND its an iterable object, so just scrolled right on through the digits after type casting to int. '''

def narcNumberChecker(value):
    return value == sum(int(x) ** len(str(value)) for x in str(value))


