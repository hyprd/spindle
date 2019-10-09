import java.util.Scanner;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
/**
 * COSC326 - EFFECTIVE PROGRAMMING
 * ETHAN SIMMONDS SEMESTER 1 - 2019
 *
 * Write a program that produces a representation of a quilt design on the screen
 * or as a graphics file in a common format.
 */

public class Quilt extends JPanel{
    private static ArrayList<Square> squareList = new ArrayList<Square>();
    private static Scanner sc = new Scanner(System.in); 
    private static final Integer size  = 600;
    private Integer currentSquare = 0;
    private Double scaleTotal = 0.0;
    public static void main(String[] args){
        new Quilt();
    }
    public Quilt(){ 
        ArrayList<String> params = new ArrayList<String>();       
        int r, g, b, layer = 0;
        double scale;
        while(sc.hasNextLine()){
            params.add(sc.nextLine());
        }
        
        for(String s : params){
            try{
            String[] arguments = s.split(" ");
            scale = Double.parseDouble(arguments[0]);
            r = Integer.parseInt(arguments[1]);
            g = Integer.parseInt(arguments[2]);
            b = Integer.parseInt(arguments[3]);
            scaleTotal += scale;
            squareList.add(new Square(scale, r, g, b, layer));
            // increment layer
            layer++;
            } catch(NumberFormatException e){
                System.out.println("Empty string in input");
                break;
            }
        }
        squareList.add(null);
        JFrame frame = new JFrame();
        int offset = 23;
        frame.setPreferredSize(new Dimension(size + 1, size + offset));
        frame.getContentPane().add(this);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Quilt");
        frame.pack();
        frame.setVisible(true);
    }
    // Recursive implementation
    private void draw(Graphics g, int square, int x, int y){
        Integer sizeSquare = (int)((squareList.get(square).getScale() / scaleTotal) * (size));
        if (currentSquare.equals(squareList.get(square).getLayer())){
            g.setColor(squareList.get(square).getColour());
            g.fillRect(x - sizeSquare / 2, y - sizeSquare / 2, sizeSquare, sizeSquare);
        }
        if(squareList.get(square + 1) != null){
            draw(g, square + 1, x - sizeSquare / 2, y - sizeSquare /2);
            draw(g, square + 1, x - sizeSquare / 2, y + sizeSquare / 2);
            draw(g, square + 1, x + sizeSquare / 2, y - sizeSquare / 2);
            draw(g, square + 1, x + sizeSquare / 2, y + sizeSquare / 2);
        }
    }

    public void paintComponent(Graphics g){
        while(currentSquare < squareList.size()){
            draw(g, 0, size / 2, size / 2);
            currentSquare++;
        }
        currentSquare = 0;  
    }
}
