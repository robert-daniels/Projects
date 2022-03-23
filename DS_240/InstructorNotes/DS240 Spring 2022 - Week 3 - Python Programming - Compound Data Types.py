# =================================================================
# WEEK 3 - HANDS ON - PYTHON COMPOUND DATA TYPES
# =================================================================

# ------------
# PYTHON LISTS
# ------------

mylist = [ 'xyz', 342 , 7.84, 'mary', 98.3 ]
shortlist = [980, 'jessy']

print (mylist)	            # print complete list
print (len(mylist))         # print number of elements

print (mylist[0])		    # first element only
print (mylist[1:3])	        # from second until third

print (mylist[2:])	        # from 3rd element
print (mylist[-1])	        # last element

print (shortlist)	        # print complete list
print (len(shortlist))      # print number of elements

print (shortlist * 3)	    # prints list 3 times
print (mylist + shortlist)  # prints concatenated lists

# ----------------------
# PYTHON LISTS - METHODS
# ----------------------

namelist = ['james', 'matt', 'bobby']

namelist.append('wade')    			## append elem at end
namelist.insert(1, 'joe')        	## insert elem at index 1

namelist.extend(['tom', 'peyton'])  ## add list of elems at end
print(namelist.index('matt'))    	## find index for matt

namelist.remove('wade')				## remove wade from list
namelist.sort()						## sort the list in asc order

namelist.reverse()					## sort the list in desc order
namelist.pop(1)						## remove item whose index is 1

# =================================================================

# -------------
# PYTHON TUPLES
# -------------

mytuple = ('xyz', 342 , 7.84, 'mary', 98.3)
shorttuple  = (980, 'jessy')

print (mytuple)	                # print complete tuple
print (len(mytuple))            # print number of elements


print (mytuple[0])		    	# first element only
print (mytuple[1:3])            # from second until third


print (mytuple[2:])	    		# from 3rd element
print (mytuple[-1])	    		# last element

print (shorttuple)	            # print complete tuple
print (len(shorttuple))        	# print number of elements


print (shorttuple * 3)	    	# prints tuple 3 times
print (mytuple + shorttuple)  	# prints concatenated tuple

# =================================================================

# -----------------
# PYTHON DICTIONARY
# -----------------

mydict = {'name': 'joe', 3: 'this is three', 'dept': 'design'}

print(mydict)	                 	# print complete dictionary

print(mydict['name'])	    		# value for 'name' key
print(mydict[3])	                # value for 3 key

print(mydict.keys())	    		# print all the keys
print(mydict.values())           	# prints all the values

mydict['hello'] = "hello hello"    	# append new key/value
mydict[100]	= "Century"  			# append new key/value

print(mydict.keys())	    		# print all the keys
print(mydict.values())           	# prints all the values

# =================================================================

# ---------------------------------------------------
# PYTHON DATA TYPE CONVERSIONS - COMPOUND DATA TYPES
# ---------------------------------------------------

my_tuple =(1,2,3,4,5,6,7,8,9,10)
my_list = [1,2,3,4,5]

tuple(my_list)
list(my_tuple)

# Convert a string into tuple

snacks = 'Cookie'
my_tuple = tuple(snacks)
print(my_tuple)

# Convert a string into list

my_list = list(snacks)
my_list.append('s')
print(my_list)

# =================================================================








