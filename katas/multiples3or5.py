def solution(number):
    '''sum all natural number multiples of 3 or 5 up to but not inluding param passed.
       Return zero if param is negative.'''
    
    sumReturn = 0
    
    if number < 0:
        return 0
    
    for i in range(number):
        print(i)
        
        if i % 5 == 0 & i % 3 == 0:
            sumReturn += i
            continue
        elif i % 3 == 0:
            sumReturn += i
        elif i % 5 == 0:
            sumReturn += i
            
    return sumReturn
            

solution(4)

#=====Best solution much cleaner code. I really need to learn this syntax

def bestsolution(number):
    return sum(x for x in range(number) if x % 3 == 0 or x % 5 == 0)

#basically the same, just condensed into a much easier to read format. Also takes advantage of the fact that "or" short-circuits when it finds the first statement as true. 