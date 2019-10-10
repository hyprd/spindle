from eightpuzzle import eightpuzzle
import time

class node:
    def __init__(self, s, parent=None, g=0, h=0, action=None):
        self.s = s
        self.parent = parent
        self.g = g
        self.f = g + h
        self.action = action


def heuristic(s, goal):
    h = 0
    # for each possible direction the agent can go
    for i in range(len(s)):
        # if a certain direction isn't the target goal
        if s[i] != goal[i]:
            h += 1
    return h


puzzle = eightpuzzle(mode='easy')
init_state = puzzle.reset()
goal_state = puzzle.goal()
# create the root node
root_node = node(s=init_state, parent=None, g=0, h=heuristic(s=init_state, goal=goal_state))
# start the fringe off with just the root node in the list
fringe = [root_node]
solution_node = None
# while the fringe has values
while len(fringe) > 0:
    # set current node to the front-most fringe value and pop it from the list
    current_node = fringe.pop(0)
    # create a reference to the nodes current state
    current_state = current_node.s
    # if the state we are in is the goal state, break the program
    if current_state == goal_state:
        solution_node = current_node
        break
    else:
        # actions is a list of possible positions an agent can take (top-left, top,top-right etc.)
        available_actions = puzzle.actions(s=current_state)
        # for each action the agent can take
        for a in available_actions:
            # return the state that results from taking action a with step function
            next_state = puzzle.step(s=current_state, a=a)
            # make a new child node (parent of the current_node), passing
            new_node = node(s=next_state, parent=current_node, g=current_node.g + 1,
                            h=heuristic(s=next_state, goal=goal_state),
                            action=a)
            # add the child to the fringe
            fringe.append(new_node)
        # lambda compares fringe nodes by their f values. node with the lowest f value
        # will be at the front of the fringe list
        fringe.sort(key=lambda x: x.f)

# if the solution node hasn't been found after searching the entire tree, print solution not found
if solution_node is None:
    print("Couldn't find a solution!")
else:
    # this else block travels back through the tree, recording each action taken at each node
    # store the total sequence
    action_sequence = []
    # start at the solution (final) node
    next_node = solution_node
    # while the program hasn't ended up at the start node (break program if it has reached the start)
    while True:
        if next_node == root_node:
            break
        # add the action taken at the node to the total action sequence
        action_sequence.append(next_node.action)
        # traverse to the next node by going through the parent
        next_node = next_node.parent
    # the sequence starts from the solution and works back through to the start
    # reverse this so the sequence begins from the root/start node and finishes at the solution
    action_sequence.reverse()
    # output total move count
    print("Number of moves: %d" % solution_node.g)
    puzzle.show(a=action_sequence)
