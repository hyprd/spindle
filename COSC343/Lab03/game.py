from tictactoe import tictactoe
import numpy as np
import random


class game(tictactoe):
    def agent_move(self, state):
        while True:




    # Returns the maximizing value
    def max_move(self, state, depth):
        vals_max = []
        max_new_states = self.max_possible_moves(state)
        for s in max_new_states:
            v = self.evaluate(s)
            vals_max.append(v)
        i = np.argmin(vals_max)
        print(i)
        return i

    # Returns the minimizing value
    def min_move(self, state, depth):
        vals_min = []
        min_new_states = self.min_possible_moves(state)
        for s in min_new_states:
            v = self.evaluate(s)
            vals_min.append(v)
        i = np.argmax(vals_min)
        print(i)
        return i

while True:
    game(opponent = "x")
    game(opponent = "o")