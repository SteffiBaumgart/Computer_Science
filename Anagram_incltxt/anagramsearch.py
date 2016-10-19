# Searches a file for anagrams of a given word, printing the results in alphabetical order.
# Steffi Baumgart
# 9 May 2015

def main():
    
    print("***** Anagram Finder *****")
    
     
     
    try:
        wordList =  open('EnglishWords.txt', 'r').read()
        
    except: 
        print("Sorry, could not find file 'EnglishWords.txt'.") 
          
         
    else:     
        wordFreq={} 
        currFreq={} 
        wordList = [] 
        anagrams = [] 
        
        word = input("Enter a word: \n").lower()
        #Open File, read to string, convert to array: 
        wordList =  open('EnglishWords.txt', 'r').read() 
        wordList = sorted(wordList[wordList.find("START"):].split("\n"))

    #eliminating words of different lengths
   #every time an element is removed, the list gets smaller - bear this in mind
   #you can't use the 'for i in range' because the range changes (-> out-of-bounds errors otherwise)

        for i in wordList:
            if len(word) != len(i):
                wordList.remove(i)

        #building frequency table for given word
        for letter in word:
            if letter in wordFreq: 
                wordFreq[letter] += 1
            else:
                wordFreq[letter] = 1  
         

        for k in wordList: 
            
   #This dictionary HAS to be reinitialized for every new word

            currFreq = {}

            for letter in k:
                if letter in currFreq: 
                    currFreq[letter] += 1
                else:
                    currFreq[letter] = 1  
            
            if wordFreq == currFreq:
                anagrams.append(k)
                
            if k == word:
                anagrams.remove(k) 
         
                  
        anagrams.sort() 
    
    
        #if array "anagrams" is empty
        if not anagrams:
            print("Sorry, anagrams of " + "\'" + word +  "\'" + " could not be found.")
            
        else: 
            print(anagrams)


   
if __name__ == "__main__":
    main()
    
    