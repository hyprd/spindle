import java.util.*;

public class Tomoku {

    private static List<Scenario> scenarios;
    private static char[][] board;
    private static Scenario s;
    private static char searchBy;
    private static int tc, tlc, ac;

    public static void main(String[] args) {
        scenarios = Scenario.bootstrap();
        
        for (Scenario tmp : scenarios) {
            tc = tlc = ac = 0;
            s = tmp;
            board = Scenario.getBoard(s);
            
            System.out.println(s + "\n");
            if (board.length > 1 && board[0].length > 1) {
                if (board.length > board[0].length && doTomokuByRow(0, 0)) Scenario.printBoard(board);
                else if (doTomokuByCol(0, 0)) Scenario.printBoard(board);
                else System.out.println("Not achievable");
            } else {
                System.out.println("Not achievable");
            }
            System.out.println();

            System.err.println("tc: " + tc + " tlc: " + tlc + " ac: " + ac);
        }

        /*
            METHOD: Create a 2D array that represents the board.
                    For each empty square, try all possible moves.
                    Mark move with string representation (o | - etc).
                    Remove move if invalid.
                    Perform backtracking on this construct.

            CAVEATS: Vertical bars might break valid move list.
                     How to check if all pieces are used inside recursion?
            
            UPDATE: METHOD mostly implemented except for checking if board is auspicious.
                    CAVEATS appear to be a non-issue at this stage.
            
            UPDATE: METHOD fully implemented and (apparently) working, though needs
                    thorough testing. Vertical and Horizontal mats are represented with
                    't', 'b'; and 'l', 'r' respectively, this is to reduce computational
                    load when checking for unlucky corners. They are changed to
                    '|' and '-' respectively for output.
                    CAVEATS ended up being a non-issue.
            
            REFACT: The first double for loop in doTomoku() (it finds the first empty
                    square on the board) may be able to be rewritten as an offset.
                    Currently it searches the whole board.
                    Similarly, auspiciousBoard() check every intersection on the
                    entire board. This one can definitely be condensed to one check on
                    each corner intersection of the new mat.
            
            PROBLEM: Had an issue with auspicious checking. Needed to ensure that all
                     sectors in the quadrant were filled. Also needed to alter the switch
                     logic in uniqueMats().
            
            OPTIMISE: Reduced loop wastage significantly in the top lood of doTomoku()
                      and in auspiciousBoard()
        */
    }
    
    // Inspiration: https://www.geeksforgeeks.org/sudoku-backtracking-7/
    private static boolean doTomokuByRow(int sX, int sY) {
        tc++;
        int row = -1;
        int col = -1;
        boolean complete = true;
        
        int x = sX;
        int y = sY;
        while (x < board.length) {
            while (y < board[x].length) {
                tlc++;
                if (board[x][y] == '\0') {
                    row = x;
                    col = y;
                    complete = false;
                    
                    break;
                }
                
                y++;
            }
            
            if (!complete) break;
            x++;
            y = 0;
        }
        
        if (complete) return true;
        
        if (putSquare(row, col)) {
            if (luckyMove(row, col) && doTomokuByRow(row, col + 1)) return true;
            else takeSquare(row, col);
        }
        
        if (putHorizon(row, col)) {
            if (luckyMove(row, col) && doTomokuByRow(row, col + 2)) return true;
            else takeHorizon(row, col);
        }
        
        if (putVertical(row, col)) {
            if (luckyMove(row, col) && doTomokuByRow(row, col + 1)) return true;
            else takeVertical(row, col);
        }
        
        return false;
    }
    
    private static boolean doTomokuByCol(int sX, int sY) {
        tc++;
        int row = -1;
        int col = -1;
        boolean complete = true;
        
        int x = sX;
        int y = sY;
        while (y < board[0].length) {
            while (x < board.length) {
                tlc++;
                if (board[x][y] == '\0') {
                    row = x;
                    col = y;
                    complete = false;
                    
                    break;
                }
                
                x++;
            }
            
            if (!complete) break;
            y++;
            x = 0;
        }
        
        if (complete) return true;
        
        if (putSquare(row, col)) {
            if (luckyMove(row, col) && doTomokuByCol(row + 1, col)) return true;
            else takeSquare(row, col);
        }
        
        if (putVertical(row, col)) {
            if (luckyMove(row, col) && doTomokuByCol(row + 2, col)) return true;
            else takeVertical(row, col);
        }
        
        if (putHorizon(row, col)) {
            if (luckyMove(row, col) && doTomokuByCol(row + 1, col)) return true;
            else takeHorizon(row, col);
        }
        
        return false;
    }

    // Check the board for any unlucky corners (i.e. where 4 sectors' seams form a cross).
    private static boolean luckyMove(int row, int col) {
        // return true; // Uncomment this line to disable unlucky corner checking.
        
        if (!luckyQuadrant(row - 1, col - 1)) return false;
        
        return true;
    }
    
    private static boolean luckyQuadrant(int r, int c) {
        ac++;
        return !fullSectors(r, c)
        || !uniqueMats(r, c, r, c + 1)
        || !uniqueMats(r, c + 1, r + 1, c + 1)
        || !uniqueMats(r + 1, c, r + 1, c + 1)
        || !uniqueMats(r, c, r + 1, c);
    }
    
    // Checks if each sector in a quadrant is not null.
    private static boolean fullSectors(int r, int c) {
        if (r < 0 || r >= board.length - 1 || c < 0 || c >= board[r].length - 1) return false;
        return board[r][c] != '\0' && board[r][c + 1] != '\0' && board[r + 1][c] != '\0' && board[r + 1][c + 1] != '\0';
    }
    
    // Do the two squares contain unique mats?
    private static boolean uniqueMats(int r1, int c1, int r2, int c2) {
        if (r2 > r1 && (board[r1][c1] == 't' && board[r2][c2] == 'b')) return false;
        if (c2 > c1 && (board[r1][c1] == 'l' && board[r2][c2] == 'r')) return false;
        
        return true;
    }

    private static boolean putSquare(int row, int col) {
        if (s.singleRow[row] > 0 && s.singleCol[col] > 0) {
            s.singleRow[row]--;
            s.singleCol[col]--;
            board[row][col] = 'o';
            
            return true;
        }
        
        return false;
    }
    
    private static boolean putHorizon(int row, int col) {
        if (s.doubleRow[row] > 0 && col < board[row].length - 1 && board[row][col + 1] == '\0') {
            s.doubleRow[row]--;
            board[row][col] = 'l';
            board[row][col + 1] = 'r';
            
            return true;
        }
        
        return false;
    }
    
    private static boolean putVertical(int row, int col) {
        if (s.doubleCol[col] > 0 && row < board.length - 1 && board[row + 1][col] == '\0') {
            s.doubleCol[col]--;
            board[row][col] = 't';
            board[row + 1][col] = 'b';
            
            return true;
        }
        
        return false;
    }
    
    private static void takeSquare(int row, int col) {
        s.singleRow[row]++;
        s.singleCol[col]++;
        board[row][col] = '\0';
    }
    
    private static void takeHorizon(int row, int col) {
        s.doubleRow[row]++;
        board[row][col] = '\0';
        board[row][col + 1] = '\0';
    }
    
    private static void takeVertical(int row, int col) {
        s.doubleCol[col]++;
        board[row][col] = '\0';
        board[row + 1][col] = '\0';
    }
}
