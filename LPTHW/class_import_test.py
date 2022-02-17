#going to see if i can import a class

import sys

sys.path.append(".")

from ex41_test_import import car

test_car = car("x", "y", "z")

test_car.print_out()
