#try to import classes from a different file in same directory

import sys

sys.path.append(".")

from class_library import *

test_book = book("test title", "test author")

test_book.print_bookinfo()

test_person = person("test name", "test career")

test_person.print_personname()

test_textbook = textbook("chemistry")

test_textbook.print_subject()
