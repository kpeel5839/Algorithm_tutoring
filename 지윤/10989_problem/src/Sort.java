import java.util.Scanner;

public class Sort {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		int count=sc.nextInt();
		int[]num = new int[count]; 
		int[]sorted;
		int max=0; 
		 
		for (int i = 0; i < count ; i++) {
			num[i]=sc.nextInt();
			if(max<count) max=count;
		}
		
		sorted=countingSort(num,max);
		
		for (int number: sorted) {
			System.out.println(number);
		}
	}
		
	public static int[] countingSort(int[] count, int inMax){
	        int max = inMax; 
	        int[] Array = new int[max + 1]; 
	        int[] sorted = new int[count.length]; 
	        
	        for (int idx: count){
	            Array[idx] ++;  
	        }
	        
	      
	        for (int i= 1; i<Array.length; i++){
	            Array[i]+= Array[i-1]; 
	        }
	       
	        for (int i = count.length-1; i>=0; i--){
	            int number = count[i]; 
	            sorted[--Array[number]] = number; 
	        }
	        
	        return sorted; 
	        
	    }
}
