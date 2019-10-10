import iota.*;

import java.util.*;

public class Gilbert extends Player{
    List<PlayedCard> bestMove;

    public Gilbert(Manager m) {
        super(m);
        bestMove = new ArrayList<PlayedCard>();
    }
    
    private void playInDirection(List<List<Card>> plays, int x, int y, int o, int p) {
        for (List<Card> play : plays) {
            List<PlayedCard> move = new ArrayList<PlayedCard>();
            int xOffset = 0;
            int yOffset = 0;
            
            for (Card c : play) {
                move.add(new PlayedCard(c, this, x + xOffset, y + yOffset));
                xOffset += o;
                yOffset += p;
            }
            
            if (Utilities.scoreForMove(move, m.getBoard()) > Utilities.scoreForMove(bestMove, m.getBoard())) {
                bestMove.clear();
                for (PlayedCard pc : move) {
                    bestMove.add(pc);
                }
            }
        }
    }
    
    // https://stackoverflow.com/questions/1670862/obtaining-a-powerset-of-a-set-in-java
    private List<List<Card>> getPlays(List<Card> hand) {
        List<List<Card>> sets = new ArrayList<List<Card>>();
        
        if (hand.size() == 0) {
            sets.add(new ArrayList<Card>());
            return sets;
        }
        
        List<Card> list = new ArrayList<Card>(hand);
        Card head = list.get(0);
        List<Card> rest = new ArrayList<Card>(list.subList(1, list.size()));
        
        for (List<Card> set : getPlays(rest)) {
            List<Card> newSet = new ArrayList<Card>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        
        return sets;
    }

    // https://stackoverflow.com/questions/10305153/generating-all-possible-permutations-of-a-list-recursively
    private List<List<Card>> getPermutations(List<Card> hand) {
        if (hand.size() == 0) {
            List<List<Card>> res = new ArrayList<List<Card>>();
            res.add(new ArrayList<Card>());
            return res;
        }

        Card first = hand.remove(0);

        List<List<Card>> ret = new ArrayList<List<Card>>();
        List<List<Card>> perms = getPermutations(hand);
        for (List<Card> smallPerms : perms) {
            for (int i = 0; i <= smallPerms.size(); i++) {
                List<Card> temp = new ArrayList<Card>(smallPerms);
                temp.add(i, first);
                ret.add(temp);
            }
        }

        return ret;
    }

    private List<PlayedCard> getMove(int minX, int maxX, int minY, int maxY) {
        List<PlayedCard> board = m.getBoard();
        List<Card> hand = m.getHand(this);
        bestMove.clear();
        
        List<List<Card>> possiblePlays = getPlays(hand);
        List<List<Card>> playPermutations = new ArrayList<List<Card>>();
        
        for (List<Card> play : possiblePlays) {
            playPermutations.addAll(getPermutations(play));
        }
        
        for (PlayedCard pc : board) {
            int x = pc.xPosition;
            int y = pc.yPosition;
            PlayedCard adj = Utilities.cardAt(board, x - 1, y);
            System.out.println(x + " " + y);
            if (adj == null) {
                playInDirection(playPermutations, x - 1, y, 1, 0);
                playInDirection(playPermutations, x - 1, y, 0, 1);
                playInDirection(playPermutations, x - 1, y, -1, 0);
                playInDirection(playPermutations, x - 1, y, 0, -1);
            }
            
            adj = Utilities.cardAt(board, x + 1, y);
            if (adj == null) {
                playInDirection(playPermutations, x + 1, y, 1, 0);
                playInDirection(playPermutations, x + 1, y, 0, 1);
                playInDirection(playPermutations, x + 1, y, -1, 0);
                playInDirection(playPermutations, x + 1, y, 0, -1);
            }
            
            adj = Utilities.cardAt(board, x, y - 1);
            if (adj == null) {
                playInDirection(playPermutations, x, y - 1, 1, 0);
                playInDirection(playPermutations, x, y - 1, 0, 1);
                playInDirection(playPermutations, x, y - 1, -1, 0);
                playInDirection(playPermutations, x, y - 1, 0, -1);
            }
            
            adj = Utilities.cardAt(board, x, y + 1);
            if (adj == null) {
                playInDirection(playPermutations, x, y + 1, 1, 0);
                playInDirection(playPermutations, x, y + 1, 0, 1);
                playInDirection(playPermutations, x, y + 1, -1, 0);
                playInDirection(playPermutations, x, y + 1, 0, -1);
            }
        }
        
        return bestMove;
    }

    @Override
    public List<PlayedCard> makeMove() {
        int minX=1000;
        int maxX=-1000;
        int minY=1000;
        int maxY=-1000;
        List<PlayedCard> board = m.getBoard();
        for (PlayedCard pc: board) {
            if (pc.xPosition < minX)
                minX = pc.xPosition;
            if (pc.xPosition > maxX)
                maxX = pc.xPosition;
            if (pc.yPosition < minY)
                minY = pc.yPosition;
            if (pc.yPosition > maxY)
                maxY = pc.yPosition;
        }

        List<PlayedCard> move = getMove(minX, maxX, minY, maxY);

        return move.size() > 0 ? move : Player.PASS;
    }

    @Override
    public List<Card> discard() {
        return m.getHand(this);
    }

    @Override
    public String getName() {
        return "Gilbert";
    }
}

