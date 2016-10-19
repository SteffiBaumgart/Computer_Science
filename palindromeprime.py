# Finding all palindromic primes between two integers 
# Steffi Baumgart
# 23 March 2015

N = eval(input("Enter the start point N:" +"\n"))
M = eval(input("Enter the end point M:" + "\n")) 
print("The palindromic primes are:")


#loop from M to N 
if (N < 2):
	N = 1
for i in range (N+1, M): 

#Check if Palindromic 
    revNum = str(i) 
    if revNum[::-1] == str(i): 
        
    #Check if Prime
        check = True 
        for k in range (2,i):
            if (i%k==0):
                check = False
            if (i==1):
                check = False 
            
        if check == True: 
            print(i)
            
                  
                
                
