# ================================================================= 
# WEEK 6 - HANDS ON - PYTHON SETS
# ================================================================= 

# ---------------------
# CREATING & USING SETS
# ---------------------

#!/usr/bin/python3

# create list
# -------------
mylist1 = [9, 2, 3, 6, 3, 2, 7, 3]
type(mylist1)
print(mylist1)

# create set from mylist1
# -------------------------
myset1 = set(mylist1)
type(myset1)
print(myset1)

# create set directly
# ---------------------
myset2 = {21, 22, 23, 24, 25, 25, 25, 21}
type(myset2)
print(myset2)

# find length of sets
# ---------------------
len(myset1)
len(myset2)

# test if value exists in set
# -----------------------------
21 in myset2
35 in myset2
35 not in myset2

# add values to set
# -------------------
print(myset2)
myset2.add(26) 
print(myset2)

# remove values from set
# ------------------------
print(myset2)
myset2.remove(23)
print(myset2)

# ------------------------
# SET METHODS & OPERATIONS
# ------------------------

myset3 = {11, 12, 13, 14}
myset4 = {13, 15, 18}

# find common values
# --------------------
myset3.intersection(myset4)
myset4.intersection(myset3)

# find differences
# ------------------
myset3.difference(myset4)
myset4.difference(myset3)

# union of unique values
# ------------------------
myset3.union(myset4)

# remove values from set
# ------------------------
print(myset3)
myset3.pop()
print(myset3)

# clear all values from set
# ---------------------------
print(myset4)
myset4.clear() 
print(myset4)

# ------------------------
# FROZEN SETS
# ------------------------

# create lists
# --------------
list1 = [31, 32, 33, 34]
list2 = [33, 34, 37]

# create frozensets from lists
# ------------------------------
fs1 = frozenset(list1) 
fs2 = frozenset(list2)

type(fs1)

print(fs1)
print(fs2)

# try changing values in frozensets
# -----------------------------------
fs1.add(30)
fs1.remove(31)
fs1.pop()
fs1.clear()

# ------------------------------
# FROZENSET METHODS & OPERATIONS
# ------------------------------

# find common values
# --------------------
fs1.intersection(fs2)
fs2.intersection(fs1)

# find differences
# ------------------
fs1.difference(fs2)
fs2.difference(fs1)

# union of unique values
# ------------------------
fs1.union(fs2)

# =================================================================






