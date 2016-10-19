# Recursion: to find all palindromic isPrimes betw/ 2 ints N, M
#(start and end points are included)
# Steffi Baumgart
# 1 May 2015

import sys
import math 
sys.setrecursionlimit (30000)

    
def main():
    N = eval(input("Enter the starting point N:\n"))
    M = eval(input("Enter the ending point M:\n"))
    print("The palindromic primes are: ")
    isPalindromicPrime(N, M)

def isPrime(integer,k):
    
    if integer == 1:
        return False    
    
    #if integer == 2 or integer == 3:
        #return True
    
    if integer%2 == 0:
        return False
    
    elif integer%k == 0:
        return False    
    
    elif k >= (math.sqrt(integer)+1)//1:
        return True
    
    else:
        return isPrime(integer, k+1)       
    
def isPalindromicPrime(N, M):
    
    if N > M:
        return    
    
    #Check if palindromic
    if str(N) == reverse(str(N)): 
        #Check if prime
        if isPrime(N,2):
            print(N)
            return isPalindromicPrime(N+1, M)
            
        if isPrime(N,2) == False:
            return isPalindromicPrime(N+1, M)
        
        else:
            return isPalindromicPrime(N+1, M)


def reverse(string):
    if string == "":
        return string
    else:
        return reverse(string[1:]) + string[0]    
        
        
if __name__ == "__main__":
    main()
