#composition

#define class1

class Other(object):

    def override(self):
        print("Other override fx")

    def implicit(self):
        print("Other implicit fx")

    def altered(self):
        print('Other altered fx')


#define class2

class Child(object):

    def __init__(self):
        self.other = Other()

    def implicit(self):
        self.other.implicit()

    def override(self):
        print("CHILD override fx")

    def altered(self):
        print("CHILD, BEFORE OTHER ALTERED FX")
        self.other.altered()
        print("CHILD, AFTER OTHER ALTERED FX")

#build instance of class 2
son = Child()

son.implicit()
son.override()
son.altered()
