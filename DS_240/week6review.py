'''reviewing week6 material'''
import random

# try:
#     3 / 0
# except:
#     print("that would blow up the universe")
# finally: 
#     print("try again")


myFile1 = open("H:\Projects-1\KansasTownsPop2.txt")

print(myFile1.mode)

print(myFile1.read())

myFile1.seek(6)

print(myFile1.tell())

print(myFile1.read(6))

myFile1.seek(0)

for line in myFile1.readlines():
    print(line if line.startswith("G") else "", end="")

randomList = []
for i in range(50):
    randomList.append(random.randrange(10))

print(randomList)

convertedSet = set(randomList)
print(convertedSet)

print(f"{len(randomList) - len(convertedSet)} duplicates were removed.")

i = 99

print(i if i in convertedSet else "nupe")

testSet1 = {1, 2, 3, 4, 5, 6}
testSet2 = {3, 4, 5, 6, 7, 8}

for i in range(10):
    print(f"{i} is in the set" if i in testSet1 else f"{i} is not in the set")

testSet1.add(7)
print(testSet1)

print(testSet1.intersection(testSet2))
print(testSet2.intersection(testSet1))

print(testSet1.difference(testSet2))
print(testSet2.difference(testSet1))

print(testSet1.union(testSet2))