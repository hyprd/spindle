import iota.*;

import java.util.ArrayList;
import java.util.List;

public class BetterDave extends Player{

    public BetterDave(Manager m) {
        super(m);
    }
/*
    private List<PlayedCard> getPlays(List<PlayedCard> bestMove, List<Card> hand, int minX,int maxX, int minY, int maxY, List<PlayedCard> board){
        Card firstPlay = null;
        int max = 0;
        Boolean check = false;
        List<PlayedCard> storedMove = new ArrayList<>();
        for (Card card: hand){
            for (int i = minX-1; i< maxX+1;i++){
                for (int j = minY-1; j < maxY+1; j++) {
                    List<PlayedCard> move = new ArrayList<>();
                    for(PlayedCard c: bestMove){
                        move.add(c);
                    }
                    move.add(new PlayedCard(card, this, i, j));
                    if (Utilities.scoreForMove(move, board) > 0){
                        max = Utilities.scoreForMove(move, board);
                        bestMove = move;
                        firstPlay = card;
                        check = true;
                        List<Card> newHand = m.getHand(this);
                        newHand.remove(firstPlay);
                        List<PlayedCard> possibleMove = getPlays(move, newHand, minX, maxX, minY, maxY, board);
                        if(Utilities.scoreForMove(possibleMove, board) > max){
                            max = Utilities.scoreForMove(possibleMove, board);                                    
                            move = possibleMove;
                        }
                        max = 0;
                        bestMove = move;
                        hand.add(firstPlay);
                    
                    }
                }                
            }
            if(Utilities.scoreForMove(bestMove, board) > max){
                max = Utilities.scoreForMove(bestMove, board);
                storedMove = bestMove;
            }
        }

        /*
        hand.remove(firstPlay);
        System.out.println(hand.size() + " submit");
        if(!hand.isEmpty() && check)
            bestMove = getPlays(bestMove, hand, minX, maxX, minY, maxY, board);
        

        return storedMove;
    }
*/

    private List<PlayedCard> getPlays(List<PlayedCard> bestMove, List<Card> hand, int minX,int maxX, int minY, int maxY, List<PlayedCard> board){
        Card firstPlay = null;
        int max = 0;
        Boolean check = false;
        for (Card card: hand){
            for (int i = minX-1; i< maxX+1;i++){
                for (int j = minY-1; j < maxY+1; j++) {
                    List<PlayedCard> move = new ArrayList<>();
                    for(PlayedCard c: bestMove){
                        move.add(c);
                    }
                    move.add(new PlayedCard(card, this, i, j));
                    if (Utilities.scoreForMove(move, board) > 0)
                        if (Utilities.scoreForMove(move, board) > max){
                            max = Utilities.scoreForMove(move, board);
                            bestMove = move;
                            firstPlay = card;
                            check = true;
                            System.out.println(hand.size());
                        }
                }
            }
        }
        hand.remove(firstPlay);
        System.out.println(hand.size() + " submit");
        if(!hand.isEmpty() && check)
            bestMove = getPlays(bestMove, hand, minX, maxX, minY, maxY, board);
        
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

        List<Card> hand = m.getHand(this);
        List<PlayedCard> bestMove = new ArrayList<>();
        bestMove = getPlays(bestMove, hand, minX, maxX, minY, maxY, board);
        if(bestMove.size() > 0){
            return bestMove;
        }
        bestMove.clear();
        return Player.PASS;
    }

    @Override
    public List<Card> discard() {
        return m.getHand(this);
    }

    @Override
    public String getName() {
        return "BetterDave";
    }
}

