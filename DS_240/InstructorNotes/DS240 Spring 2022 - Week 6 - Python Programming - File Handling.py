# ======================================= 
# WEEK 6 - HANDS ON - FILE I/O OPERATIONS
# ======================================= 

# ------------------------------------
# OPEN EXISTING FILE IN READ ONLY MODE
# ------------------------------------

#!/usr/bin/python3

# open existing file in read only mode
# --------------------------------------
myfile1 = open("C:/python/fruits.txt","r")

# display file mode
# -------------------
print(myfile1.mode)

# read content of entire file
# -----------------------------
myfile1.read()

# read first 3 char of file
# ---------------------------
myfile1.read(3)

# reset pointer to beginning of file
# ------------------------------------
myfile1.seek(0)

# shows pointer location of file
# --------------------------------
myfile1.tell()

# reads file line by line, for each call
# ----------------------------------------
myfile1.readline() # read first line
myfile1.readline() # read second line
myfile1.readline() # read third line

# reads all lines from file,in iterative mode
# ---------------------------------------------
myfile1.readlines()  
 
# reads all lines from file,
# prints if line starts with "A"
# --------------------------------
for line in myfile1.readlines(): 
	if line.startswith("A"):
		print(line)

# close file when done
# ----------------------
myfile1.close()

# check if file is closed
# -------------------------
print(myfile1.closed)

# ---------------------------------
# OPEN FILE IN APPEND OR WRITE MODE
# ---------------------------------

# open existing file in append mode
# -----------------------------------
myfile2 = open("C:/python/fruits.txt","a")
myfile2.writelines("Cherries") 

myfile2.seek(0)
myfile2.read()
myfile2.close()

# -----------------------------------------
# CAUTION: if existing file is opened  
# in write mode,it will overwrite content
# -----------------------------------------

#check content of file
# ----------------------
myfile3 = open("C:/python/fruits1.txt","r")
myfile3.read()
myfile3.close()

#overwrite content of file
# --------------------------
myfile4 = open("C:/python/fruits1.txt","w")
myfile4.writelines(["Grapes ", "Mango ", "Papaya "]) 
myfile4.close()

#check content of file
# ----------------------
myfile5 = open("C:/python/fruits1.txt","r")
myfile5.read()
myfile5.close()

# -----------------------------------
# How to avoid overwriting content  
# in existing file
# -----------------------------------

# create new file in write mode
# -------------------------------
myfile6 = open("C:/python/animals.txt","w")
myfile6.close()

# create new file in write mode, only if
# file with same name does not exist (safe)
# -----------------------------------------
myfile7 = open("C:/python/animals.txt","x")
myfile7.close()

# ---------------------------------
# OPEN FILE IN WRITE AND READ MODE
# ---------------------------------
 
# create new file in write mode
# -------------------------------
myfile8 = open("C:/python/vegetables.txt","w+") 

myfile8.write("Carrot")

# read after writing to new file
# -------------------------------
myfile8.seek(0)
myfile8.read()
myfile8.close()

# =================================================================






