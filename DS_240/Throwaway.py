from multiprocessing.reduction import duplicate


def duplicate_count(text):
    counter = 0
    checkText = text.upper()
    for char in checkText:
        if checkText.count(char) > 1:
           counter += 1
   
    return counter 

# overcounts
print(duplicate_count("abcdeaa"))

text = "ABCDEAA"

print(text.count('A'))