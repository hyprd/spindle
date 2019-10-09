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
    final String fileName = "Lab20data.txt";
    Boolean a;
    try{
      Scanner fileScan = new Scanner(new File (fileName));
        while (fileScan.hasNextLine()){
          int value1 = fileScan.nextInt();
          if (value1 == 1){
            a = true;
          } else{
            a = false;
          } 
          int value2 = fileScan.nextInt();
          Color color = Color.red;
          if (value2 == 2){
            color = Color.blue;
          }
          if (value2 == 3){
            color = Color.green;
          } else{
            color = Color.red; 
          }    
          int value3 = fileScan.nextInt();
          int value4 = fileScan.nextInt();
          int value5 = fileScan.nextInt();
          int value6 = fileScan.nextInt();
          drawObjects[count] = new Rectangle(a,color,value3,value4,value5,value6);
          count++;
          }
          setPreferredSize(new Dimension(300,300));
          setBackground(Color.yellow);
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
