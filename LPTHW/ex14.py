#prompting and passing

#import module

from sys import argv

#unpack argv

script, user_name = argv

prompt = '> '

#get input from user, user has already provided their username from the system

print(f"Hi {user_name}, I'm the {script} script.")

print("I'd like to ask you a few questions.")

print(f"First, are you a boy or a girl or an experience?")
likes = input(prompt)

print(f"whats the name of your rival {user_name}?")
lives = input(prompt)

print("do you pick bulbasaur, charmander, or squirtle? (hint, theres a right answer)")
computer = input(prompt)

print(f"""Alright, so you said you're a(n) {likes}. Your rivals name is {lives}.
Heh, {lives}. And you picked {computer}? Correct choice""")
