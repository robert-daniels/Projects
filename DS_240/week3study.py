'''week 3 review'''

a = 99

list1 = [1, 1.0, a, "one", 9]
list2 = [2, 2, 2, 2]

list3 = list1 + list2

print(list3)

list3.append("addedEnd")

list3.insert(3,"inserted3rd") # insert before the third index (fouth element)

print(list3)

print(list3.index("one")) 
list3.remove(a)

print(list3)

print("one" in list3)

dict1 = {
        101: "Math",
        292: "Science",
        456: "Anatomy"
}

print(dict1)

print(dict1.keys())
print(dict1.values())

dict1[765] = "Glass Blowing"

print(dict1)

print(dict1[765])
print(tuple(dict1[765]))

x = '3'
int(x)

print(type(x))
print(type(int(x)))