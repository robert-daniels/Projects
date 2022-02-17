#making decisions

print("you enter a dark room with 2 doors. do you go through door 1 or 2?")

#get input on which doors in str format

door = input("> ")

#branch 1 if picked door 1

if door == "1":
    print("theres a giant bear eating a cheesecake.")
    print("What do you do? \n1. Take the Cake\n2.Scream at the bear?")

    #get input
    bear = input("> ")

    #second branch

    if bear == "1":
        print("the bear ate your face, good job, smart one")
    elif bear == "2":
        print("the bear eats your legs off. good job!")
    #needs an else, or it will hang with other input
    else:
        print(f"well doing {bear} is probably better, I guess.")
        print("bear runs away.")

#branch if door 2 is picked

elif door == "2":
    print("You stare into the endless abyss at cthulhu's retina.")
    print("1. Blueberries.\n2. Yellow Jacket Clothespins.\n3. Understanding revolvers yelling melodies")

    insanity = input("> ")

    if insanity == "1" or insanity == "2":
        print("you body survives powered by a mind of jello.")
        print("good job!")
    else:
        print("The insanity rots your eyes into a pool of muck.")
        print("Good job!")

#third branch

else:
    print("you stumble around and fall on a knife and die. gooooood job!")
