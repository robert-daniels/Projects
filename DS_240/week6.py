'''
Week 6 - sets, error handling, file handling
@Author: Robert Daniels
03/04/2022

'''
 

# 1. 

from decimal import DivisionByZero

from jinja2 import UndefinedError


myList = [1, 1, 2, 2, 3, 3, 4, 4, 5, 9]

mySet = set(myList)
print(f"I turned my list: {myList}\ninto this set: {mySet}. \nThe data type for this set is {type(mySet)}.")

# 2. 

mySet2 = {2, 2, 4, 4, 6, 6, 8, 8, 10, 10}
print(f"I made another set called mySet2.\nHere are the resulting values\n{mySet2}.")
print(f"The data type of mySet2 is: {type(mySet2)}")

# 3. 

print(f"The length of mySet2 is {len(mySet2)}.")

for i in range(11):
    if i in mySet2:
        print(f"{i} exists in mySet2.")
    else:
        print(f"{i} does not exist in mySet2.")

# 4. 

print("I'm going to add 0 and 9 to mySet2")
mySet2.add(0)
mySet2.add(9)
print(f"mySet2 then becomes {mySet2}.")
print("I'm going to remove 2 elements now.")
mySet2.pop()
mySet2.pop()
print(f"mySet2 is now: {mySet2}")

# 5.

print(f"The intersection of mySet and mySet2 is {mySet.intersection(mySet2)}")

# 6.

print(f"The difference of mySet to mySet2 is {mySet.difference(mySet2)}")
print(f"The difference between mySet2 to mySet is {mySet2.difference(mySet)}")

# 7.

fs1 = frozenset(list(mySet2)) # being lazy, just coverting the 5 member set back to list

try:
    frozenset.add(20)
except:
    print("Hey, you know you can't add anything to a frozen set. I don't even know what .add() means in this context")

# 8.

try:
    1 / 0
except ZeroDivisionError:
    print("Congrats, you just blew up the universe by dividing by zero.")

# 9. 

try:
    print(anUndefinedVariable)
except NameError:
    print("Ok I have no idea what that variable is called.")

# 10.


newFile = open("C:\\Users\\robertd\\Desktop\\Fruits.txt", "w+")

newFile.writelines(["A","B","C"])

newFile.seek(0)
print(newFile.read())

newFile.close()
