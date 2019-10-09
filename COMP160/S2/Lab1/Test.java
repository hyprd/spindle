public class Test {
  public static void main (String[] args) {
    System.out.println("An Emergency Broadcast");
  }
}


/**
 * 2a. The class 'test' should be declared in a file named test.java
 * 2b. No errors produced, since only the editable string is being changed
 * 2c. Compiler expecting a closing brace and a closed string, considers it a non-statement
 * 2d. Compiler recognises the string is unclosed, is expecting a ' ; ' as the one already there is considered part of the string
 *       and reached the end of the file without parsing
 * 2e. Class does not have a static void main method accepting String[]
 * 2f. Cannot find symbol : method bogus (java.lang.String)
 * 2g. Compiler expects a semicolon
 * 2h. Reached end of file while parsing
 */

 