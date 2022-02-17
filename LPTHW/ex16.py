#reading and writing files

#call argv feature from sys package

from sys import argv

#unpack argv
script, filename = argv

#user interaction
print(f"we;re going to erase {filename}.")
print("If you dont want that, hit CTRIL-C (^C).")
print("if you do want that, hit RETURN.")

#this isn't assigned to a variable? but im thinking the cntrl c or return are shell commands
#update, yep, they are. cntrl-c looks ugly though
input("?")

#makes a file object of filename, calls 'w' to let comp know to write, assigns object to variable
print("Opening the file...")
target = open(filename, 'w')

#calls truncate on file object to delete contents
#print("Truncating the file. Goodbye!")
#target.truncate()

#more user interaction to get 3 new lines, assigns to variables to call

print("Now imma need to put some new stuff in the file")

line1 = input("line 1: ")
line2 = input("line 2: ")
line3 = input("line 3: ")

#calls file object and uses the .write function, passed the new variables as arguments,
#to write to the file

print("I'm going to write these to the file now.")

target.write(line1)
target.write("\n")
target.write(line2)
target.write("\n")
target.write(line3)
target.write("\n")

#close file, I'm going to need to remember to do this
print("and finally, we close it.")

target.close()
