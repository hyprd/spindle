/** FilePanel.java
  * Lab 20, COMP160,  2016
  * 
  * a JPanel which creates 2 instances of Rectangle objects, 
  * stores them in an array, and draws them 
  */

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class FilePanel extends JPanel{
  private Rectangle[] drawObjects = new Rectangle [10];
  private int count;
  
  
  /**constructor instantiates 6 Rectangle objects*/
  public FilePanel(){  
    String fileName = "Lab20data.txt";
    try{
      Scanner fileScan = new Scanner(new File ( fileName));
      //try while another line exists in file
      while (fileScan.hasNextLine()){
        //limit rectangle amount in array
        while (count < drawObjects.length){
          String inputLine = fileScan.nextLine();
          if (inputLine.matches("\\d+ \\d+ \\d+ \\d+ \\d+ \\d+")){
            Scanner intScan = new Scanner(inputLine);
            System.out.println(intScan.nextInt());
            
            //Handle fill of the rectangle
            int fillInt = intScan.nextInt();
            boolean fill = false;
            if (fillInt == 1){
              fill = true;
            } 
            else{ 
              fill = false;
            }
            
            //Handle rectangle colouring
            int colourInt = intScan.nextInt();
            Color colour;
            if (colourInt == 2){
              colour = Color.blue; 
            } else if (colourInt == 3){
              colour = Color.green;
            } else{
              colour = Color.red;
            }
            
            //Instantiate and set remaining values
            int x = intScan.nextInt();
            int y = intScan.nextInt();
            int width = intScan.nextInt();
            int height = intScan.nextInt();
            
            drawObjects[count] = new Rectangle(fill, colour, x, y, width, height);
            count++;
          } 
        }
        setPreferredSize(new Dimension(300,300));
        setBackground(Color.yellow);
      }
    }
    catch(FileNotFoundException e){
      System.out.println("File not found. Check name and location");
      System.exit(1);
      
    }
    
    
    /* Deprecated rectangle code
     drawObjects[count] = new Rectangle(false,Color.blue, 50, 50,30,30);
     count++;
     setPreferredSize(new Dimension(300,300));
     setBackground(Color.yellow);
     */
  }
  
  /**each Rectangle will draw itself*/
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    for(int i = 0; i < count; i++){
      drawObjects[i].draw(g);
    } 
  }
}
