#using the \ to escape. I'm assuming this very useful in certian situations

#assign variables

tabby_cat = "\tI'm tabbed in." #i think this will tab over one
persian_cat = "I'm split\non a line."
backslash_cat = "im \\ a \\ cat."

fat_cat = '''
I'll do a list:
\t* Cat food
\t* Fishies
\t* Catnip\n\t* Grass
'''

#output

print(tabby_cat)
print(persian_cat)
print(backslash_cat)
print(fat_cat)
