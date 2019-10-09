/** COMP 160 Lab 10 - Year.java 
  * Ethan Simmonds - January 2017
  * Determine whether a given year is a leap year or not
  */
public class Year {
  /** Main method will call the leapYear method with given input parameters*/
  public static void main (String[] args){
    leapYear(2014);
    leapYear(2016);
    leapYear(1900);
    leapYear(2000);
    leapYear(1562);
    
  }
  /** Contains logic for calculating whether a leap year exist for a given input parameter*/
  public static void leapYear(int year){
    // Year predates Gregorian calendar
    if (year < 1582){
      System.out.println(year + " predates the Gregorian Calendar.");
    } 
    // Year is divisible by 4, 100 and 400
    else if (year % 4 == 0 && year % 100 == 0 && year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)){
      System.out.println(year + " is a leap year.");
    }
    else{
      System.out.println(year + " is not a leap year.");
    }    
  }
}


