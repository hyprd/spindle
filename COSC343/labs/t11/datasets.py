#from tensorflow.examples.tutorials.mnist import input_data
import tensorflow as tf
import numpy as np

__author__ = "Lech Szymanski"
__email__ = "lechszym@cs.otago.ac.nz"

class datasets:

    def __init__(self, data, target):
        self.data = data
        self.target = target


    def show(self, data=None):
        import matplotlib.pyplot as plt

        if data is None:
            data = self.data

        num_points, num_attributes = np.shape(data)

        figure_handle = plt.figure()

        num_images = 16
        if num_images > num_points:
            num_images = num_points

        num_rows = int(np.floor(np.sqrt(num_images)))
        num_cols = int(np.ceil(float(num_images) / float(num_rows)))

        im_height = int(np.sqrt(num_attributes))
        im_width = int(np.sqrt(num_attributes))

        n = 0
        for r in range(num_rows):
           for c in range(num_cols):
               if n >= num_images:
                   break

               im = data[n, :].reshape(im_height, im_width)

               h = figure_handle.add_subplot(num_rows, num_cols, n + 1)

               n += 1

               h.imshow(im)
               h.xaxis.set_visible(False)
               h.yaxis.set_visible(False)

        plt.show()


    @staticmethod
    def load_mnist():
        # load mnist data
        (x_train, y_train), (x_test, y_test) = tf.keras.datasets.mnist.load_data()
        x_train = np.reshape(x_train.astype(np.float), (-1, 28 * 28))/255.0
        return datasets(data=x_train, target=y_train)







