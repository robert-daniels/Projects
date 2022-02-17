#for loops and lists

#define list objects

the_count = [1,2,3,4,5]
#store strings in a list
fruits = ['apples', 'oranges', 'pears', 'apricots']
change = [1, 'pennies', 2, 'dimes', 3, 'quarters']

#for loop goes through list, looks like number in this case is a variable assign

for number in the_count:
    print(f"this is count {number}.")

for fruit in fruits:
    print(f"a fruit of type: {fruit}.")

for i in change:
    print(f"i got {i}")


#make an empty list object

elements = []

#use range function to do 0 to 5 counts

for i in range(0,6):
    print(f"adding {i} to the list.")
    #calls function on the elements list object to append i
    elements.append(i)

for i in elements:
    print(f"Element was: {i}")
