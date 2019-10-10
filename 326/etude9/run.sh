#!/bin/bash

for f in *.txt; do
    python3 main.py < $f
done
