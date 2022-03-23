# ================================================================= 
# WEEK 5 - HANDS ON - PYTHON FUNCTIONS
# ================================================================= 

# -------------------------------------
# CREATING & CALLING FUNCTIONS
# -------------------------------------

#!/usr/bin/python3

# create function

def printing( str ):
 	"Printing string passed into this function"
	print (str)
	return

# call function

printing("My first user defined function, cool !")
 
printing("Ice Cream Sandwich, I love it !")

# ====

def my_function(name):
  print("Hello " + name )

my_function("James")
my_function("Mary")
my_function("Mickey") 

# ====

def my_function(city = "Kansas City"):
	print(" City Name is : "+ city)
	
my_function("Boston")
my_function("Chicago")
my_function() 

# ====

def my_food(food):
  for x in food:
    print(x)
    
lunch = ["cookies", "apple pie", "coke"]

my_food(lunch)

# ====

def five_times(x):
  return 5 * x
  
print(five_times(3))
print(five_times(5))
print(five_times(9))

# ====

def employee_info( name, age ):
	print ("Name: ", name) 
	print ("Age: ", age) 
	return

employee_info( "Joe",50 )
employee_info( 50,"Joe" )
employee_info( age=50, name="Joe" )

# =================================================================






