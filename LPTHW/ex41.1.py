#test out class

class me(object):

    def __init__(self, height, weight):
        self.height = height
        self.weight = weight

    def print_out(self):
        print("my height is", self.height)
        print("me weight is", self.weight)

measurements = me(20, 30)

measurements.print_out()
