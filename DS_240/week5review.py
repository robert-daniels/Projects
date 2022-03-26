'''week 5 review'''
import random


myList = [1, 2, 3, 4, 5]

randListChoice = random.choice(myList)

for i in range(10):
    print(random.choice(myList))

randomRangeVariable = random.randrange(0, 25, 3)
print(randomRangeVariable)

print(f"myList before shuffle is {myList}")
random.shuffle(myList)
print(f"myList after shuffle is {myList}")

for i in range(10):
    print(i + 1)

stateList = ["ar", "mo", "ks"]

[print(ele) for ele in stateList]


[print(i) for i in range(10)]



def greetAnother(userName="anon"):
    print(f"hello again, {userName}")

greetAnother("Bolli")
greetAnother()

def sortList(list):
    print(f"the list originally is {list}")
    random.shuffle(list)
    [print(ele, end=" ") for ele in list]

sortList(myList)

rangeValue = int(input("Tell me a number for range: "))

rangeList = list(range(rangeValue))

print(random.choice(rangeList))