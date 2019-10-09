import java.io.*;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
/** FilePanel.java
  * Lab 20, COMP160,  2016
  * 
  * a JPanel which creates 2 instances of Rectangle objects, 
  * stores them in an array, and draws them 
  */
public class FilePanel extends JPanel{
  private Rectangle[] drawObjects = new Rectangle [10];
  private int count;
  
  
  /**constructor instantiates 6 Rectangle objects*/
  public FilePanel(){  
    final String fileName = "LongBadData.txt"; 
    try {
      Scanner fileScan = new Scanner(new File (fileName));
      while (fileScan.hasNextLine() && count < drawObjects.length){
        String inputLine = fileScan.nextLine();
        /* Declare values based on each line with delimiters to remove erroneous values from appearing*/
        if (inputLine.matches("\\d+ \\d+ \\d+ \\d+ \\d+ \\d+")){
          Scanner lineScan = new Scanner(inputLine);
          
          //fill value
          int fillInt = lineScan.nextInt();
          Boolean fill;
          if (fillInt == 1) {
            fill = true;
          } else {
            fill = false;
          } 
          
          //colour value
          int colorInt = lineScan.nextInt();
          Color color;
          if (colorInt == 2) {
            color = Color.blue;
          } else if (colorInt == 3) {
            color = Color.green;
          } else{
            color = Color.red; 
          }
          //rest of values declared
          int x = lineScan.nextInt();
          int y = lineScan.nextInt();
          int width = lineScan.nextInt();
          int height = lineScan.nextInt();
          
          drawObjects[count] = new Rectangle(fill, color, x, y, width, height);
          count++;
        }
        setPreferredSize(new Dimension(300,300));
        setBackground(Color.yellow);
      }
     }
    
    catch (FileNotFoundException e){  
      System.out.println("File not found. Check name and location");
      System.exit(1);   
    }    
  }

  /**each Rectangle will draw itself*/
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    for(int i = 0; i < count; i++){
      drawObjects[i].draw(g);
    } 
  }
}

   