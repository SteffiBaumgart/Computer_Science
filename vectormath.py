# Basic vector calculations in 3 dimensions: addition, dot product and normalization.
# Steffi Baumgart
# 20 April 2015

import math 

a = str(input("Enter vector A:\n"))
b = str(input("Enter vector B:\n")) 

A = a.split()
B = b.split()

#A+B
AplusB = "["+str(eval(A[0])+eval(B[0]))+", "+str(eval(A[1])+eval(B[1]))+", "+str(eval(A[2])+eval(B[2]))+"]"
print("A+B =", AplusB)

#A.B
AdotB = (eval(A[0])*eval(B[0])) + (eval(A[1])*eval(B[1])) + (eval(A[2])*eval(B[2]))
print("A.B =", str(AdotB)) 

#Norm of A
normA = (eval(A[0])**2)+(eval(A[1])**2) +(eval(A[2])**2)
NA = round(math.sqrt(normA),2)
print("|A| =","{:.2f}".format(NA))

#Norm of B 
normB = (eval(B[0])**2)+(eval(B[1])**2) +(eval(B[2])**2)
NB = round(math.sqrt(normB),2)
print("|B| =","{:.2f}".format(NB))


