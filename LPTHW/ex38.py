#doing things to lists

#initial test variable to split into a list later

ten_things = "Apples Oranges Crows Telephone Light Sugar"

print(ten_things)

print("Wait, there aren't 10 separate things in that list. Let's fix it")

#split the string into a list, delineated by space
stuff = ten_things.split(' ')
print(stuff)

#assign a list object
more_stuff = ["Day","night", "song", "girl", "frisbee",
"corn", "banana", "girl", "boy"]

#while loop, keep adding things to stuff list until its length gets to 10 things

while len(stuff) != 10:
    #pops off last item in list
    next_one = more_stuff.pop()
    print("Adding: ", next_one)
    stuff.append(next_one)
    print(f"There are {len(stuff)} items now.")


print("there we go: ", stuff)

print("lets do some things with stuff.")

#picks out of list given cardinal number
print(stuff[1])
print(stuff[-1])

print(stuff.pop())

print(' '.join(stuff))

print('#'.join(stuff[3:5]))
