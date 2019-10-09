import java.awt.*;
public class Square{
        private Color colour;
        private double scale;
        private int layer;
        
        public Square(double scale, int r, int g, int b, int layer){
            this.scale = scale;
            this.layer = layer;
            try{
                this.colour = new Color(r, g, b);
            } catch(IllegalArgumentException e){
                System.out.println("Colour range is between 0 - 255");            
            }
        }
        // getter functions
        public Double getScale(){
            return scale;
        }
        public Color getColour(){
            return colour;
        }
        public int getLayer(){
            return layer;
        }
    }