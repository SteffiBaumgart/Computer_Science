# Prints the calendar for the month
# Steffi Baumgart
# 23 March 2015

output = "" # String to store the output for each line in the calendar
month = str(input("Enter the month ('January', ..., 'December'): "))
day = str(input("Enter the start day ('Monday', ..., 'Sunday'): "))
print(month) 

print("Mo Tu We Th Fr Sa Su") 

# Check the number of days in the month
if month in ["January", "March", "May", "July", "August", "October", "December"]:
    num_days = 31
elif month == "February":
	num_days = 28
        
else: num_days = 30

# Print whitespace before the first row of numbers
if day == "Monday":
	space = 0
if day=="Tuesday":
    space = 1

if day=="Wednesday":
    space = 2 
    
if day=="Thursday":
    space = 3 

if day=="Friday":
    space = 4 
    
if day=="Saturday":
    space = 5 

if day=="Sunday": 
    space = 6 
             
output = " "*3*space #" " is a single space

for i in range( 1, 7-space +1):
	output+= "{0:>2}".format(i)
	output+= " " #single space
output.rstrip()
print(output)
output = ""

# Print the numbers in the calendar    
for j in range (7-space+1, num_days+2, 7):
	for k in range(j, j+7):
		if (k>num_days):
			break
		output+= "{0:>2}".format(k)
		output+= " " #single space
		if (len(output)>20):
			break
	if (j>num_days):
		break
	output.rstrip()
	print(output)
	output = ""
   
    
