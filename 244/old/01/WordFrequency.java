import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class WordFrequency{
    public static void main(String[] args) throws Exception{
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        new WordFrequency(scan);     
    }
    
    WordFrequency(Scanner scan){
        StringBuilder sb = new StringBuilder();
        while(scan.hasNextLine()){
            sb.append(scan.nextLine());
        }
        
        String stream = sb.toString().replaceAll("[^A-z0-9]", " ").replace("  ", " ").toLowerCase();
        ArrayList<String> WordList = new ArrayList<String>(Arrays.asList(stream.split(" ")));
        Collections.sort(WordList);
        Integer WordCount = 0;
        for(int i = 0; i < WordList.size() - 1; i++){
            String Word = WordList.get(i);
            WordCount++;
            if(!WordList.get(i + 1).equals(Word)){
                System.out.println(WordCount + " " + Word);
                WordCount = 0;
            }
        }       
    }               
}
