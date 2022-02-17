#learning arguments, parameters, unpacking, variables.

#direct transcription, cant explain what this is yet
#update: from the -system- import argument variables

from sys import argv

#unpack argument variables and assign them.
#there has to be enough variables for the script
#the argv is given 4 sockets, it needs four or it fatals
#you also can't give the system too many variables for sockets. 

script, first, second, third = argv

#output

print("The script is called: ", script)
print("your first variable is: ", first)
print("your second variable is: ", second)
print("Your third variable is: ", third)
