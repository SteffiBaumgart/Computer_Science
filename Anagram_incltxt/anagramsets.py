# Search file for group of words that are that length and are anagrams of each other
# Steffi Baumgart
# 9 May 2015 

def main(): 
    
    print("***** Anagram Set Search *****")
    length = eval(input("Enter word length:\n"))
    print("Searching...")
    fileName = (input("Enter file name:\n")) 
    print("Writing results...")
    
    #Ignore copywrite notice and read lines from file into array
    try:
        contents = open("EnglishWords.txt", "r").read()
        contents = sorted(contents[contents.find("START")+1:].split())
        print("Searching...")
        
    
        new = []
        for i in range(len(contents)):
            if len(contents[i]) == length:
                new.append(new[i])
                
        group = set({})
        newLength = len(new) 
        
        
        for k in range(newLength):
            j = sorted(list(new[k]))
            word = ""
            for l in range(len(j)):
                word += j[l]
            group.add(word)
        
        g = sorted(list(group))
        
        anagrams = []
        for j in range(len(g)):
            temp = []
            for k in range(newLength):
                if sorted(list(new[k])) == list(g[j]):
                    temp.append(new[k])
            temp.sort() 
            if len(temp)>1: 
                if temp is not anagrams:
                    anagrams.append(str(temp) +"\n")
                    
        anagrams.sort() 
        
        p = open(fileName,"w")
        p.writelines(anagrams) 
        p.close()  
                  
    
    except:
        print("Error")

        
if __name__ == "__main__":
    main()
    
