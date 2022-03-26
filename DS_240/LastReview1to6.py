import random

myList = [1, 2, 'a', True]
print(myList)
print(len(myList))
print(myList[0])
print(myList[1:3])
print(myList[-1])

print(myList * 3)

myOtherList = [2,"two"]

newList = myList + myOtherList

print(newList)

newList.append("added")
newList.insert(1, "add1ind")
newList.extend(["two", 3])

print(newList)

newList.remove("two") # only removes one

for i in range(10):
    newList.append("two")

print(newList)

while "two" in newList:
    newList.remove("two")
    print(newList)
else:
    print(f"I've removed all 'two' recursive. The list is {newList}")


testDict = {
            101: "design",
            202: "art",
            303: "glass blowing"
}

print(testDict)

print("yes" if 105 in testDict else "no")

testDict[105] = "more art"

print(testDict)

mixedList = [1, 1.1, True, "one", "One", False] 

def trySort(i):
    try:
        intI = int(i) # would convert booleans into their num equivalents
        return (0, intI, "")
    except:
        return (1, i, "")

mixedList.sort(key=trySort)

print(mixedList)

randList = [1, 2, 5, 7, "r", "p"]
print(type(randList))

randResult = random.choice(randList)
print(randResult)

print(random.randrange(0, 25, 3))

random.shuffle(randList)

print(randList)

[print(i) for i in range(11)]

stateList = ["a", "b", "c"]

[print(i) for i in stateList]


print(stateList)

fileObject = open("testFile.txt", 'w+')

fileObject.write("apple\n")
fileObject.write("pear\n")
fileObject.write("bruce\n")

[fileObject.write(str(i) + "\n") for i in range(1000)]

print(fileObject.tell())
fileObject.seek(0)

[print(line, end="") if line.startswith("1") else "" for line in fileObject.readlines()]


fileObject.seek(0)

for line in fileObject.readlines():
    if str(line).startswith('1'):
        print(line)    

