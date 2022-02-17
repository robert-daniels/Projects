#practice opening and reading file again

#modules

from sys import argv

#unpack argv

script, filename = argv

#assign folder object to variables

txt = open(filename)

#output with f string

print(f"here's your file {filename}: " )
print(txt.read())

#get input from user to do same something, just not from argv

print("type the file again: ")
fileagain = input("> ")

txtagain = open(fileagain)

print(txtagain.read())
