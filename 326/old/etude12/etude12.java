import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import javax.swing.*;

/**
 * A recursive implementation of order n Hilbert curves.
 * @author Ethan Simmonds
 * @since May 2019
 */
public class etude12 extends JPanel{
    private Integer Ratio = 1, Order = 1, Distance = 512, Distance2 = 512;
    public static void main(String[] args){
        // new instance of line utilities and input getter
        etude12 Util = new etude12();
        // new frame
        JFrame Frame = new JFrame();
        // close when exit is pressed
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set frame size
        Frame.setPreferredSize(new Dimension(600, 600));
        //add utils to frame (allow drawing)
        Frame.add(Util);
        // pack frame contents
        Frame.pack();
        // frame centering
        Frame.setLocationRelativeTo(null);
        // set frame visibility to the screen
        Frame.setVisible(true);
    }
    
    public etude12(){
        // get users input
        FetchInput();
        // make instance of line drawing utilities
        LineUtils Utils = new LineUtils();
    }

    private void HilbertA(Graphics2D g, Integer Order){
        if(Order > 0){

        }

    }

    @Override
    protected void paintComponent(Graphics g){
        // inherit from parent class
        super.paintComponent();
        // scale the length of lines relative to order
        for(int i = Order; i > 0; i--){
            Distance2 /= 2;
        }
        // set coordinates
        Utils.setCoordinates(Distance2 / 2, Distance2 / 2);
        // create insteance of Graphics2D
        Graphics2D G2D = (Graphics2D) g.create();
        //entry point to  hilbert drawing passing order and Graphics2D instance
        HilbertA(G2D, Order);
        // get rid of the G2d object once drawing is done
        G2D.dispose();                                            
    }

    /**
     * Get ratio and order inputs from the user.
     */
    private void FetchInput(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter [ORDER], or [ORDER] [RATIO]");
        // user input string
        String Input = scan.nextLine();
        scan.close();
        // split array per parameter
        String[] Split = new String[2];
        // check for whether there are tabs or spaces in input
        if(Input.contains("\\t")){
            Split = Input.split("\\t");
        } else{
            Split = Input.split("\\s");
        }
        // if input isn't strictly numerical and/or contains spaces
        // return invalid input
        if(!Input.matches("[0-9\\s\\t]+")){
            System.out.println("Invalid input");
            return;
        }
        // handles depending on the length of user input
        // if only order is given, assign order
        // if order and ratio are given, assign them both
        switch(Split.length){
            case 1:
                Order = Integer.parseInt(Split[0]);
                break;
            case 2:
                Order = Integer.parseInt(Split[0]);
                Ratio = Integer.parseInt(Split[1]);
                break;
            default:
                System.out.println("Invalid input");
                return;
        }
    }

    /**
     * Utility class for line drawing functions
     */
    private class LineUtils{
        private Integer Width, Height;
        public LineUtils(){}
        /**
         * Set coordinates to be useed in curve generation
         * @param Width width value
         * @param Height height value
         */
        private void SetCoordinates(Integer Width, Integer Height){
            this.Width = Width;
            this.Height = Height;
        }
        /**
         * Line generation function
         * @param graphics the graphics instance
         * @param deltaWidth change in width
         * @param deltaHeight change in height
         */
        private void Line(Graphics2D graphics, Integer deltaWidth, Integer deltaHeight){
            graphics.drawLine(Width, Height, Width + deltaWidth, Height + deltaHeight);
            Width += deltaWidth;
            Height += deltaHeight;
        }
    }
}
