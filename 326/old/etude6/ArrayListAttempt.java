/*
        
         An attempt to use collections instead of regular arrays. didn't work!

        char[] FirstDigits = First.toCharArray(), SecondDigits = Second.toCharArray();  
        System.out.println("FirstDigits length: " + FirstDigits.length);
        System.out.println("SecondDigits length: " + SecondDigits.length);
        Integer FirstSize = FirstDigits.length, Size = FirstSize + 1, SecondSize = SecondDigits.length, Iterator = 0, Remainder = 0;
        if(SecondSize > FirstDigits.length){
            Size = SecondSize + 1;
        } else if(SecondSize.equals(FirstDigits.length)){
            Size++;
        }
        ArrayList<Integer> FirstNumberList = new ArrayList<Integer>(Collections.nCopies(Size, 0));
        int count = 0;
        for(char c : FirstDigits){
            FirstNumberList.set(count, Character.getNumericValue(c));  
            count++;
        }
        count = 0;
        ArrayList<Integer> SecondNumberList = new ArrayList<Integer>(Collections.nCopies(Size, 0));
        for(char c: SecondDigits){
            SecondNumberList.set(count, Character.getNumericValue(c));  
            count++;
        }
        count = 0;
        Collections.reverse(FirstNumberList);
        Collections.reverse(SecondNumberList);

        ArrayList<Integer> SumList = new ArrayList<Integer>(Collections.nCopies(Size, null));
        Iterator = Size - 1;
        for(int i = 0; i < Size; i++){
            SumList.set(Iterator, FirstNumberList.get(i) + SecondNumberList.get(i));
            Iterator--;
        }
        /*
        System.out.println("Array Method: ");
        Integer[] Sum = new Integer[Size];
        System.out.println("Size of sum: " + Sum.length);
        Iterator = Size - 1;
        System.out.println("FirstNumberList size: " + FirstNumberList.size());
        System.out.println("SecondNumberList size: " + SecondNumberList.size());

        for(int i = 0; i < Size; i++){
            Sum[Iterator] = FirstNumberList.get(i) + SecondNumberList.get(i);
            Iterator--;
            System.out.println(Arrays.toString(Sum));
        }
        System.out.println(Arrays.toString(Sum));     
        

        for (int u = Size - 1; u >= 0; u--){
            if(SumList.get(u) >= BaseValue){
                SumList.set(u, SumList.get(u) - BaseValue); 
                SumList.set(u - 1, SumList.get(u) + 1);
            } 
        }      
        ArrayList<Integer> DivisorList = new ArrayList<Integer>();
        for(Integer i : SumList){
            DivisorList.add(i);
        }
        ArrayList<Integer> QuotientList = new ArrayList<Integer>(Size);
        for(int y = 0; y < Size; y++){
            QuotientList.add(DivisorList.get(y) / 2);
            if(DivisorList.get(y) % 2 == 1){
                if(y != Size - 1){
                    DivisorList.set(y + 1, DivisorList.get(y) + BaseValue);
                } else{
                    Remainder = 1;
                }
            }
        } 
        System.out.println("###########################\n");
        System.out.println("Sum List: \n" + SumList);
        System.out.println("Divisior List: \n" + DivisorList);
        System.out.println("Quotient List: \n" + QuotientList);
        System.out.println("###########################\n");
        for(int i: SumList){
            if(i == 0) SumList.remove(SumList.get(SumList.indexOf(i)));
        }


        System.out.println("Base " + BaseValue + " Sum: ");
        Boolean Placeholder = false;
        for(int j : SumList){
            //System.out.println("\nj: " + j + "\n");
            if(j != 0) Placeholder = true;
            if(Placeholder) System.out.print(j);
        }    
        System.out.println("\nQuotient: ");    
        Placeholder = false;
        for(int a : QuotientList){
            //System.out.println("\na: " + a + "\n");
            if(a != 0) Placeholder = true;
            if(Placeholder) System.out.print(a);
        }
        System.out.println("\nRemainder: " + Remainder);

        */