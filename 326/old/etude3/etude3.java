import java.util.*;
public class etude3{    
    public static Integer Size = 9000000, LargestLoop = 0, LoopTotal = 0, FormatCount = 0;
    public static HashSet<Integer> PreviousValues = new HashSet<Integer>(), InstanceValues = new HashSet<Integer>();
    public static HashSet<Integer> FinalValues = new HashSet<Integer>(), LoopValues = new HashSet<Integer>();
    public static void main(String[] args){ new etude3(); }
    public etude3(){ Evaluate(); }
    private void Evaluate(){
        long StartTime = System.currentTimeMillis();
        for(int i = 1; i <= Size; i++){
            if(i % 10000 == 0){
                System.out.println(i);
            }
            Integer CurrentValue = i;
            InstanceValues.add(CurrentValue);
            while(CurrentValue != 1 && CurrentValue < Size && !IsPerfect(CurrentValue) && !PreviousValues.contains(CurrentValue)){
                Integer NextValue = FindSum(CurrentValue);
                if(NextValue == CurrentValue){
                    LoopValues.add(NextValue);
                    CountLoopLength(CurrentValue);
                    LoopTotal++;
                    break;
                } else{
                    CurrentValue = NextValue;
                    if(InstanceValues.contains(CurrentValue)){
                        LoopValues.add(CurrentValue);
                        CountLoopLength(CurrentValue);
                        PreviousValues.add(CurrentValue);
                        LoopTotal++;
                        break;
                    }
                    InstanceValues.add(CurrentValue);
                }
            }
            PreviousValues.addAll(InstanceValues);
            InstanceValues.clear();
        }
        ArrayList<Integer> PresentList = new ArrayList<Integer>(FinalValues);
        Collections.sort(PresentList);
        for(Integer val : PresentList){
            if(FormatCount % 5 == 0){
                System.out.print(String.format("\n%-9d", val));
            } else{
                System.out.print(String.format("%-9d", val));
            }
            FormatCount++;
        }

        long EndTime = System.currentTimeMillis();
        long Elapsed = (EndTime - StartTime) / 1000;
        System.out.println("\nElapsed time: " + Elapsed + " seconds");
        System.out.println("Total number of loops: " + LoopTotal);
        System.out.println("Largest Loop: " + LargestLoop);
        System.out.println("Total loopy numbers found: " + PresentList.size());
    }

    private Boolean IsPerfect(Integer Number){
        Integer Sum = FindSum(Number);
        if(Sum == Number) return true;
        return false;
    }

    private void CountLoopLength(int Number) {
        Integer Count = 2;
        FinalValues.add(Number);
        Integer CurrentValue = FindSum(Number);
        FinalValues.add(CurrentValue);
        while (FindSum(CurrentValue) != Number) {
            CurrentValue = FindSum(CurrentValue);
            FinalValues.add(CurrentValue);
            Count++;
        }
        if (Count > LargestLoop) {
            LargestLoop = Count;
        }
    }

    private Integer FindSum(Integer Number){
        Integer Maximum = (int)Math.sqrt(Number), Sum = 1;
        for(int i = 2; i <= Maximum; i++){
            if(Number % i == 0){
                Sum += i;
                Integer Divisor = Number / i;
                if(Divisor != i){
                    Sum += Divisor;
                }
            }
        } return Sum; 
    }
}