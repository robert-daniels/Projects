'''
Just general review of notes chapt 1 - 6, scratchpaper

'''

# week 2

print("Welcome to KC")
print('Welcome to kc')

print("Hello Chiefs", end = " ") # hey, there's a comma there. neat

# name = input("What is your name?")
# print(name)

a, b, c = 92, 92, 92 
print(a)
print(b)

order_value = 12300.05
print(type(order_value))

print("Tom " + "Brady")

# week 3 #TODO should go back over this and look at the misc methods before class

myTuple = (1, 1.0, True, "one")
print(type(myTuple))
print(len(myTuple)) # didn't remember it was len() not myTuple.length(), #TODO 

print(myTuple[1:4])
print(myTuple[-1])

tempList = list(myTuple) # looks like list() isn't the unary I thought. gonna assign a temp variable to be safe #TODO 
print(type(tempList))
tempList.append("added")
myTuple = tuple(tempList)
print(myTuple)

myList = [1, 2, 3, 5, 4]
print(myList)
myList[2] = "added" # hey, don't get tripped up on the way basic. #TODO
print(myList)
removedEle = myList.pop(1) # remove and return element at the index provided
print(removedEle)
print(myList)
removedEle = myList.pop(1)

myList.sort()
print(myList)

myDict = { 
           101: 'Math',
           105: 'Music',
           108: 'Spanish'
}

print(myDict.keys())
print(myDict.values()) 

myDict[110] = "programming"
myDict[730] = "glassblowing"

print(myDict)

# week 4 
# TODO quick rundown of math and random. import math/import random. ceil, floor, etc. 

try:
    userInput = int(input("Type a number for the dealamajig: "))

    if userInput:
        print("that number exists and is greater than 0")
    else:
        print("you enetered zero, or that number doesn't exist")
except:
    print("Incorrect, try again")