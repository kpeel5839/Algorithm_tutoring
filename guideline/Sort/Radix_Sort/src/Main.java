import java.util.*;

// Radix_Sort

public class Main {
    public static void radixSort(int[] arr){

    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = input.nextInt();
        }

        radixSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
