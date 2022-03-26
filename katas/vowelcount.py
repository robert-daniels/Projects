'''
Description:
Return the number (count) of vowels in the given string.

We will consider a, e, i, o, u as vowels for this Kata (but not y).

The input string will only consist of lower case letters and/or spaces.

'''

#my solution, trying the new syntax


def get_count(sentence):
    testList = ["a", "e", "i", "o", "u"]
    return sum(int(i in testList) for i in sentence)


#best solution

def bestSolution(sentence):
    return sum(char in "aeiou" for char in sentence)

print(bestSolution("aeiou"))

