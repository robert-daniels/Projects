#practice before moving on
#printing and escapes, which is really just an extra \ that lets you do things in strings

print("lets practice everything.")
print('you\'d need to know \'bout escapes with \\ that do: ')
print('\n newlines and \t tabs.')

#assign a string to a variable

poem = """
\tThe lovely world with logic so firmly planted
cannot discern \n the needs of love
nor comprehend passion from intuition
and requires an explanation \n\t\twhere there is none.
"""

#print the variable

print("---------------------")
print(poem)
print("---------------------")

#doing math and format strings

five = 10 - 2 + 3 - 6
print(f"This should be five: {five}")

#def a fx that returns a list after they've been mathed

def secret_formula(started):
    jelly_beans = started * 500
    jars = jelly_beans / 1000
    crates = jars / 100
    return jelly_beans, jars, crates

#move back to global, call formula, and unpack the return

start_point = 10000
beans, jars, crates = secret_formula(start_point)

#alt way to format a string, call the format fx on it.

print('With a starting point of: {}'.format(start_point))
print(f"We'd have {beans} beans, {jars} jars, and {crates} crates.")

#calls variable, does math, updates variable
start_point = start_point / 10

print("we can also do that this way: ")
formula = secret_formula(start_point)
#something new, easy way to apply list to a format string. secret_formula returns a list
print("We'd have {} beans, {} jars, and {} crates.".format(*formula))
