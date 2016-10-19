# Assists with debugging Python programs
# Steffi Baumgart
# 9 May 2015

#REMOVE trace statement
def remove(filename):
 new = [] 
 f = open(filename, "r")
 for line in f:
  if line.find(debug) < 0:
   new.append(line)
   
 f.close()
   
 p= open(filename, "w") 
 p.writelines(new)
 p.close()
 
 
#INSERT trace statement
def insert(filename):
 new = [] 
 debug = "\"\"\"" + "DEBUG" + "\"\"\""
 f = open(filename, "r") 
 new.append(debug +"\n")
 
 for line in f:
  new.append(line)
  if line.find("def") >= 0:
   function = line[line.find("def")+4:line.find("(")]
   new.append("    "+ debug +";print('"+function+"')"+"\n")
 f.close()
   
 p= open(filename, "w") 
 p.writelines(new)
 p.close()
 
def main():
 debug = "\"\"\"" + "DEBUG" + "\"\"\""
 filename = input("***** Program Trace Utility *****\nEnter the name of the program file: ")
 filename = (filename)
 file = open (filename,"r")
 
 if debug in file.readline():
  print("Program contains trace statements")
  remove(filename)
  print("Removing...Done")   
  
  
 else:
  insert(filename)
  print("Inserting...done") 
  
if __name__ == "__main__":
 main()
 
 
