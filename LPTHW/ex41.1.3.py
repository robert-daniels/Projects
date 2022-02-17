#more class practie, car entry again.

#define the parent car class with variables

class car(object):

#define how to initiate the class instance with attributes
    def __init__(self, make, model, year):
        self.make = make
        self.model = model
        self.year = year

    #define a method

    def print_out(self):
        print(f"your car is listed as a {self.year} {self.make} {self.model}")


#//class definition
make = input("Make of your car? ")
model = input("Model of car? ")
year = input("year of car? ")

user_car = car(make, model, year)


user_car.print_out()

change_make = input("Oh, you made a mistake on the model? what should it have been? ")
user_car.make = change_make

user_car.print_out()
