'''week 5 review'''
import random

def randomFunction(str):
    print(str)
    return "I did it"

print(randomFunction("check it out"))

def concatEx(str1, int):
    combined = str1 + str(int)
    print(combined)
    return ("I did it again")

print(concatEx(int=1, str1="yes"))

x = -3

while x < 4:
    print(f"x is {x}")
    x += 1
else: # this is a nice feature, really. not sure why I haven't seen while/else 
    print(f"x is {x} which is not < 4")


cityList = ["olathe", "leawood", "shawnee"]

cityList[:] = [(i + "s") for i in cityList]
print(cityList)

### stop at random number functions 

print(random.choice(range(50)))

testString = "Summer Time"
print(random.choice(testString))

for i in range (5):
    print(i)

print(random.randrange(1, 100, 2))

testRange = list(range(10))
print(testRange)

random.shuffle(testRange)

print(testRange)