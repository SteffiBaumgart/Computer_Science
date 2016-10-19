# Translating to and from Pig Latin
# Steffi Baumgart
# 10 April 2015
sentList = [] 

    
#List of vowels 
vowels = ['a', 'e', 'i', 'o', 'u']     

#Return the Pig Latin sentence for a given English sentence.
def to_pig_latin(sentence):
    sent = "" 
    sentList = sentence.split()

    for k in sentList:
        if k[0] in vowels: 
            k += "way "
            sent += k
                
        else: 
            string = ""
            length = 0
            for i in k:
                if i not in vowels: 
                    length += 1
                    string += i
                else: break
            sent += k[length: len(k)] +  "a" + string + "ay " 
            
    length = len(sent)                
           
    return sent[0: length- 1]

        
#Return the English sentence for a given Pig Latin sentence.
def to_english(sentence):
    english = ""
    var = ""
    x = ""
    
    for a in sentence.split():
        length = len(a)
        temp = length - 3
        
        if(a[temp : length] == "way"):
            english += a[0: temp] + " "
        else:
            for i in a[temp: : -1]:
                if i in vowels:
                    break
                else:
                    temp -= 1
                    x += i
            var += x[::-1]
            var += a[0:temp]
            english += var + " "
            var = ""
            x = ""
    
    return english[0: len(english) - 1]

