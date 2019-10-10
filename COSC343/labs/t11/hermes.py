import matplotlib.pyplot as plt
import numpy as np
from sklearn import datasets
from sklearn.decomposition import PCA
from sklearn.cluster import KMeans

iris = datasets.load_iris()
data = iris.data
target = iris.target
# expects 150
# print(len(data))
# print(len(target))

#plt.figure(figsize=(8, 6))
#plt.scatter(data[:, 1], data[:, 3], c=target, cmap=plt.cm.Set1)
# plt.show()

# compute mean of each value in 'data'
# 4D vector
muX = np.mean(data, axis=0)
# subtract mean from each respective data column
# numpy is smart enough to subtract the 4D muX vector
# value from each column in the dataset :)
data -= muX
# declare PCA instance
# n_components refers to the amount of PCs we
# want to keep. changes are reflected in the
# eigenvectors / eigenvalues output in console
h_pca = PCA(n_components=4)
# fit PCA
h_pca.fit(data)
print("Eigenvectors:")
print(h_pca.components_)
print("Eigenvalues: ")
print(h_pca.explained_variance_ratio_)
# transform data into PCA coord system
x_pca = h_pca.transform(data)
# plotting according to the two largest components
# is now possible by referencing the first 2 dimensions
# of the data matrix
##plt.scatter(data[:, 0], data[:, 1], c=target, cmap=plt.cm.Set1)
##plt.show()

##
# K-MEANS CLUSTERING EXERCISE
##

# create k-means model
# specify number of clusters we want
k = 3
h_kmeans = KMeans(n_clusters = k)
# determine centroids
h_kmeans.fit(data)
# get labels of the data points based on the centroids
y_kmeans = h_kmeans.predict(data)
# get centroids
c = h_kmeans.cluster_centers_
fh = plt.figure(figsize=(8, 6))
fh.add_subplot(2,1,1)
plt.scatter(x_pca[:, 0], x_pca[:,1], c=target, cmap=plt.cm.Set1)
plt.title("2D visualisation of iris data (true clusters)")
fh.add_subplot(2,1,2)
##plt.scatter(x_pca[:,0], x_pca[:,1], c=y_kmeans, cmap=plt.cm.Set1)
plt.scatter(c[:, 0], c[:, 1], c=range(k), cmap=plt.cm.Set1, marker='s', edgecolor='black')
plt.title("2D visualisation of iris data (k-Means clusters)")
plt.show()



