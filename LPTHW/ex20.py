#functions and files. basically practicing functions, and then also reviewing
#how we handled files. I may need to brush up on these again.


"""
This defines some functions that goes and pulls a file, then prints it out
a line at a time.
"""

#import modules

from sys import argv

#unpack argv

script, input_file = argv

#define the functions

def print_all(fileo):
    print(fileo.read())

def rewind(fileo):
    fileo.seek(0)


def print_a_line(line_count, f):
    print(line_count, f.readline())

#global variable! makes a file object

current_file = open(input_file)

#output

#notice the escape
print("Ok, First, let's print the whole file: \n")

#calls fx and passes it argument which is a global variable

print_all(current_file)

print("now let's rewind, kind of like a tape.")

rewind(current_file)

print("let's print three lines:")

#creates a gVariable , then runs functions

current_line = 1
print_a_line(current_line, current_file)

current_line += 1
print_a_line(current_line, current_file)

current_line += 1
print_a_line(current_line, current_file)
