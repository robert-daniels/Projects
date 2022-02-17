#i want to test understanding by hand

from sys import argv

#unpack argv

script, testout, testin = argv

#make file object and assign to a variable

incoming_data = open(testout)
indata = incoming_data.read()

recfile = open(testin,"w")
test_write = recfile.write(indata)

incoming_data.close()
recfile.close()
