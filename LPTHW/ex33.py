#while loops

#create global variable and list object

numbers = []
input_number = int(input("Pick a #, preferably on the smaller side > "))
increment = int(input("Go up by how much? "))

#while loop fx
def fx_loop(input_number, increment):
    """incrementally adds numbers to an empty list object until it hits the
    input number, does not include the input number"""
    i = 0
    while i < input_number:
        print(f"At the top i is {i}")
        numbers.append(i)
        i += increment
        print("The list now: ", numbers)
        print(f"At the bottom i is {i}.")

fx_loop(input_number, increment)

print("The numbers: ")

#for loop

for num in numbers:
    print(num)
