#practice with format strings and text


#assign variables

types_of_people = 10
x = f"There are {types_of_people} types of people."
binary = "binary"
do_not = "don't"
y = f"Those who know {binary} and those who {do_not}."


#output

print(x)
print(y)

print(f"I said: {x}")
print(f"I also said: '{y}")

#make new variable

hilarious = False
joke_evaluation = "Isn't that joke so funny?! {}"

#prints joke_evaluation and also converts the string to an fstring -and-
#passes it the hilarious parameter

print(joke_evaluation.format(hilarious))

w = "This is the left side of..."
e = "a string with a right side."

print(w+e)
