import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class PokerHands {
    public static void main(String[] args) {
        new PokerHands();
    }
    /**
     * Retrieve the input from file.
     * @param scan the scanner object to retrieve file contents
     * @return input
     */
    ArrayList<String> fetchInput(Scanner scan){
        ArrayList<String> input = new ArrayList<String>();
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            if(!line.startsWith("#") ){
                input.add(line);
            }
        }
        return input;
    }

    PokerHands(){
        Scanner scan = new Scanner(System.in);
        ArrayList<String> inputList = fetchInput(scan);
        sanitizeInput(inputList);
    }
    /**
     * Perform input checking and prepare for conversion to valid Card instances.
     * @param input the input from the file
     */
    void sanitizeInput(ArrayList<String> input){
        String alphabetSeparatorCheck = "[0-9A-z /-]+";
        for(String line : input){
            ArrayList<Character> separatorList = new ArrayList<Character>();
            // Original, unedited line to print the correct line format when error catching.
            String lineOutput = line;
            if(!line.matches(alphabetSeparatorCheck) && !line.matches(alphabetSeparatorCheck)){
                System.out.println("Invalid: " + lineOutput);
                continue;
            }
            // Count the total amount of each separator character.
            for(int characterIterator = 0; characterIterator < line.length(); characterIterator++){
                char character = line.charAt(characterIterator);
                switch(character){
                    case '-':
                        separatorList.add('-');
                        break;
                    case ' ':
                        separatorList.add(' ');
                        break;
                    case '/':
                        separatorList.add('/');
                        break;
                    default:
                        break;
                }
            }
            // If there are more than one different type of separator, or the amount of separators
            // is greater or lesser than expected, input is invalid.
            if(separatorList.isEmpty() || !separatorList.stream().allMatch(separatorList.get(0)::equals) || separatorList.size() != 4){
                System.out.println("Invalid: " + lineOutput);
                continue;
            }
            
            // Convert all separator characters to whitespace and split input into individual cards. 
            String lineFormatted = line.replaceAll("/", " ").replaceAll("-", " ");
            List<String> splitList = Arrays.asList(lineFormatted.split(" "));
            // If splitting list is empty (for whatever reason) or a proper hand isn't specified, input
            // is invalid.
            if(splitList.isEmpty() || splitList.size() != 5){
                System.out.println("Invalid: " + lineOutput);
                continue;
            }
            splitList.replaceAll(String::toUpperCase);
            validateCards(splitList, lineOutput);
        }
    }
    /**
     * Validate and rearrange the card set.
     * @param cardList cards
     * @return sorted card list
     */
    void validateCards(List<String> sanitizedList, String lineOutput){
        ArrayList<Card> cardList = new ArrayList<Card>();
        char cardSuit = '0';
        int cardNumber = 0;
        for(String card : sanitizedList){
            // Determine length of the card. Cards which are shorter than 2 characters or longer
            // than 3 are invalid.
            if(card.length() < 2 || card.length() > 3){
                System.out.println("Invalid: " + lineOutput);
                cardList.clear();
                return;
            }
            // The suit should always be the end value of a card.
            cardSuit = card.charAt(card.length() - 1);
            // If the character captured is not a valid suit, or is still its default assignment (0)
            // it is invalid.
            if(!Character.toString(cardSuit).matches("[CDHS]+") || Character.isDigit(cardSuit)){
                System.out.println("Invalid: " + lineOutput);
                return;
            }
            // Fetch the card number and check its value
            // Long card number are ones > 10 (including ace).
            boolean isLong = (card.length() == 3) ? true : false;
            if(isLong){
                // Concatenate two characters into a single integer
                cardNumber = Integer.parseInt(Integer.toString(Character.getNumericValue(card.charAt(0))) + Integer.toString(Character.getNumericValue(card.charAt(1))));
                if(cardNumber > 13){
                    System.out.println("Invalid: " + lineOutput);
                    return;
                }
            } else{
                if(Character.isDigit(card.charAt(0))){
                    cardNumber = Character.getNumericValue(card.charAt(0));
                    if(cardNumber == 1) cardNumber = 14;
                } else{
                    switch(card.charAt(0)){
                        case 'J':
                            cardNumber = 11;
                            break;
                        case 'Q':
                            cardNumber = 12;
                            break;
                        case 'K':
                            cardNumber = 13;
                            break;
                        case 'A':
                            cardNumber = 14;
                            break;
                        default:
                            System.out.println("Invalid: " + lineOutput);
                            cardList.clear();
                            return;
                    }
                }
            }
            cardList.add(new Card(cardSuit, cardNumber));
        }
        formatHand(cardList, lineOutput);
    }

    void formatHand(ArrayList<Card> cardList, String lineOutput){
        // Rearrange cards by rank
        Comparator<Card> cardComparator = Comparator.comparingInt(Card::getNumber).thenComparingInt(Card::getSuitRank);
        Collections.sort(cardList, cardComparator);
        for(int i = 0; i < cardList.size() - 1; i++){
            if((cardList.get(i).getNumber() == cardList.get(i + 1).getNumber()) && (cardList.get(i).suitRank == cardList.get(i + 1).suitRank)){
                System.out.println("Invalid: " + lineOutput);
                return;
            }

        }
        StringBuilder sb = new StringBuilder();
        for(Card card : cardList){
            switch(card.getNumber()){
                case 1: case 14:
                    sb.append("A");
                    break;
                case 11:
                    sb.append("J");
                    break;
                case 12:
                    sb.append("Q");
                    break;
                case 13:
                    sb.append("K");
                    break;
                default:
                    sb.append(card.getNumber());
                    break;
            }
            switch(card.getSuitRank()){
                case 1:
                    sb.append("C ");
                    break;
                case 2:
                    sb.append("D ");
                    break;
                case 3:
                    sb.append("H ");
                    break;
                case 4:
                    sb.append("S ");
                    break;
            }
        }
        System.out.println(sb.toString());
        return;
    }

    /**
     * Class for card instances
     */
    private class Card{
        int number;
        int suitRank;
        public Card(char suit, int number){
            this.number = number;
            switch(suit){
                case 'C':
                    this.suitRank = 1;
                    break;
                case 'D':
                    this.suitRank = 2;
                    break;    
                case 'H':
                    this.suitRank = 3;
                    break;
                case 'S':
                    this.suitRank = 4;
                    break;
            }
        }
        public int getSuitRank(){
            return suitRank;
        }
        public int getNumber(){
            return number;
        }
    }
}
