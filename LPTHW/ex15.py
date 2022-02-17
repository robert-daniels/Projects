#reading from a text file. exciting times!

#import module

from sys import argv

#unpack argv

script, filename = argv

#open() opens the parameter and returns a file object that can have cmds passed to it
#then assigns it to txt

txt = open(filename)

#output, this is the basic format string
print(f"here's your file {filename}: ")

#read the filename, return what's inside. then the print function just behaves
#normally, which makes me think the read() returns a string

print(txt.read())

#get input to do same thing.

print("type the filename again:")
file_again = input("> ")

txt_again = open(file_again)

print(txt_again.read())


#close file
txt.close()
txt_again.close()
