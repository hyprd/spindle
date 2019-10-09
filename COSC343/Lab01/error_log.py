#!/usr/bin/env python3
from ev3dev2 import *

def main():
    # remove the following line and replace with your code
    raise ValueError('A value error.')

try:
    main()
except:
    import traceback
    exc_type, exc_value, exc_traceback = sys.exc_info()
    traceback.print_exception(exc_type, exc_value, exc_traceback, file=sys.stdout)
    while True:
        pass
