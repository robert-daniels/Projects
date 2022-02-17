#gold room branches and functions

#import modules

from sys import exit

#gold room fx

def gold_room():
    """Branch that determines live/die based on taking over or under 50"""
    print("this room is full of gold. how much do you take?")

    #def fxvaribale

    choice = input("> ")

    #branch 1
    if "0" in choice or "1" in choice:
        how_much = int(choice)
    else:
        dead("Man, learn to type a number.")

    #branch 2
    if how_much < 50:
        print("Nice, you're not greedy, you win!")
        exit(0)
    else:
        dead("You greedy bastard! *Bang*")
#bear room fx

def bear_room():
    """makes a bear room with branches that determine live/die based on decision"""
    print("""There is a bear here.\nThe bear has a bunch of honey.\nHe's
in front of another door.\nHow are you going to move the bear?\n""")

    #start point
    bear_moved = False

    while True:
        choice = (input("1. Take Honey\n2. Taunt Bear\n3. Open door?"))

        if choice == "honey":
            dead("The bear slaps your face off.")
        elif choice == "taunt" and not bear_moved:
            print("the bear is moved, you can go through door")
            bear_moved = True
        elif choice == "taunt" and bear_moved:
            dead("the bear chewed your leg off.")
        elif choice == "open" and bear_moved:
            gold_room()
        else:
            print("I got no idea what that means.")
#cthulu room fx
def cthulu_room():
    """makes a cthulu room that you basically lose no matter what"""
    print("""here you see the great evil Cthulu.\nHe,it,whatever stares at you
    and you go insane.\nDo you 1.flee for your life or 2.eat your head?""")

    choice = (input("> "))

    if "flee" in choice:
        start()
    elif "eat" in choice:
        dead("well that was tasty")
    else:
        cthulu_room()

#define dead fx

def dead(why):
    print(why, "Good Job!")
    exit(0)

def start():
    print("""You are in a dark room.\nThere is a door to your right and\n
left.Which one do you take?""")

    choice = input("> ")

    if choice == "left":
        bear_room()
    elif choice == "right":
        cthulu_room()
    else:
        dead("you stumble round the room until you starve")

start()
