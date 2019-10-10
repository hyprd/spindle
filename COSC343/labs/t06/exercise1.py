import numpy as np
import matplotlib.pyplot as plt
import inspect, os

wd = os.path.dirname(os.path.abspath(inspect.getfile(inspect.currentframe())))
npzfile = np.load(os.path.join(wd, "t1dataset1.npz"))

# extract vectors from npz
x = npzfile['x']
y = npzfile['y']

# determine function to compare
# the data fits a simple quadratic formula
# ax^2 + bx + c
x2 = np.linspace(-5, 5, 40)
y2 = (0.2 * x2**2) + 0.2 * x2 - 2

# generate visualisations for both models
plt.close('all')
plt.figure()

plt.plot(x, y, 'g.')
plt.plot(x2, y2, 'r-')

plt.xlabel('x')
plt.ylabel('y')

plt.legend(['data', 'function'])
plt.show()
