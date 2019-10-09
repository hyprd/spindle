import numpy as np
import matplotlib as plt
import random
x = np.array([[0, 0], [0, 1], [1, 0], [1, 1]])
y = np.array([[0], [0], [0], [1]])
weights = np.array([[random.uniform(0.0, 1.0), random.uniform(0.0, 1.0)],
                    [random.uniform(0.0, 1.0), random.uniform(0.0, 1.0)],
                    [random.uniform(0.0, 1.0), random.uniform(0.0, 1.0)],
                    [random.uniform(0.0, 1.0), random.uniform(0.0, 1.0)],
                    [random.uniform(0.0, 1.0), random.uniform(0.0, 1.0)],])

bias = random.uniform(-1.0, 1.0)
bias = round(bias, 2)
epochs = 10
alpha = 0.1

for i in range(0, epochs):
    



# Plots 2d points
plt.close('all')
plt.figure()
I0 = np.where(y == 0)[0]
plt.plot(x[I0], x[I0, 1], 'r.')
I1 = np.where(y == 1)[0]
plt.plot(x[I1, 0], x[I1, 1], 'b.')
plt.show()

# Plot separating line
x1s = np.array([-0.5, 1.5])
x2s = np.array(bias - weight * x1s)

