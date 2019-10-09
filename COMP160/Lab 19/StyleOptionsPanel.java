//********************************************************************
//  StyleOptionsPanel.java      adapted from Java Foundations
//
//  Demonstrates the use of check boxes.
//********************************************************************

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StyleOptionsPanel extends JPanel
{
  private JLabel saying;
  private JCheckBox bold, italic;
  private int style = Font.PLAIN;
  private String typeFace = "Helvetica";
  private JRadioButton fontCourier, fontTimes, fontHelvetica;
  
  //-----------------------------------------------------------------
  //  Sets up a panel with a label and some check boxes that
  //  control the style of the label's font.
  //-----------------------------------------------------------------
  public StyleOptionsPanel()
  {
    setLayout (new GridLayout(6,1));
    
    JRadioButton fontCourier = new JRadioButton("Courier",true);
    JRadioButton fontTimes = new JRadioButton("Times New Roman");
    JRadioButton fontHelvetica = new JRadioButton("Helvetica");
    
    ButtonGroup group = new ButtonGroup();
    group.add(fontCourier);
    group.add(fontTimes);
    group.add(fontHelvetica);
    
    saying = new JLabel ("Say it with style!");
    saying.setFont (new Font (typeFace, style, 20));
    
    bold = new JCheckBox ("Bold");
    bold.setBackground (Color.cyan);
    italic = new JCheckBox ("Italic");
    italic.setBackground (Color.cyan);
    
    StyleListener listener = new StyleListener();
    bold.addItemListener (listener);
    italic.addItemListener (listener);
    
    fontCourier.addItemListener(listener);
    fontTimes.addItemListener(listener);
    fontHelvetica.addItemListener(listener);
    
    add (saying);
    add (bold);
    add (italic);
    add (fontCourier);
    add (fontTimes);
    add (fontHelvetica);
    
    setBackground (Color.cyan);
    setPreferredSize (new Dimension(300, 100));
  }
  
  //*****************************************************************
  //  Represents the listener for both check boxes.
  //*****************************************************************
  private class StyleListener implements ItemListener
  {
    
    //--------------------------------------------------------------
    //  Updates the style of the label font style.
    //--------------------------------------------------------------
    public void itemStateChanged (ItemEvent event)
    {
      style = Font.PLAIN;
      
      if (bold.isSelected())
        style = Font.BOLD;
      
      if (italic.isSelected())
        style += Font.ITALIC;
      
      /*if(fontCourier.isSelected())
        typeFace = "Courier";
     
      if (fontTimes.isSelected())
        typeFace = "TimesNew";
      
      if (fontHelvetica.isSelected())
        typeFace = "Helvetica"; */
      
      saying.setFont (new Font (typeFace, style, 20));
    }
  }
}