import numpy as np
import inspect, os
import matplotlib.pyplot as plt

wd = os.path.dirname(os.path.abspath(inspect.getfile(inspect.currentframe())))
npzfile = np.load(os.path.join(wd, "t1dataset1.npz"))

x = npzfile['x']
y = npzfile['y']

plt.plot(x, y,'r.')
plt.xlabel("X")
plt.ylabel("Y")
plt.show()

print(npzfile.files)
print(x.shape)
print(y.shape)