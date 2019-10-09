/**
 * COSC326 Effective Programing - Etude 7
 * Write a program that takes an English sentence and translate itinto Maori.
 */
import java.util.stream.*;
import java.util.List;
import java.util.Collections;
import static java.util.stream.Collectors.*;
import java.util.ArrayList;
import java.util.Scanner;
public class LookWhosTalking{
    static Scanner scan = new Scanner(System.in);
    static List<String> markerList = Stream.of("I", "Kei te", "Ka").collect(collectingAndThen(toList(), Collections::unmodifiableList));
    public static void main(String[] args) {
        new LookWhosTalking();
        
    }
    ArrayList<String> getInput(ArrayList<String> input){
        while(scan.hasNextLine()){


        }

    }
    LookWhosTalking(){
        ArrayList<String> input = getInput();
        


    }
}