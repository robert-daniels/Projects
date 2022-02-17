#more practice with fxs and variables

#make a function

def cheese_and_crackers(cheese_count, boxes_of_crackers):
    print(f"you have {cheese_count}, cheeses!")
    print(f"You have {boxes_of_crackers} boxes of crackers!")
    print("Man, that's enough for a party!")
    print("Get a blanket. \n")

print("We can also just give fxs #'s directly: ")

#call fx script, which is just a bunch of print strings

cheese_and_crackers(20,30)

print("or, I'm getting fancy, gimme numbers")

#get input, sanitize it to integer format so when we call math on it it doesn't break

#these are global variables, and apply to the whole script. 

amount_of_cheese = int(input("How much cheese you got boo? > "))
amount_of_crackers = int(input("How many crackers, sonny? > "))

cheese_and_crackers(amount_of_cheese, amount_of_crackers)

print("We can even do math inside too! :")

cheese_and_crackers(10 + 20, 5 + 6)

print("and we can combine the two, variables and math: ")

cheese_and_crackers(amount_of_cheese + 100, amount_of_crackers +1000)
