def square_digits(num):
    numSplit = list(str(num))
    answer = ""
    
    print(numSplit)
    
    for d in numSplit:
        answer = answer + str(int(d) ** 2)
    
    return answer


square_digits(9119)