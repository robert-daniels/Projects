#throwaway

'''
Author: Robert Daniels
02/17/2022
Testing extensions and modifications with VS Code using standard fizzbuzz
'''


userInput = int(input("Pick an integer you want me to run: "))

for i in range(userInput + 1):
    if ( (i % 5 == 0) & (i % 3 == 0) ):
        print("fizzbuzz")
    elif (i % 5 == 0):
        print("buzz")
    elif (i % 3 == 0):
        print("fizz")
    else:
        print(i)
