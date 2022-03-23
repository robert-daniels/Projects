import math
import random 

x = 1


if x: 
    print("true")
else:
    print("false")


price = 100 / 3.0

print(f"Price is actually: {price:.2f}")

for i in "string": print(i, end=" ")
print("")

#============Math items=================
# moves up the number line

print(math.ceil(-25.3))
print(math.ceil(25.3))

# moves down the number line

print(math.floor(-25.3))
print(math.floor(25.3))


print(round(44.32,1))
print(round(44.32,5))

print(random.random())