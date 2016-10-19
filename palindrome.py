# Uses a recursive function to determine if a string is a palindrome
# Steffi Baumgart
# 1 May 2015

def main (): 
    string = input("Enter a string:\n")
    
    if Palindrome(string) == True: 
        print("Palindrome!")
    elif Palindrome(string) == False:  
        print("Not a palindrome!")
    
    
def Palindrome(string): 
 
    #BASE CASE: If string has only one letter (or) there is no string 
    if len(string) == 0 or len(string)== 1:    
        return True
    
    #if the first and last letters are not equal
    elif string[0] != string [-1]:
        return False
        
    #Returns the string minus the first and last letter    
    else:
        return Palindrome(string[1:-1]) 
    
 
if __name__ == "__main__":
    main()
