Addition - Etude 11
Harry Smith
Ethan Simmonds

Compile:
    javac Addition.java Util.java

Run:
    java Addition
    
Notes:

I have chosen to represent "zero" as literally a lack of tallies ("1"s) in base 1.
This is intentional so if a value doesn't show up for the tally, quotient or remainder,
that is why.

I have also chosen only to represent "0" itself as a positive number - I don't think
"-0" is technically defined, or if it is, it means the exact same as "0". You may
input "-0" and it will not cause issues.

Leading zeros in input will not cause issues, but will be stripped for output.
