#makes a class library

class book(object):

    def __init__(self, title, author):
        self.title = title
        self.author = author

    def print_bookinfo(self):
        print(f"the book name is {self.title}, the book author is {self.author}")


class person(object):

    def __init__(self, name, career):
        self.name = name
        self.career = career

    def print_personname(self):
        print(f"the person's name is {self.name} and they do {self.career}.")

class textbook(book):

    def __init__(self, subject):
        self.subject = subject

    def print_subject(self):
        print(f"the subject is {self.subject}")
