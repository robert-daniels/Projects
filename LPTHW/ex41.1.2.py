class car(object):

    def __init__(self,make,model,year):
        self.make = make
        self.model = model
        self.year = year

    def print_car(self):
        print(f"so you have a {self.year} {self.make} {self.model}. Cool")

#GLOBAL VARIABLES!!
make = input("make: ")
model = input("model: ")
year = input("year: ")

your_car = car(make, model, year)

change_make = input("oops, you made a mistake? whats that actual make?")

your_car.make = change_make

print(your_car.make)

your_car.print_car()
