import java.util.*;

public class Main {
    public static void quickSort(int[] arr , int p, int r){
        if(p >= r) return; // p가 r 보다 크거나 같으면 끝임

        // 적절한 위치에 삽입된 기준 원소의 인덱스를 반환함 , arr[q] 는 정렬된 상태이고 , 해당 arr[q] 를 기준으로 왼쪽은 작고 , 오른쪽은 큰 수들만 몰려있음
        int q = partition(arr , p , r);

        quickSort(arr , p , q - 1);
        quickSort(arr , q + 1 , r); // arr[q] 는 정렬이 되어있으니 q 를 기준으로 , 왼쪽 , 오른쪽을 정렬을 진행함
    }

    public static int partition(int[] arr , int p , int r){
        // 시작지점 바로 전으로 지정.
        int i = p - 1;

        // 시작점부터 기준원소 바로 전까지 진행한다.
        for(int j = p; j < r; j++){
            // 같은 경우 왼쪽에 보내는 방법을 선택 , 계속 기준 값보다 , 작거나 같은 값들이 있으면 왼쪽으로 몰아주는 것임
            if(arr[j] <= arr[r]) swap(arr , ++i , j);
        }

        // 마지막으로 적절한 위치에다가 기준원소를 집어넣는다.
        swap(arr , ++i , r);

        // pivot 의 위치를 반환한다.
        return i;
    }

    // 배열의 위치를 서로 바꿔주는 swap 함수
    public static void swap(int[] arr , int a , int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
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

        // quickSort 를 진행해주는데 , arr의 범위를 알려준다.
        quickSort(arr , 0 , arr.length - 1);

        // 정렬된 배열을 출력한다.
        System.out.println(Arrays.toString(arr));
    }
}