/** Lab 2 COMP160 Part 3 FillRestaurant.java
  * Ethan Simmonds July 2016
  */
public class FillRestaurant{
  public static void main(String[] args){
    final int MAX_OCCUPANCY = 300;
    final int BUS_CAPACITY = 35;
    final int VAN_CAPACITY = 8;
    
    final int numBusBooked = 4; 
    final int numVanBooked = 2;
    
    int busDiners = numBusBooked * BUS_CAPACITY;
    int vanDiners = numVanBooked * VAN_CAPACITY;
    int totalDiners = busDiners + vanDiners;
    
    final String DATE = "30th July 2016"; 
    System.out.println("Seats left for "+ DATE+ " : "+(MAX_OCCUPANCY - totalDiners));
    
    
  }
}