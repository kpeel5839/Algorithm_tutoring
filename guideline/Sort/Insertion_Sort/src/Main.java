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

        // 1 번부터 N - 1 번까지 진행
        for(int i = 1; i < N; i++){
            // 비교를 시작할 위치를 지정
            int loc = i - 1;

            // 현재 숫자를 뽑아냄 , 이 숫자가 들어갈 수 있는 적절한 위치를 찾을 것임
            int newItem = a[i];

            // loc 의 자리가 -1 이 아니고 , 현재 a[i] 가 비교하는 것보다 작을 때 진행
            while(loc >= 0 && newItem < a[loc]){
                // 현재 a[loc] 이 a[i] 보다 크니까 , 앞으로 땡김
                a[loc + 1] = a[loc];
                // 탐색할 위치 갱신
                loc--;
            }

            // 적절한 위치에 삽입
            a[loc + 1] = newItem;
        }

        // 결과 출력
        System.out.println(Arrays.toString(a));
    }
}
