================================================================= 
WEEK 4 - HANDS ON - PYTHON DECISION MAKING
================================================================= 

Python assumes
-------------- 
a)	non-zero and non-null values as TRUE.
b)	zero or null values as FALSE.

-----------------------------
PYTHON - SIMPLE IF STATEMENTS
-----------------------------

#!/usr/bin/python3

var1 = 100

if var1:
	print (“var1 has value")
	print (var1)

==========

#!/usr/bin/python3

var2 = 0

if var2:
	print (“var2 has no value")
	print (var2)

print ("Good bye!")

-----------------------------
PYTHON - IF...ELSE STATEMENTS
-----------------------------
#!/usr/bin/python3

amt= input("Enter amount: ") 

# value entered in input statement is string
# hence, convert to integer as below
# discount is 5% if amount < 100, otherwise 10%

amount=int(amt) 

if amount<100:
	discount=amount*0.05		
	print ("Discount is : ",str(discount) )
else:
	discount=amount*0.10		 
	print ("Discount is : ",str(discount) )
	
due = amount – discount
	
print (“Amount Due : " + str(due) )

-----------------------------
PYTHON - ELIF STATEMENTS
-----------------------------

#!/usr/bin/python3

# execute below python code by assigning 
# different values for total

total = 75

if total >= 90:
	print (“Grade A")
elif total >= 80:
	print (“Grade B")
elif total >= 70:
	print (“Grade C")
elif total >= 60:
	print (“Grade D")
else: 
	print (“Fail")

-----------------------------
PYTHON - NESTED IF STATEMENTS
-----------------------------

#!/usr/bin/python3

num=int(input("enter number"))

if num%5== 0:
	if num%10== 0:
		print (“Divisible by 5 and 10")
    else:  
		print (“Divisible by 5 not 10")
else: 
	if num%10== 0:
		print (“Divisible by 10 not 5")
    else:  
		print (“Not Divisible by 10 and 5")

-------------------------------
PYTHON - SINGLE STATEMENT SUITE
-------------------------------

#!/usr/bin/python3

var = 5

if (var== 5): print("Value of variable is 5")

print ("This is single statement suite !")

=================================================================






