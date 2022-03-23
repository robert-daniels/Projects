# =======================================
# WEEK 6 - HANDS ON - PYTHON EXCEPTIONS
# =======================================

# -------------------
# DATA / LOGIC ERRORS
# -------------------

#!/usr/bin/python3

#ZeroDivisionError: division by zero
# ------------------------------------
a = 5
b = 0
c = a/b

# -----------------------
# HANDLING PROGRAM ERRORS
# -----------------------

print(x)

#Use Try & Except to handle error
# ---------------------------------
try:
  print(x)
except:
  print("An exception occurred")

x = 5

try:
  print(x)
except:
  print("An exception occurred")

#Use Try, Except, Finally - to handle error
# -------------------------------------------

print(y)

try:
  print(y)
except NameError:
  print("Variable y is not defined")
finally:
  print("I don't care, I'm getting printed either way!")

y = 3

try:
  print(y)
except NameError:
  print("Variable y is not defined")
finally:
  print("I don't care, I'm getting printed either way!")
