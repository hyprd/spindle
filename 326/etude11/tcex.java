public class tcex{
    public static void main(String[] args) {
        int val = -847;
        int[] arr = {7,4,8}; 
        StringBuilder build = new StringBuilder();
        System.out.println("Printing -847 in two's complement as a value:\n" + Integer.toBinaryString(val));
        System.out.println("Printing -847 in two's complement as an array: ");
        for(int v : arr){
            build.append(Integer.toBinaryString(-v));
        }
        System.out.println(build.toString()); 
    }
}