# Bukiyip Language (Base-3) 
# Steffi Baumgart
# 10 April 2015


#Convert a Bukiyip number to decimal.
def bukiyip_to_decimal(a):
    bukiyip = str(a)
    dec = 0
    
    for i in range(0, len(bukiyip)): 
        dec += 3**(len(bukiyip) - i - 1)* int(bukiyip[i])
    return int(dec)

#Convert a decimal number to a Bukiyip.
def decimal_to_bukiyip (a): 
    decimal = a  
    remainder = ""
    value = ""
                
    while (decimal != 0):
        remainder += str((decimal % 3))
        decimal = decimal // 3 
        
    if (decimal == 0):
        remainder += str((decimal % 3))    
         
    for i in range(len(remainder) - 1, -1, -1):
        value += remainder[i]         

    return int(value)         

#Add two Bukiyip numbers.
def bukiyip_add(a, b):
    value = int(bukiyip_to_decimal(a))+ int(bukiyip_to_decimal(b))
    return decimal_to_bukiyip(value)

#Multiply two Bukiyip numbers.
def bukiyip_multiply(a, b):
    value = int(bukiyip_to_decimal(a))*int(bukiyip_to_decimal(b))
    return decimal_to_bukiyip(value)



