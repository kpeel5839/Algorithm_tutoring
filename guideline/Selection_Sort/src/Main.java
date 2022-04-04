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

        // i 를 1 까지 진행
        for(int i = N - 1; i != 0; i--){
            // 현재 제일 큰 값의 index를 저장하기 위한 max 변수
            int max = 0;

            // j <= i 까지 반복하면서 max 값의 index 값을 구함
            for(int j = 0; j <= i; j++){
                if(a[max] < a[j]) max = j;
            }

            // max 값의 index를 구하였으니 , i <-> max
            int tmp = a[i];
            a[i] = a[max];
            a[max] = tmp;
        }

        System.out.println(Arrays.toString(a));
    }
}
