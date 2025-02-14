import numpy as np
import matplotlib.pyplot as plt
import time
import warnings


class tictactoe:

    def __init__(self, opponent='x'):
        warnings.filterwarnings("ignore", ".*GUI is implemented.*")
        self.plot_handles = []
        self.reset()
        self.show()
        self.opponent = opponent
        if opponent == 'o':
            self.mark = 'x'
            self.turn= 1
            self.my_move()
        elif opponent == 'x':
            self.mark = 'o'
        else:
            raise ValueError("The opponent setting '%s' is not recognised.  Valid choices are: 'x' or 'o'." % opponent)

        self.turn = -1
        self.opponent_move()
        plt.show()

    def reset(self):
        self.state = np.zeros((3,3))

    def my_move(self):
        new_state = self.agent_move(np.copy(self.state).tolist())
        new_state = np.array(new_state)
        I = np.where(new_state.reshape(-1) != self.state.reshape(-1))[0]
        if len(I) != 1:
            raise ValueError("Invalid state generated by the agent")

        r = int(np.floor(I[0]/3))
        c = I[0]%3

        self.step([r, c])

    def agent_move(self, current_state):
        raise NotImplementedError(
            "Method agent_move must be implemented in the subclass of tictactoe.")

    def opponent_move(self):
        self.cid = self.h.figure.canvas.mpl_connect('button_press_event', self)

    def possible_moves(self, state, player):
        state = np.array(state)
        possible_states = []
        for i in range(3):
            for j in range(3):
                if state[i,j]==0:
                    new_state = np.copy(state)
                    new_state[i,j]=player
                    possible_states.append(new_state.tolist())

        return possible_states

    def max_possible_moves(self,state):
        state = np.array(state)
        return self.possible_moves(state, player=1)

    def min_possible_moves(self,state):
        return self.possible_moves(state, player=-1)


    def remove_symmetries(self,states):
        #Rotation invariant states
        roti_states = [np.array(states[0])]

        #Examine all states
        for new_state in states:
            new_state = np.array(new_state)

            # Check for identical symmetries
            found_symmetry = False
            for rotation in [0,1,2,3]:

                if rotation == 0:
                    # Do not rotate
                    ns = np.copy(new_state)
                else:
                    # Rotate last state by 90 degrees
                    ns = np.array([[ns[2,0],ns[1,0],ns[0,0]],
                                  [ns[2,1],ns[1,1],ns[0,1]],
                                  [ns[2,2],ns[1,2],ns[0,2]]])

                for s in roti_states:
                    #Check identical states
                    if np.sum(s.reshape(-1)==ns.reshape(-1))==9:
                        found_symmetry = True
                        break

                    #Check horizontal mirror
                    if np.sum(s[:,0]==ns[:,2])==3 and np.sum(s[:,2]==ns[:,0])==3 and np.sum(s[:,1]==ns[:,1])==3:
                        found_symmetry = True
                        break

                    #Check vertical mirror
                    if np.sum(s[0,:]==ns[2,:])==3 and np.sum(s[2,:]==ns[0,:])==3 and np.sum(s[1,:]==ns[1,:])==3:
                        found_symmetry = True
                        break

                if found_symmetry:
                    break

            # If new_state has a new symmetry, add it to the list of rotation invariant states
            if not found_symmetry:
                roti_states.append(new_state)

        # Convert to lists
        selected_states = []
        for s in roti_states:
            selected_states.append(s.tolist())

        # Return rotation invariant states
        return selected_states

    def count_wins(self, state):
        state = np.array(state)
        wins = 0
        for i in range(3):
            s = np.sum(state[i, :])
            if np.abs(s)==3:
                wins += np.sign(s)

            s = np.sum(state[:,i])
            if np.abs(s)==3:
                wins += np.sign(s)

        s = state[0,0]+state[1,1]+state[2,2]
        if np.abs(s)==3:
            wins += np.sign(s)

        s = state[2,0]+state[1,1]+state[0,2]
        if np.abs(s)==3:
            wins += np.sign(s)

        return wins


    def terminal(self, state):
        state = np.array(state)
        if self.count_wins(state) == 0:
            for i in range(3):
                for j in range(3):
                    if state[i,j]==0:
                        return False

        return True

    def moves_left(self,state):
        if self.count_wins(state) != 0:
            return 0

        moves = 0
        for i in range(3):
            for j in range(3):
                if state[i,j]==0:
                    moves += 1

        return moves


    def evaluate(self, state):

        true_wins = self.count_wins(state)
        if true_wins != 0:
            return np.sign(true_wins)*100

        agent_state = np.copy(state)
        for i in range(3):
            for j in range(3):
                if agent_state[i,j]==0:
                    agent_state[i,j]=1

        I_agent = self.count_wins(agent_state)

        opponent_state = np.copy(state)
        for i in range(3):
            for j in range(3):
                if opponent_state[i,j]==0:
                    opponent_state[i,j]=-1
        I_opponent = self.count_wins(opponent_state)

        return I_agent+I_opponent

    def check_win(self):
        winner = 0
        for i in range(3):
            s = np.sum(self.state[i, :])
            if np.abs(s)==3:
                winner = np.sign(s)
                self.plot_handles.append(self.h.plot( [0, 3],[2-i+0.5, 2-i+0.5], 'r'))
                break

            s = np.sum(self.state[:,i])
            if np.abs(s)==3:
                winner = np.sign(s)
                self.plot_handles.append(self.h.plot([i+0.5, i+0.5],[0, 3], 'r'))
                break

        s = self.state[0,0]+self.state[1,1]+self.state[2,2]
        if np.abs(s)==3:
            winner = np.sign(s)
            self.plot_handles.append(self.h.plot([3, 0], [0, 3], 'r'))

        s = self.state[2,0]+self.state[1,1]+self.state[0,2]
        if np.abs(s)==3:
            winner = np.sign(s)
            self.plot_handles.append(self.h.plot([0, 3], [0, 3], 'r'))

        if (winner < 0):
            plt.title("YOU WON!")
        elif winner != 0:
            plt.title("YOU LOST!")

        if winner==0:
            draw = True
            for i in range(3):
                for j in range(3):
                    if self.state[i,j]==0:
                        draw=False

            if draw:
                plt.title("DRAW!")
                winner = 1

        if winner != 0:
            plt.pause(0.01)
            time.sleep(0.01)


        return winner


    def step(self,action):
        r = action[0]
        c = action[1]

        if self.turn == 1:
            mark = self.mark
        else:
            mark = self.opponent


        if self.state[r, c] == 0:
            self.plot_handles.append(self.h.text(c + 0.5, 2 - r + 0.5, mark, fontsize=40, verticalalignment='center',
                                             horizontalalignment='center'))
            self.h.figure.canvas.draw()
            self.state[r, c] = self.turn
            plt.pause(0.01)
            time.sleep(0.01)

    def __call__(self, event):
        if event.xdata is None or event.ydata is None:
            return

        c = int(np.floor(event.xdata))
        r = 2-int(np.floor(event.ydata))

        if self.state[r,c] != 0:
            return

        self.h.figure.canvas.mpl_disconnect(self.cid)
        self.step([r,c])
        if self.check_win() != 0:
            return

        self.turn = 1
        self.my_move()
        if self.check_win() != 0:
            return

        self.turn = -1
        self.opponent_move()

    def show(self):
        if not self.plot_handles:
            fh = plt.figure(figsize=(6, 6), dpi=100)
            self.h = fh.add_subplot(1, 1, 1)

            for x in range(1,3):
                self.h.plot([x, x], [0, 3], 'k')

            for y in range(1,3):
                self.h.plot([0, 3], [y, y], 'k')
            self.h.get_xaxis().set_visible(False)
            self.h.get_yaxis().set_visible(False)
            self.h.set_xlim([0, 3])
            self.h.set_ylim([0, 3])
            self.h.axis('off')

    def show_states(self, statesA, statesB):
        fh = plt.figure(figsize=(12, 6), dpi=100)

        N = np.max([len(statesA), len(statesB)])


        for i in range(2):
            if i==0:
                states = statesA
            else:
                states = statesB

            for n in range(len(states)):
                h = fh.add_subplot(2, N, i*N+n+1)

                for x in range(1,3):
                    h.plot([x, x], [0, 3], 'k')

                for y in range(1,3):
                    h.plot([0, 3], [y, y], 'k')

                h.get_xaxis().set_visible(False)
                h.get_yaxis().set_visible(False)
                h.set_xlim([0, 3])
                h.set_ylim([0, 3])
                h.axis('off')

                for r in range(3):
                    for c in range(3):
                        s = states[n][r][c]
                        if s == 0:
                            continue
                        elif s==1:
                            mark = self.mark
                        else:
                            mark = self.opponent

                        h.text(c + 0.5, 2 - r + 0.5, mark, fontsize=40, verticalalignment='center',
                                    horizontalalignment='center')


        plt.ioff()
        plt.show()
        plt.ion()


