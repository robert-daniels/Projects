# ================================================================= 
# WEEK 5 - HANDS ON - PYTHON LOOPS
# ================================================================= 

# -----------------------------
# PYTHON - WHILE LOOP
# -----------------------------

#!/usr/bin/python3

count = 0

while (count < 9):

	print ('The count is:', count)
	count = count + 1

print ("Good bye!")

# ====

count = 0

while (count < 9):

	print ('The count is:', count)

print ("Good bye!")

# ====
# Using else Statement with Loops
# ====

count = 0

while count < 5:

	print (count, " is	less than 5")
	count = count + 1

else:
	print (count, " is not less than 5")

# -----------------------------
# PYTHON - FOR LOOP
# -----------------------------
#!/usr/bin/python3

city = ["Olathe", "Leawood", "Shawnee"]
for x in city:
  print(x)

for x in "Kansas City":
  print(x)

city = ["Olathe", "Leawood", "Shawnee"]
for x in city:
  print(x)
  if x == "Leawood":
    break

city = ["Olathe", "Leawood", "Shawnee"]
for x in city:
  if x == "Leawood":
    continue
  print(x)

# -----------------------------
# PYTHON - NESTED LOOP
# -----------------------------
#!/usr/bin/python3

i = 0
while(i < 5):
   print("inside I loop", i)

   j = 1
   while (j <= 3):
    print("..........inside J loop", j)
    j = j + 1
   
   i = i + 1

print("Good bye!")

# =================================================================






