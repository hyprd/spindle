import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import javax.swing.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * An implementation of order n Hilbert curves using recursive methods.
 * @author Ethan Simmonds
 * @since May 2019
 */
public class etude12 extends JPanel{
    private static Scanner sc = new Scanner(System.in);
    private GraphicsFrame gf = null;
    private Integer Distance = 768;
    private Integer Distance2 = Distance;
    private Integer Ratio = 1;
    

    private static ArrayList<Integer> ParamsList = new ArrayList<Integer>();
    public static void main(String[] args){
        /* 
         * Creates an implementation of the Runanble interface in a thread-safe 
         * manner. Places code executed in the run function onto the Event Dispatch
         * Thread.
         */
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                etude12 hc = new etude12();
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(hc);
                frame.pack();
                frame.setLocationRelativeTo(null);
                // call this function at the end of frame setup
                frame.setVisible(true);
            }
        });
    }
    public etude12(){
        FetchInput();
        gf = new GraphicsFrame();
    }

    private void HilbertA(Graphics2D gr, Integer Order){
        if(Order > 0){
            HilbertB(gr, Order - 1);
            gf.Line(gr, 0, Distance2 );

            HilbertA(gr, Order - 1);
            gf.Line(gr, Distance2 , 0);

            HilbertA(gr, Order - 1);
            gf.Line(gr, 0, -Distance2 );

            HilbertC(gr, Order - 1);
        }
    }

    private void HilbertB(Graphics2D gr, Integer Order){
        if(Order > 0){
            HilbertA(gr, Order - 1);
            gf.Line(gr, Distance2 , 0);

            HilbertB(gr, Order - 1);
            gf.Line(gr, 0, Distance2 );

            HilbertB(gr, Order - 1);
            gf.Line(gr, -Distance2, 0);

            HilbertD(gr, Order - 1);
        }
    }

    private void HilbertC(Graphics2D gr, Integer Order){
        if(Order > 0){
            HilbertD(gr, Order - 1);
            gf.Line(gr, -Distance2, 0);

            HilbertC(gr, Order - 1);
            gf.Line(gr, 0, -Distance2);

            HilbertC(gr, Order - 1);
            gf.Line(gr, Distance2, 0);

            HilbertA(gr, Order - 1);
        }
    }

    private void HilbertD(Graphics2D gr, Integer Order){
        if(Order > 0){
            HilbertC(gr, Order - 1);
            gf.Line(gr, 0, -Distance2);

            HilbertD(gr, Order - 1);
            gf.Line(gr, -Distance2, 0);

            HilbertD(gr, Order - 1);
            gf.Line(gr, 0, Distance2);

            HilbertB(gr, Order - 1);
        }
    }

    /**
     * Return user input to determine order and length ratio (if applicable)
     * @return an ArrayList containing user input
     */
    private ArrayList<Integer> FetchInput(){
        try{
            String Input = sc.nextLine();
            String[] InputSplit = Input.split(" ");
            switch(InputSplit.length){
                case 1:
                    ParamsList.add(Integer.parseInt(InputSplit[0]));
                    return ParamsList;
                case 2 :
                    for(String Param : InputSplit){
                        ParamsList.add(Integer.parseInt(Param));
                    }
                    Ratio = Math.round(ParamsList.get(1));
                    return ParamsList;
                default:
                    throw new RuntimeException("Invalid input");
            }
        } catch(InputMismatchException e){
            System.out.println("Input mismatch: \n" + e);
        }
        return ParamsList;
    }

    @Override
    public Dimension getPreferredSize(){
        Integer x = 768;
        Integer y = 768;
        return new Dimension(x, y);
    }
    @Override
    protected void paintComponent(Graphics gr){
        super.paintComponent(gr);
        int Order = (int)Math.round(ParamsList.get(0));
        Distance2 = Distance;
        for(int i = Order; i > 0; i--){
            Distance2 /= 2;
        }
        gf.SetCoords(Distance2 / 2, Distance2 / 2);
        Graphics2D g2d = (Graphics2D) gr.create();
        HilbertA(g2d, Order);
        g2d.dispose();  
    }
    
    private class GraphicsFrame{
        private Integer Width;
        private Integer Height;
        public GraphicsFrame(){
        }

        public void SetCoords(Integer Width, Integer Height){
            this.Width = Width;
            this.Height = Height;
        }

        public void Line(Graphics2D gr, Integer dWidth, Integer dHeight){
            gr.drawLine(Width, Height, Width + dWidth, Height + dHeight);
            Width += dWidth;
            Height += dHeight;
        }
    }
}