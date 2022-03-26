myFile1 = open("H:\Projects-1\DS_240\Fruits.txt", "w+")

myFile1.write("apple\n")
myFile1.write("pear\n")
myFile1.write("pear\n")
myFile1.write("bruce wayne\n")

print(myFile1.mode)

fileContents = myFile1.read()

print(type(fileContents))

myFile1.seek(0)

file1char3 = myFile1.read(3)

print(file1char3)

myFile1.seek(0)

fruitList = []

# too cumbersome? probably. still just practicing that syntax

[fruitList.append(line) if 'a' in line else "" for line in myFile1.readlines()]

print(fruitList)

mySet = set(fruitList)

print(mySet)
