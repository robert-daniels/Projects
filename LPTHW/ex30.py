#if and elif, blocks of code

#define variables with input to practice

people = int(input("People?: "))
cars = int(input("Cars?: "))
trucks = int(input("Trucks?: "))


#if else statements

#block1
if cars > people:
    print("We should take the cars.")
elif cars < people:
    print("we should not take the cars.")
else:
    print("We cant decide")

#block2
if trucks > cars:
    print("thats too many trucks")
elif trucks < cars:
    print("Maybe we could take the trucks.")
else:
    print("We still cant decide")

#block3
if people > trucks:
    print("Alright, lets just take the trucks.")
else:
    print("fine, let's stay home then.")
