#more practice with fxs and importing before moving on. working with the python interpreter


#define a buncho fxs

"""this function will break up words for us into --a list--"""

def break_words(stuff):
    words = stuff.split(' ')
    return words


def sort_words(words):
    """sorts the words, builds a -new- list"""
    return sorted(words)



def print_first_word(words):
    """pulls off first word of string and prints it.
    pop(x) where x is the list position, zero indexed"""
    word = words.pop(0)
    print(word)



def print_last_word(words):
    """same, except it runs relative backwards using -1"""
    word = words.pop(-1)
    print(word)



def sort_sentence(sentence):
    """takes a sentence and re-arranges it sorted. Calls on previous fxs"""
    words = break_words(sentence)
    return sort_words(words)



def print_first_and_last(sentence):
    '''prints first and last words of the sentence'''
    words = break_words(sentence)
    print_first_word(words)
    print_last_word(words)




def print_first_and_last_sorted(sentence):
    '''sorts the words , then prints the first and last one.'''
    words = sort_sentence(sentence)
    print_first_word(words)
    print_last_word(words)
