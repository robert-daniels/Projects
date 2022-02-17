#the return functionality of functions

#define functions

def add(a,b):
    #doesn't actually do the math, just tells user what it's going to do
    print(f"Adding {a} + {b}!")
    #return this when evaluated
    return a + b

def subtract(a,b):
    print(f"subtracting {a} - {b}!")
    return a - b

def multiply(a, b):
    print(f"multiplying {a} * {b}!")
    return a * b

def divide(a, b):
    print(f"dividing {a} / {b}!")
    return a / b

#output

print("let's do some math with just functions!")

age = add(30,5)
height = subtract(78,4)
weight = multiply(90, 2)
iq = divide(100,2)

print(f"Age: {age}, Height: {height}, Weight: {weight}, IQ: {iq}")

#Extra credit, but I'm running out of time to do this by hand today

print("Here is a puzzle.")

what = add(age, subtract(height,multiply(weight, divide(iq,2))))

print("The becomes: ", what, "can you do it by hand? Nah")
