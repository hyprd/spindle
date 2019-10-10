import numpy as np
import random
import matplotlib.pyplot as plt


inputs = np.array([[0, 0], [0, 1], [1, 0], [1, 1]])
labels = np.array([[0], [0], [0], [1]])
wgts = np.array([[1],
                 [random.uniform(0, 1)],
                 [random.uniform(0, 1)],
                 [random.uniform(0, 1)],
                 [random.uniform(0, 1)], ])


# initialize constructor with default values
def _init_(self, epochs=100, learning_rate=0.01):
    self.epochs = epochs
    self.learning_rate = learning_rate


# predict labels
def predict(self, inputs):
    # perceptron output sum
    sum_value = np.dot(inputs, self.wgts[1:]) + self.wgts[0]
    if sum_value > 0:
        activation = 1
    else:
        activation = 0
    return activation


# train model
def train(self, labels, training_input):
    for e in range(self.epochs):
        for inputs, label in zip(training_input, labels):
            # predict label
            prediction = self.predict(inputs)
            self.wgts[1:] += self.learning_rate * (label - prediction) * inputs
            self.wgts[0] += self.learning_rate * (label - prediction)


plt.close('all')
plt.figure()
I0 = np.where(labels == 0)[0]
plt.plot(inputs[I0, 0], inputs[I0, 1], 'r.')
I1 = np.where(labels == 1)[0]
plt.plot(inputs[I1, 0], inputs[I1, 1], 'b.')
plt.show()

x1s = np.array([-0.5, 1.5])
x2s = (wgts[0] - wgts[1] * x1s)
