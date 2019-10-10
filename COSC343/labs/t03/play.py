from tictactoe import tictactoe
import random


class mygame(tictactoe):

    # tell the agent what move to make next in the game
    def agent_move(self, state):
        state_evaluations = []
        new_states = self.max_possible_moves(state)
        # for every possible state
        for s in new_states:
            if self.terminal(s):
                break
            # make a move on that state
            if self.evaluate(s) == 100:
                print("MAX won!")
                break
            else:
                if self.evaluate(s) == -100:
                    print("MIN won!")
                    break
            state_evaluations.append(self.evaluate(s))
            self.agent_move(s)


        return state






while True:
    # game where human makes the first move
    mygame(opponent='x')
    # game where agent makes the first move
    mygame(opponent='o')


