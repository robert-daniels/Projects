#more read write to files. a very important skill

#import features from packages

from sys import argv
from os.path import exists

#unpocks argv, must have 3 arguments !
script, from_file, to_file = argv

print(f"Copying from {from_file} to {to_file}")

#this could be one line, per book, writing out rote first

#assign variables to file objects

in_file = open(from_file)
indata = in_file.read()

#you can call a function inside the socket?!!?!

print(f"The input file is {len(indata)} bytes long")

#call the exists feature, need to look at pydoc

print(f"does the output file exist? {exists(to_file)}")

print("Ready, hit RETURN to continue, CTRL-C to abort.")

#halts script, lets user exit
input()

#makes new file object, 2 lines to 1 here too?

out_file = open(to_file, 'w')
out_file.write(indata)

print("alright, all done.")

#dont forget to close files!

out_file.close()
in_file.close()
