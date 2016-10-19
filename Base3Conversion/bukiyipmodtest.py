# test program for Bukiyip calculations

import bukiyip

print('**** Bukiyip test program ****')
print('Available commands:')
print('d <number> : convert given decimal number to base-3.')
print('b <number> : convert given base-3 number to decimal.')
print('a <number> <number> : add the given base-3 numbers.')
print('m <number> <number> : multiply the given base-3 numbers.')
print('q : quit')
print()

while True:
   choice = input ("Enter a command:\n")
   action = choice[:1]
   if action == 'q': 
      break
   elif action == 'b' or action == 'd':
      num = int(choice[2:])
      if action == 'b':
         print(bukiyip.bukiyip_to_decimal (num))
      else:
         print(bukiyip.decimal_to_bukiyip(num))
   elif action == 'a' or action == 'm':
      num1, num2 = map (int, choice[2:].split(" "))
      if action == 'a':
         print(bukiyip.bukiyip_add (num1, num2))
      else:
         print(bukiyip.bukiyip_multiply (num1, num2))
