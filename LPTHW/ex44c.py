#child interacts with parent

#define parent class

class Parent(object):

    def altered(self):
        print("PARENT function")

#define child class

class Child(Parent):

    #method
    def altered(self):
        print("child, before parent")
        #go into parent and run that version
        #go into the parent of child with arg self, run
        super(Child, self).altered()
        print("child, after parent")


#build instances

dad = Parent()
son = Child()

dad.altered()
son.altered()
