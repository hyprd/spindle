//********************************************************************
//  COMP160 Lab 19 - StyleOptionsPanel.java - Ethan Simmonds - September 2016
//  StyleOptionsPanel.java      adapted from Java Foundations
//
//  Demonstrates the use of radio buttons and listeners.
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
  private JRadioButton fontcourier, fonttimesnewroman, fonthelvetica;
  
  //-----------------------------------------------------------------
  //  Sets up a panel with a label and some check boxes that
  //  control the style of the label's font.
  //-----------------------------------------------------------------
  public StyleOptionsPanel()
  {
    setLayout (new GridLayout(6,1));
    
    //create radio buttons
    fontcourier = new JRadioButton("Courier");
    fonttimesnewroman = new JRadioButton("Times New Roman");
    fonthelvetica = new JRadioButton("Helvetica",true);
    
    //create button listeners to allow typeFace selection states
    ButtonListener bListener = new ButtonListener();
    fontcourier.addActionListener(bListener);
    fonttimesnewroman.addActionListener(bListener);
    fonthelvetica.addActionListener(bListener);
    
    //grouping the radio buttons os they are related
    ButtonGroup group = new ButtonGroup();
    group.add(fontcourier);
    group.add(fonttimesnewroman);
    group.add(fonthelvetica);

    saying = new JLabel ("Say it with style!");
    saying.setFont (new Font (typeFace, style, 20));
    
    bold = new JCheckBox ("Bold");
    bold.setBackground (Color.cyan);
    italic = new JCheckBox ("Italic");
    italic.setBackground (Color.cyan);
    
    StyleListener listener = new StyleListener();
    bold.addItemListener (listener);
    italic.addItemListener (listener);
    
    
    add (saying);
    add (bold);
    add (italic);
    add (fontcourier);
    add (fonttimesnewroman);
    add (fonthelvetica);
    
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
      
      saying.setFont (new Font (typeFace, style, 20));
    }
    
  }
  //method containing logic based on a selected listener
  private class ButtonListener implements ActionListener{
    //when an action occurs, invoke this method
    public void actionPerformed(ActionEvent event){
      Object source = event.getSource();
      
      if (source == fontcourier)
        typeFace = "Courier";
      
      else if (source == fonttimesnewroman)
        typeFace = "Times New Roman";
      
      else if (source == fonthelvetica)
        typeFace = "Helvetica";
      
      saying.setFont (new Font (typeFace, style, 20)); 
      
    }
  }
}