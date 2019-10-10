import numpy as np
import os
import inspect
import matplotlib as plt
from sklearn import datasets
from sklearn import preprocessing
from sklearn.neural_network import MLPRegressor
# get working directory
wd = os.path.dirname(os.path.abspath(inspect.getfile(inspect.currentframe())))
# load numpy file
npzfile = np.load(os.path.join(wd, "t8dataset1.npz"))
x = npzfile['x']
y = npzfile['y']
# declare multilayer perceptron network classifier
clf = MLPRegressor(alpha=1e-5, hidden_layer_sizes=(5, 2), activation='relu', max_iter=500)
# train the network
clf.fit(x, y)
# get the training score of the data
# 1.0 is perfect accuracy
# 0.0 is lowest possible accuracy, can go negative
score = clf.score(x, y)


# DIGITS MNIST Dataset classification (simplified)
digits = datasets.load_digits()
# declare digits dataset
data = digits.data
# declare variable for labels
labels = digits.target
# converts the labels to a one-hot, 10D vector
# add dimensions to the dataset at size 64 (previously 1)
labels = np.expand_dims(labels, axis=1)
# declare one-hot encoder
encoder = preprocessing.OneHotEncoder()
# fit labels to encoder
encoder.fit(labels)
# redeclare converted labels to a 2D array
labels = encoder.transform(labels).toarray()
# prints out a label at a certain index
# the value returns as a single 10D vector (10 corresponding to each
# digit classification outcome)
#
# label = labels[4, :]
# print(label)

# create a train/test split
num_points, num_attributes = data.shape
# create a random permutation of all the point indexes
I = np.random.permutation(num_points)
# rearrange the images and the labels according to the new
# order of indexes
data = data[I, :]
labels = labels[I, :]
# split the data at the 80% margin of all indexes
# round the split down (via flooring function)
split = int(np.floor(num_points * 0.8))
# take the first 80% of indexes for the training split
training_data = data[0:split, :]
training_labels = labels[0: split, :]
# take the remaining 20% of indexes for the testing split
testing_data = data[split:, :]
testing_labels = labels[split:, :]
