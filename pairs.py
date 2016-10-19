 #uses a recursive function to count the number of pairs of repeated characters in a string. Pairs of characters cannot overlap. 
 # Steffi Baumgart
 # 1 May 2015
  
def main():
  message = input("Enter a message: \n")
  print("Number of pairs: " + pair(message, 0)) 
    
def pair (message, count):

  if len(message) < 2:
    return str(count)
  
  char = message[0]
  
  if message[0] == message[1]:
    count+=1
    return pair(message[2:], count)
   
  else: return pair(message[1:], count)

 
if __name__ == "__main__":
    main()
 