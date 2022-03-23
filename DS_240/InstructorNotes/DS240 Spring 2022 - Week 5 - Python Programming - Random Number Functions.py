# ================================================== 
# WEEK 5 - HANDS ON - PYTHON RANDOM NUMBER FUNCTIONS
# ================================================== 

# -----------------------------
# Random - random() Method
# -----------------------------

#!/usr/bin/python3 

import random

random.random()

# -----------------------------
# Random - choice() Method
# -----------------------------

import random 

print (“random value from range: ", random.choice(range(50)))

mylist = [1, 3, 5, 7, 9]
print ("random value from mylist : ", random.choice(mylist))

mystring = ‘Summer Time’
print ("random char from mystring: ", random.choice(mystring))

# -----------------------------
# Random - randrange() Method
# -----------------------------

import random

# randomly select nbr between 1-1000 step value 1
print ("randrange value: ", random.randrange(1, 1000, 1))


# randomly select nbr between 1-100 step value 2
print ("randrange value: ", random.randrange(1, 100, 2))


# randomly select an odd number between 1-50 step value 3
print ("randrange value: ", random.randrange(1, 50, 3))


# randomly select a number between 0-25
print ("randrange value: ", random.randrange(25)) 	 

# -----------------------------
# Random - shuffle() Method
# -----------------------------

import random

mylist = [2, 4, 6, 8, 9]

random.shuffle(mylist)
print ("Reshuffled list : ", mylist)

random.shuffle(mylist)
print ("Reshuffled list : ", mylist)
	 
# -----------------------------
# Random - uniform() Method
# -----------------------------

import random

print ("Random Float value : ",	random.uniform(5, 9))

print ("Random Float value : ",	random.uniform(10, 14))

# =================================================================






