

'''week 3 review'''


myTuple = (1, 2, 3, "a", "Boy")

print(f"The length of myTuple is {len(myTuple)}")

print(f"elements 2 to 4 are {myTuple[1:4]}")

print(f"last element is {myTuple[-1]}")


#cant add new element to tuple, so need to convert to a mutable data type

tempList = list(myTuple)
tempList.append("added")
myTuple = tuple(tempList)

print(f"myTuple has had a value added, see? {myTuple}")

myList = [1, 1.0, "one", "true"]

print(f"myList is {myList}")

myList.append("addLast")
myList.insert(3, "addedThird") #TODO remember the syntax for this, it's index then object
myList.pop(1)

print(myList)


def listSort(i):
    '''tries to convert the items to int, if it cant be converted, it's a non-numeric and should sort after numbers '''
    try:
        ele = int(i)
        return (0, ele, '')
    except:
        return (1, i, "")

myList.sort(key=listSort, reverse = True) # reversed, so now numbers should be after words 

print(myList)


myDict = {
            101: "Math",
            105: "mMsic",
            108: "Spanish"
}

print(f"the keys of myDict are {myDict.keys()}")
print(f"the values of myDict are {myDict.values()}")


for i in myDict.keys:
    i += 100

print(myDict)