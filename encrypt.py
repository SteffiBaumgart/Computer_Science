# Recursion: encrypts a message by converting all lowercase chars to the next char
#(with z transformed to a)
# Steffi Baumgart
# 1 May 2015


def main (): 
 #letters = "abcdefghikklmnopqrstuvwxyz" 
 #intab = "abcdefghijklmnopqrstuvwxyz"
 #outtab = "bcdefghijklmnopqrstuvwxyza"
 #trantab = maketrans(intab,outtab)

 #newletters = letters[1:] + letters[1:]
 #return message.translate(message.maketrans(letters,newletters))
 
 message = input("Enter a message: \n")
 print("Encrypted message: \n" + encryption(message)) 

def encryption(message): 
 if message == "":
  return message 
 
 #Change to A if Z
 if (ord(message[0])) == 122:                    
  return  "a"+encryption(message[1:]) 
 
 #Move up one letter in the alphabet 
 if 97<=ord(message[0]) and ord(message[0])<122:
  return chr(ord(message[0])+1)+encryption(message[1:])
 
 else:
  return message[0] + encryption(message[1:]) 

if __name__ == "__main__":
 main()
 