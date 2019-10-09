import java.util.Scanner;
import java.util.ArrayList;
import java.util.stream.Stream;
public class etude7{
    private String[] ExtensionArray = {"co.nz", "co.uk", "co.ca", "com","co.us","co.uk"};
    private Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        new etude7();
    }

    public etude7(){
        Validate(Read());
    }

    private void Validate(ArrayList<String> EmailList){
        for(String Original : EmailList){
            try{
                String EmailToValidate = Original;      
                EmailToValidate = ConvertToLowerCase(EmailToValidate);
                EmailToValidate = ContainsAt(EmailToValidate);
                EmailToValidate = ContainsDot(EmailToValidate);
                ExtensionCheck(EmailToValidate);
                EmailToValidate = ValidateMailbox(EmailToValidate);
                EmailToValidate = ValidateDomain(EmailToValidate);
                System.out.println(EmailToValidate);
            } catch(RuntimeException e){
                System.out.println(Original + e.getMessage());
                e.printStackTrace();
            }     
        } 
    }

    private void ExtensionCheck(String Email){
        try{
            if(Email.charAt(Email.indexOf("@") + 1) == '[' && Email.charAt(Email.length() - 1) == ']'){
                return;
            }
            for(String Extension : ExtensionArray){
                if(Email.contains(Extension) && Email.lastIndexOf(Extension) == Email.length() - Extension.length()){
                    return;
                } 
            }        
            throw new RuntimeException(" <- Invalid extension");
        } catch(StringIndexOutOfBoundsException e){
            throw new RuntimeException(" <- Invalid domain");
        }
    }

    private String ContainsAt(String Email){
        StringBuilder ReplaceEmail = new StringBuilder(Email);
        Integer Index = ReplaceEmail.lastIndexOf("_at_");
        if(!Email.contains("_at_") && !Email.contains("@")) throw new RuntimeException(" <- Missing @ symbol");
        if(Email.contains("_at_") && !(Email.contains("@"))) ReplaceEmail.replace(Index, Index + 4, "@");
        return ReplaceEmail.toString();
    }

    private String ContainsDot(String Email){
        if(!Email.contains("_dot_") && !Email.contains(".")) throw new RuntimeException(" <- Missing . symbol");
        String DomainFull = Email.substring(Email.indexOf('@') + 1);  
        StringBuilder ReplaceEmail = new StringBuilder(Email);
        Integer Index = ReplaceEmail.lastIndexOf("_dot_");
        if(IsNumerical(Email)){
            String ReplaceDomain = DomainFull.replaceAll("_dot_", ".");
            ReplaceEmail.replace(Email.indexOf("@") + 1, Email.length(), ReplaceDomain);
        } else{
            if(Email.contains("_dot_")) ReplaceEmail.replace(Index, Index + 5, ".");
        }
        return ReplaceEmail.toString();
    }

    private Boolean IsNumerical(String Email){
        String Domain = Email.substring(Email.indexOf("@") + 1, Email.length());
        if(Domain.charAt(0) == '[' && Domain.charAt(Domain.length() - 1) == ']'){
            return true;
        } else{
            return false;
        }
    }


    private String ValidateMailbox(String Email){
        try{
            String ValidateEmail = Email.substring(0, Email.indexOf('@'));
            Character[] CharacterArray = {'.','-','_'};
            if(Stream.of("--", "..", "__", "-.", ".-", "_.", "._", "-_", "_-").anyMatch(ValidateEmail::contains)){
                throw new RuntimeException(" <- Invalid mailbox name");
            }
            for(Character ch : CharacterArray){
                if(ValidateEmail.charAt(0) == ch || ValidateEmail.charAt(ValidateEmail.length() - 1) == ch){
                    throw new RuntimeException(" <- Invalid mailbox name");
                }
            }
            String[] CharacterArrayCompare = {"[", "]", "^"};
            if(!ValidateEmail.matches("[A-z0-9_.-]+")){
                throw new RuntimeException(" <- Invalid mailbox name");
            }
            for(String ch: CharacterArrayCompare){
                if(ValidateEmail.contains(ch)) throw new RuntimeException(" <- Invalid mailbox name");                 
            }
                
            return Email;
        } catch(StringIndexOutOfBoundsException e){
            throw new RuntimeException(" <- Invalid email");
        }
    }

    private String ValidateDomain(String Email){
        // does break on string length 0 if other functions dont break it beforehand
        try{
            String DomainFull = Email.substring(Email.indexOf('@') + 1);   
            // Splice the extension from the end of the domain
            String SplicedDomain = Email;
            for(String s : ExtensionArray){
                if(SplicedDomain.contains(s)) SplicedDomain.replaceAll(s, "");
            } 
            if(Stream.of("-", "..", "_", "-.", ".-", "_.", "._", "-_", "_-").anyMatch(DomainFull::contains)){
                throw new RuntimeException(" <- Invalid domain name");
            }
            // Numerical address checking      
            if(DomainFull.charAt(0) == '[' && DomainFull.charAt(DomainFull.length() - 1) == ']'){
                String DomainBracketless = DomainFull.substring(1, DomainFull.length() - 1);
                String[] SplitArray = DomainBracketless.split("\\.");
                if(SplitArray.length != 4) throw new RuntimeException(" <- Invalid numerical address");
                for(int i = 0; i < SplitArray.length; i++){         
                    try{
                        Integer NumericalAddress = Integer.parseInt(SplitArray[i]);                
                        if(NumericalAddress < 0 || NumericalAddress > 255){
                            throw new RuntimeException(" <- Invalid numerical address size");
                        } 
                        
                    // For parsing letters into a digit sequence
                    } catch(NumberFormatException e){
                        throw new RuntimeException(" <- Invalid numerical address");
                    }
                }
                if(!DomainFull.matches("\\[+[0-9.]+]")) throw new RuntimeException(" <- Invalid domain");
            } else if(SplicedDomain.charAt(0) == '.' || SplicedDomain.charAt(SplicedDomain.length() - 1) == '.'){
                throw new RuntimeException(" <- Invalid domain");
            } else{
                // This checks for single dots :)
                if(!DomainFull.matches("([A-z.]+)+")) throw new RuntimeException(" <- Invalid domain ");
            }
            return Email;
        } catch(StringIndexOutOfBoundsException e){
            throw new RuntimeException(" <- Invalid email");
        } 
    }

    private ArrayList<String> Read(){
        ArrayList<String> EmailList = new ArrayList<String>();
        while(sc.hasNextLine()){
            EmailList.add(sc.nextLine());
        }
        return EmailList;        
    }
    
    private String ConvertToLowerCase(String Email){
        return Email.toLowerCase(); 
    }
 }
