#child method overrides parent class

#define parent class

class Parent(object):

    #define method

    def override(self):
        print("Parent override()")

#define child class

class Child(Parent):

    def override(self):
        print("CHILD override()")

#build instances of classes

dad = Parent()
son = Child()

dad.override()
son.override()
