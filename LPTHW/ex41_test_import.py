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
