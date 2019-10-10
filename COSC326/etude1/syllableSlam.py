import fileinput
vowels = 'aeiouAEIOU'

# This assumes we are given a file containing lines consiting of one word each.
for xline in fileinput.input():
    # Formatting because sometimes file formatting causes errors
    line = xline.strip()
    vowelcount = 0
    
    # If a word has a length less than 4 it is either a three letter, two syllable word, or has only one syllable.
    if len(line) < 4:
        if len(line) == 3 and line[0] in vowels and line[1] not in vowels and line[2] in vowels:
            print('2')
        else:
            print('1')
        
    else:
        # For now going with if the last letter is a y count as vowel - otherwise not counting y
        if line[-1] == 'y':
            vowelcount += 1
            
        # Start by counting the vowels 
        for char in line:
            if char in vowels:
                vowelcount += 1
                
        # Silent vowels           
        if line[-1] == 'e':
            vowelcount -= 1
            
        # Dipthongs
        a = 0
        b = 2
        
        while b <= len(line):
            bigram = line[a:b]
            if bigram[0] in vowels and bigram[1] in vowels:
                vowelcount -= 1
            a += 1
            b += 1        
                
        # Tripthongs
        x = 0
        y = 3
        
        while y <= len(line):
            trigram = line[x:y]
            if trigram[0] in vowels and trigram[1] in vowels and trigram[2] in vowels:
                vowelcount -= 1
            x += 1
            y += 1
            
        # Special endings 1
        if line[-2:] == 'le' and line[-3] not in vowels:
            vowelcount += 1
            
        # Special endings 2
        elif line[-3:] == 'les' and line[-4] not in vowels:
            vowelcount += 1
            
        print(vowelcount)
    
# I feel like estimation wise this is as good as it gets, beyond this only lies edge cases,
# like silent vowels that aren't trailing 'e' and some strange dipthong/tripthong cases like 'cooperative'

# Remember to reference the site we found helpful - howmanysyllables.com/howtocountsyllables