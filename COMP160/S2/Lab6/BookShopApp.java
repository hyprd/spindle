//COMP160 LAB6 Part 2 - BookShopApp.java - Ethan Simmonds - August 2016
public class BookShopApp {
 public static void main(String[] args){
  //first book information
  Book book1 = new Book();
  book1.setTitle("Life of Pi");
  book1.setPages(273);
  book1.setPrice(27.90);
  //call book 1 information
  book1.displayBook();
  
  //second book information
  Book book2 = new Book();
  book2.setTitle("Mister Pip");
  book2.setPages(240);
  book2.setPrice(22.70);
  //call book 2 information
  book2.displayBook();
  
  //third book information
  Book book3 = new Book();
  book3.setTitle("Fahrenheit 451");
  book3.setPages(159);
  book3.setPrice(15.99);
  //call book 3 information
  book3.displayBook();
  
  
  
  
  
  
  
 }
 


}
