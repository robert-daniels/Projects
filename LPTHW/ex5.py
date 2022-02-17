#learn about format strings. These are strings that the computer
#can format in situ using {}

name = "zed a. shaw"
age = 35 #not a lie
height = 74 #inches
weight = 180 # lbs
eyes = "blue"
teeth = "white"
hair = "brown"
height_cm = height * 2.54
#use format strings

print(f"Lets talk about {name}.")
print(f"He's {height} inches tall.")
print(f"That's {height_cm} cm tall!")
print(f"He's {weight} pounds heavy.")
print("Actually, thats not too heavy.")
print(f"He's got {eyes} eyes and {hair} hair.")
print(f"His teeth are usually {teeth} depending on the coffee.")

#comment on how this line is tricky

#assign variable
total = age + height + weight

print(f"If I add {age}, {height}, and {weight} I get {total}.")
