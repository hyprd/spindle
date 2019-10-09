//COMP160 LAB6 Part 2 - Book.java - Ethan Simmonds - August 2016
import java.text.NumberFormat;
/**  
 * Book.java
 * 
 * Stores and displays information about an individual Book.
 */
public class Book {
 //data field declaration
 private String title;
 private int numPages;
 private double price;
 
 //title of book with param t
 public void setTitle(String t){
  title = t;
 }
 //number of pages with param n
 public void setPages(int n){
  numPages = n;
 }
 //price of book with param p
 public void setPrice(double p){
  price = p;
 }
 //returns book title
 public String getTitle(){
  return title;
 }
 //returns page count
 public int getNumPages(){
  return numPages;
 }
 //returns book price
 public double getPrice(){
  return price;
 }
 //display the Book information to the console window
 public void displayBook(){
  NumberFormat fmt = NumberFormat.getCurrencyInstance(); //formatting price
  System.out.println("The name of the book is " + title);
  System.out.println("It has " + numPages +" pages.");
  System.out.println("You can buy this book for "+ fmt.format(price));
  System.out.println("***********************************************");
  
 }
 
 } 


