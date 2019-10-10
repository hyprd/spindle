import iota.*;

import java.util.ArrayList;
import java.util.List;

public class Dave extends Player{

    public Dave(Manager m) {
        super(m);
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
        for (Card card: m.getHand(this)){
            for (int i = minX-1; i< maxX+1;i++){
                for (int j = minY-1; j < maxY+1; j++) {
                    List<PlayedCard> move = new ArrayList<>();
                    move.add(new PlayedCard(card, this, i, j));
                    if (Utilities.scoreForMove(move, board) > 0)
                        return move;
                }
            }
        }
        return Player.PASS;
    }

    @Override
    public List<Card> discard() {
        return m.getHand(this);
    }

    @Override
    public String getName() {
        return "Dave";
    }
}

