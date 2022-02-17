#oop hack script

#import modules
import random
from urllib.request import urlopen
import sys

#set variable of url. it -looks- like just a list of words on the website.

WORD_URL = "http://learncodethehardway.org/words.txt"

#makes an empty list object

WORDS = []

#make a dictionary

PHRASES = {
    "class %%%(%%%): ":
    "make a class named %%% that is-a %%%",

    "class %%%(object):\n\tdef __init__(self,***)":
    "class %%% has-a __init__ that takes self and *** parameters.",

    "class %%%(object): \n\tdef ***(self, @@@)":
    "class %%% has-a function *** that takes self and @@@ params.",

    "*** = %%%()": "Set *** to an instance of class %%%.",

    "***.***(@@@)": "From *** get the *** function, call it with params self, @@@",

    "***.*** = '***'": "From *** get the *** attribute and set it to '***'"
}

#dril phrase first? if statement that gets info from argv

if len(sys.argv) == 2 and sys.argv[1] == "english":
    PHRASE_FIRST = True
else:
    PHRASE_FIRST = False

#load words from website. be very careful if not a trusted source.
#calls .readlines method built intil urlopen, appends the words into the empty
#list object above, stripping of whitespace, using utf-8 encoding

for word in urlopen(WORD_URL).readlines():
    WORDS.append(str(word.strip(),encoding="utf-8"))

def convert(snippet, phrase):
    class_names = [w.capitalize() for w in
                    random.sample(WORDS,snippet.count("%%%"))]
    other_names = random.sample(WORDS, snippet.count("***"))

#makes new empty list objects

    results = []
    param_names = []


#for loop

    for i in range(0, snippet.count("@@@")):
        param_count = random.randint(1,3)
        param_names.append(','.join(random.sample(WORDS, param_count)))

    for sentence in snippet, phrase:
        result = sentence[:]

#fake class_names

    for word in class_names:
        result = result.replace("%%%", word, 1)

        #fake other names

    for word in other_names:
        result = result.replace("***",word, 1)

        #fake param lists

    for word in param_names:
        result = result.replace("@@@",word,1)

    results.append(result)

    return results


    #keep going until hit ctrl-d.
    ## FIXME: something wrong line 98. its wanting 2 variables, only getting 1.
"""
try:
    while True:
        snippets = list(PHRASES.keys())
        random.shuffle(snippets)

        for snippet in snippets:
            phrase = PHRASES[snippet]
            question, answer = convert(snippet, phrase)
            if PHRASE_FIRST:
                question, answer = answer, question

            print(question)

            input("<")

            print(f"Answer: {answer}\n\n")

except EOFError:
        print("\nBye")
"""
