import java.util.*;
import java.util.stream.Stream;
import java.nio.file.*;
import java.nio.File.Paths;
import java.io.*;
import java.util.List;
public class etude13{
    private ArrayList<Integer> Input = new ArrayList<Integer>();
    final String FILENAME = "test.txt";

    public static void main(String[] args){

    }
    public etude13(){

    }
    private void FetchInput(){
        List<String> List = null;
        try(Stream<String> stream = Files.lines(Paths.get(FILENAME))){
            list = lines.collect(Collectors.toList());
            System.out.println(list);
        } catch(IOException e){
            System.out.println("Couldn't get input");
            System.out.println(e);
        }
    }
}