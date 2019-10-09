import java.util.*;
public class etude1{
    private static Queue<Integer> Queue = new LinkedList<Integer>();
    private static Scanner sc = new Scanner(System.in);
    static Integer Count = 0;
    static Integer BreakPointHeads = 0;
    static Integer BreakPointTails = 0;
    enum Classification{
        H,
        T
    }
    public static void main(String[] args){
        ArrayList<Coin> CoinsList = new ArrayList<Coin>();
        ArrayList<Integer> TotalMoveCountsList = new ArrayList<Integer>();
        ArrayList<Integer> IndexesList = new ArrayList<Integer>();
        System.out.println("1 to enter input");
        System.out.println("2 to print 2 < n < 20");
        Integer Choice = sc.nextInt();
        switch(Choice){
            case 1:
                Count = 0;
                CoinsList.clear();
                System.out.println("Enter heads");
                Integer HeadsCount = sc.nextInt();
                Integer TailsCount = HeadsCount;
                for(int k = 0; k < HeadsCount; k++){
                    CoinsList.add(new Coin(1));
                }
                for(int p = 0 ; p < TailsCount; p++){
                    CoinsList.add(new Coin(0));
                }
                Evaluate(CoinsList);
                System.out.println("\nMove Count: " + Count);
                break;
            case 2:
                for(int i = 2; i < 20; i++){
                    CoinsList.clear();
                    Count = 0;
                    for(int u = 0; u < i; u++){
                        CoinsList.add(new Coin(0));
                    }
                    for(int j = 0; j < i; j++){
                        CoinsList.add(new Coin(1));
                    }
                    Evaluate(CoinsList);
                    TotalMoveCountsList.add(Count);
                    IndexesList.add(i);
                }
                System.out.println("\nTotal move counts: ");
                for(int i = 0; i < TotalMoveCountsList.size(); i++){
                    System.out.println("n: " + IndexesList.get(i) + "\tcount: " + TotalMoveCountsList.get(i));
                }
                break;
        }
    }

    public static void Sweep(ArrayList<Coin> Coins){
        for(int i = 0; i < Coins.size() - 1; i++){   
            if(!(Coins.get(i).value.equals(Coins.get(i + 1).value))){      
                    Queue.add(i);
                    i++;                                                                                             
            } 
        } 
    }
    private static void Swap(ArrayList<Coin> Coins){
        Coin First = Coins.get(Queue.peek());
        Coin Second = Coins.get(Queue.peek() + 1);
        Coin Handoff = Coins.get(Queue.peek() + 1);
        Second = First;
        First = Handoff;
        Coins.set(Queue.peek(), First);
        Coins.set(Queue.peek() + 1, Second);
        Queue.remove(); 
        Count++; 
        for(Coin c : Coins){
            if(c.value.equals(0)) System.out.print(Classification.T + " ");
            if(c.value.equals(1)) System.out.print(Classification.H + " ");
        } 
        System.out.println();
    }

    public static ArrayList<Coin> Evaluate(ArrayList<Coin> Coins){
        Sweep(Coins);
        System.out.println();
        Boolean IsAlternating = false;
        while(!IsAlternating){    
            Swap(Coins);
            if(Queue.isEmpty()){
                Boolean TailsCheck = (CheckTailsSequence(Coins) ? true : false);
                Boolean HeadsCheck = (CheckHeadsSequence(Coins) ? true : false);   
                if(TailsCheck && HeadsCheck){
                    IsAlternating = true;
                    
                } else{               
                    Sweep(Coins);
                }
            }  
        }
        return Coins;
    }
    
    private static Boolean CheckHeadsSequence(ArrayList<Coin> Coins){
        BreakPointHeads = 0;
        Boolean CheckHeads = false;
        ArrayList<Integer> HeadsSequence = new ArrayList<Integer>();               
        for(int u = 0; u < Coins.size(); u++){
            HeadsSequence.add(Coins.get(u).value);
            u++;
        }
        for(int k = 0; k < HeadsSequence.size(); k++){
            if(HeadsSequence.get(0).equals(HeadsSequence.get(k))){
                CheckHeads = true;
            } else{
                BreakPointHeads = k;
                return false;
            }
        }
        return CheckHeads;
    }

    private static Boolean CheckTailsSequence(ArrayList<Coin> Coins){
        BreakPointTails = 0;
        ArrayList<Integer> TailsSequence = new ArrayList<Integer>();
        Boolean CheckTails = false;           
        for(int u = 1; u < Coins.size(); u++){
            TailsSequence.add(Coins.get(u).value);
            u++;
        }
        for(int i = 0; i < TailsSequence.size(); i++){
            if(TailsSequence.get(0).equals(TailsSequence.get(i))){
                CheckTails = true;
            } else{
                BreakPointTails = i;
                return false;
            }
        }
        return CheckTails;
    }  
    private static class Coin{
        public Integer value;
        public Coin(Integer coinValue){
            this.value = coinValue;
        }
    }
}

