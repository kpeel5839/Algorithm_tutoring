import java.util.*; // 편의를 위해서 한번에 import

public class Main {
    public static void swap(int[] arr , int a , int b){
        // swap 을 진행해준다.(인덱스로)
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
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

        // 일단 i 를 N - 1 ~ 1 까지 진행해준다.
        for(int i = N - 1; i != 0; i--){
            // swap 이 일어나지 않을 경우 바로 끝내줄 swap 변수 선언(최고의 경우 O(n)을 보장)
            boolean swap = false;

            // i 이전까지 진행 (j + 1 , j 를 비교하기에 , i 와 같아지면 안됨
            for(int j = 0; j < i; j++){
                // 현재 요소가 , 다음 요소보다 크면 swap
                if(a[j] > a[j + 1]) swap(a , j , j + 1);
            }

            // swap 이 한번도 일어나지 않았으면 break;
            if(!swap) break;
        }

        // 결과 출력
        System.out.println(Arrays.toString(a));
    }
}
