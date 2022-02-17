#inheritance, method defined in parent, not in child

#def parent class

class Parent(object):

#define a method
    def implicit(self):
        print("PARENT implicit()")

#create child class from parent

class Child(Parent):
    pass

#build instances from classes

dad = Parent()
son = Child()

#call method defined in parent on both.

dad.implicit()
son.implicit()
