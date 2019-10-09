from eightpuzzle import eightpuzzle
import time


# Definition of a class named 'node'
class node:
    def __init__(self, s, parent=None, g=0, h=0, action=None):
        self.s = s  # state
        self.parent = parent  # parent node reference
        self.g = g  # cost
        self.f = g + h  # evaluation function
        self.action = action  # action taken from parent nodes state to this node's state


def heuristic(s, goal):
    h = 0
    for i in range(len(s)):
        if s[i] != goal:
            h += i
    return h


start_time = time.time()
puzzle = eightpuzzle(mode='easy')
init_state = puzzle.reset()
goal_state = puzzle.goal()
root_node = node(s=init_state, parent=None, g=0, h=heuristic(s=init_state, goal=goal_state))
fringe = [root_node]


solution_node = None
while len(fringe) > 0:
    # remove first item, reference popped node by current_node
    current_node = fringe.pop(0)
    # create and store node state of current_node
    current_state = current_node.s

    # check if the current state is the same as the goal state, break if true
    if current_state == goal_state:
        # save current node as the solution
        solution_node = current_node
        break
    else:
        # return a list of valid actions given a board state
        # 0 - right -> empty
        # 1 = up -> empty
        # 2 = left -> empty
        # 3 - down -> empty
        available_actions = puzzle.actions(s=current_state)
        for a in available_actions:
            # return the state which results from taking action a
            next_state = puzzle.step(s=current_state, a=a)
            # create node with new state, as a child of the current node in the state tree
            new_node = node(s=next_state,
                            parent=current_node,
                            g=current_node.g+1,
                            h=heuristic(s=next_state,
                                        goal=goal_state),
                            action=a)

            fringe.append(new_node)
        # sort the fringes by f value inside the objects
        print("sort fringe")
        fringe.sort(key=lambda x: x.f)

elapsed_time = time.time() - start_time
print("Elapsed time: %.f seconds" % elapsed_time)

# if the solution node contains no value, the program hasn't found a post-routine solution
if solution_node is None:
    print("Didn't find a solution!!!")
# walk the search tree back from solution node to the root
# while recording all node actions in the list
else:
    action_sequence = []
    next_node = solution_node
    while True:
        if next_node == root_node:
            break

        action_sequence.append(next_node.action)
        next_node = next_node.parent
    # flip with this line
    action_sequence.reverse()
    print("Number of moves: %d" % solution_node.g)
puzzle.show(a=action_sequence)



