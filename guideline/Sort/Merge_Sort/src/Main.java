import java.util.*;

public class Main {
    public static void mergeSort(int[] arr , int p, int r){
        if(p == r) return; // p == r 이 되면 끝 , 즉 사이즈가 1이 되면 끝낸다.

        int q = (p + r) / 2; // 가운데를 구해주고
        mergeSort(arr , p , q);
        mergeSort(arr,  q + 1 , r); // 가운데를 기준으로 반으로 나눠준다.
        merge(arr, p , q , r); // 정렬되어 있는 p ~ r 을 가지고 정렬을 시작한다.
    }

    public static void merge(int[] arr , int p , int q , int r){
        // 시작점인 p 를 left 로 지정
        int left = p;

        // 가운데인 q + 1 을 right 로 지정
        int right = q + 1;

        // 정렬에 사용될 temp 배열 선언
        int[] tmp = new int[r - p + 1];

        // temp 배열에 사용될 index 변수 선언
        int index = 0;

        // left 가 중간을 넘어가거나 , 혹은 right 가 끝을 넘어갈 때 까지 , 즉 정렬된 p ~ q , q + 1 ~ r 중 남은 요소가 없을 때 까지 진행
        while(left <= q && right <= r){

            // left 가 더 작거나 같은 경우에는 left 를 먼저 넣음으로써 , 안전정렬을 유지함
            if(arr[left] <= arr[right]) tmp[index++] = arr[left++];

            // right 가 더 작은 경우는 right 를 먼저 넣어줌
            else tmp[index++] = arr[right++];
        }

        while(left <= q){ // 아직 left 에 남아있는 요소가 있을 때
            tmp[index++] = arr[left++];
        }

        while(right <= r){ // 아직 right 에 남아있는 요소가 있을 때
            tmp[index++] = arr[right++];
        }

        // tmp 에다가 arr의 p ~ r 까지 정렬해서 넣었던 요소들을 순차적으로 다시 arr 에 넣음(정렬 결과)
        index = 0;
        for(int i = p; i <= r; i++){
            arr[i] = tmp[index++];
        }
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        // 배열의 크기를 입력 받는다.
        int N = input.nextInt();

        // 배열을 선언해준다.
        int[] arr = new int[N];

        // 배열을 입력받는다.
        for(int i = 0; i < N; i++){
            arr[i] = input.nextInt();
        }

        // mergeSort 를 진행해주는데 , arr의 범위를 알려준다.
        mergeSort(arr , 0 , arr.length - 1);

        // 정렬된 배열을 출력한다.
        System.out.println(Arrays.toString(arr));
    }
}
