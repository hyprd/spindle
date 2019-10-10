from sklearn.neural_network import MLPClassifier
from sklearn import datasets
from sklearn import preprocessing
import numpy as np
import matplotlib as plt
clf = MLPClassifier(alpha=1e-5, hidden_layer_sizes=(5, 4), activation='relu', max_iter=500)
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
clf.fit(training_data, training_labels)
score = clf.score(testing_data, testing_labels)
print(score)

def data_plot(data, labels=None):
    num_points, num_attributes = data.shape
    # expects 8x8 image
    image_height = 8
    image_width = 8
    plt.close('all')
    # create new figure
    figure_handle = plt.figure()
    plot_handles = []
    # plot the first 16 images
    n = 0
    for row in range(4):
        for col in range(4):
            if n >= num_points:
                continue
            # reshape image of 64 dimensions into 8x8 matrix
            image = data[n, :].reshape(image_height, image_width)
            n += 1
            # add subfigure
            plot_handle = figure_handle.add_subplot(4, 4, n)
            plot_handles.append(plot_handle)
            # show 8x8 as image
            plot_handle.imshow(image)
            plot_handle.xaxis.set_visible(False)
            plot_handle.yaxis.set_visible(False)
        # changes title above subfigure to match the current label
        for n in range(len(plot_handles)):
            # expects label in hot-one encoding
            if np.sum(labels[n,:]) != 1:
                class_label = "?"
            else:
                class_label = np.argmax(labels[n, :])
        plot_handles[n].set_title(class_label)
    plt.show()

