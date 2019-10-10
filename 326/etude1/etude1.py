import fileinput

vowels = ['a', 'e', 'i', 'o', 'u']

for raw_line in fileinput.input():

    line = raw_line.lower().rstrip()
    syllable_count = 0
    ch = 0

    while ch < len(line):
        # If the word ends with "le" and a consonant precedes this
        if ch == len(line) - 1 and line[-2:] == "le" and line[-3] not in vowels:
            syllable_count += 1

    # If an internal character is 'y'
    if line[ch] == 'y' and ch > 0 and ch < len(line) - 1:
        # If it is surrounded by consonants and ONLY consonants
        if line[ch - 1] not in vowels or line[ch + 1] not in vowels:
            syllable_count += 1

    # If character is a vowel
    if line[ch] in vowels:
        # If the terminal character is 'e' and the length is > 2
        if ch == len(line) - 1 and line[ch] == 'e' and len(line) > 2:
            pass
        else:
            syllable_count += 1
            # Skip diphthongs and triphthongs
            while ch < len(line) - 1 and line[ch + 1] in vowels:
                ch += 1

    ch += 1

    print(vowel_count)
