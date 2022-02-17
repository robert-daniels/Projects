#more printing exercise using fstrings. he really likes fstrings

#assign variable

formatter = "{} {} {} {}"

#output

print(formatter.format(1,2,3,4))
print(formatter.format("one", "two", "three", "four"))
print(formatter.format(True, False, False, True))
print(formatter.format(formatter, formatter, formatter, formatter))
print(formatter.format("try your", "own text here", "Maybe a poem", "or a song about fear"))


#if I put 5 sockets in the string,and only pass 4 arguments to the format fx,
#it fatal errors because it tries to format the socket but doesn't have data
#the function is zero indexed
