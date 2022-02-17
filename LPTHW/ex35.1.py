#ex35 branches and fxs again

#import modules

from sys import exit

#build the gold room

def gold_room():

    print("theres a room of gold here.\nHow much do you take?")
    choice = int(input("> "))

    if isinstance(choice, int):
        how_much = choice
    else:
        dead("Man, learn to type a number.")

    if how_much < 50:
        print("nice, not greedy. you win!")
        exit(0)
    else:
        dead("You greedy bastard! *bang*")


#build bear room

def bear_room():

    bear_moved = False

    print("there is a bear here.\n He has a bunch of honey.\nHe's in front of the door")
    print("how are you going to move the bear?")

    while True:
        choice = input("take honey, taunt bear, open door? > ")

        if choice == "take honey":
            dead("bear eats your face")
        elif choice == "taunt bear" and not bear_moved:
            print("the bear has moved from the door, you can go through.")
            bear_moved = True
        elif choice == "taunt bear" and bear_moved:
            dead("Bear is angry, chews your leg off.")
        elif choice == "open door" and bear_moved:
            gold_room()
        else:
            print("i got no idea what that means")


#built cthulu room

def cthulu_room():
    print("yep, thats cthulu. you insane now.")
    choice = input("flee or ear?> ")

    if "flee" in choice:
        start()
    elif "ear" in choice:
        dead("yeah, its actually cthulu. no wonder.")
    else:
        print("that wasn't a suggestion")
        cthulu_room()

#define the dead and start functions

def dead(why):
    print(why, "Good Job!")
    exit(0)

def start():
    print("You are in a dark room, door to right or left. which do you take?> ")
    choice = input("> ")

    if choice == "left":
        bear_room()
    elif choice == "right":
        cthulu_room()
    else:
        dead("You die of starvation.")

#get the game going by calling start

start()
