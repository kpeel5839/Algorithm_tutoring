import java.util.*; // 편의를 위해서 한번에 import

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        // 배열 크기 입력 받기
        int N = input.nextInt();

        // 배열 선언
        int[] a = new int[N];

        for(int i = 0; i < N; i++){
            // 배열 입력 받기
            a[i] = input.nextInt();
        }


        // 결과 출력
        System.out.println(Arrays.toString(a));
    }
}
