#introduction to fxs, fun!


#define fx

def print_two(*args) :
    arg1, arg2 = args
    print(f"arg1: {arg1}, arg2: {arg2}")

def print_two_again(arg1, arg2):
    print(f"arg1: {arg1}, arg2: {arg2}")

def print_one(arg1):
    print(f"arg1: {arg1}")

def print_non():
    print("I got nothin")


#output

print_two("zed", "shaw")
print_two_again("Robert", "Daniels")
print_one("First!")
print_non()
