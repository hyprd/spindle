from SRNClassifier import SRNClassifier
import pickle
import gzip
import numpy as np

# declare SRN Classifier
clf = SRNClassifier(alpha=1e-5, hidden_layer_size=32, activation='tanh', max_iter=100, verbose=True)
script_length = 0

with open('script.txt', 'r') as f:
    for line in f:
        for word in line.split():
            script_length += 1
            print("script length: ", script_length)

array = np.array(np.empty(script_length))

