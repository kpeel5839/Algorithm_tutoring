import java.util.Scanner;

public class MaxHeap {
    // Max Heap Sort
    public static void maxHeapSort(int[] arr , int n){
        // 일단 최대 힙으로 만들어준다.
        buildHeap(arr, n);

        // 최대 힙으로 빌드 후에 첫번째 인덱스를 마지막 인덱스와 바꿔주고
        // 힙의 조건을 만족시킬 수 있도록 heapify 를 반복하는데 , 정렬이 된 곳은 건드리지 않는다.
        for(int i = n; i != 1; i--){
            swap(arr , 1 , i); // 맨 끝에 최소값 박아 놓기
            heapify(arr , 1 ,i - 1);
        }
    }

    // swap 함수
    public static void swap(int[] arr , int a , int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    // buildHeap , heap 으로 만들어주는 부이다.
    public static void buildHeap(int[] arr , int n){

        // 부모가 있는 애들만 하위 노드들 부터 쫘르륵 heapify 연산을 진행해서 , 차근차근 heap 의 조건을 만족시킨다.
        for(int i = (n / 2); i != 0; i--){
            heapify(arr, i , n);
        }
    }

    public static void heapify(int[] arr , int k , int n){
        int left = 2 * k; // 왼쪽 자식
        int right = 2 * k + 1; // 오른쪽 자식

        // 더 큰 값의 인덱스를 저장할 변수
        int max;

        // 오른쪽 자식 왼쪽 자식 다 있는 경우
        if(right <= n){
            // 왼쪽 자식이 더 큰 경우
            if(arr[left] > arr[right]) max = left;

            // 오른쪽 자식이 더 크거나 같은 경우
            else max = right;
        }

        // 왼쪽 자식만 있는 경우
        else if(left <= n) max = left;

        // 자식이 아얘 없으면 return
        else return;

        // 자식 중에 본인보다 큰 애가 있으면 , swap 해준 뒤에 ,
        // 바꾼 다음에 또 힙의 조건을 만족 안할 수도 있으니까 , 하위 노드로 내려가면서 다시 heapify
        if(arr[max] < arr[k]){
            swap(arr , max , k);
            heapify(arr , max , n);
        }
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        // 배열의 크기를 입력 받는다.
        int N = input.nextInt();

        // 배열을 선언해준다.
        // 여기서 정말 너무 중요한 것이 , 루트노드가 인덱스가 0이면 복잡해지는 것이 너무 많으니까 루트노드로 1로 만들기 위해서 , N + 1 짜리의 배열을 생성
        int[] arr = new int[N + 1];

        // 배열을 입력받는다 , 1번째 부터 받는다.
        for(int i = 1; i <= N; i++){
            arr[i] = input.nextInt();
        }

        // maxHeapSort 를 진행해주는데 , arr의 범위를 알려준다 , 근데 0번째 배열은 사용하지 않기 때문에 , 실질적인 크기는 arr.length - 1이다.
        // arr.length - 1 은 맨 마지막 인덱스를 의미한다 , 그래서 2 * k + 1 이 n 보다 작거나 같으면 자식이 전부 있다라는 것을 성립이 가능하다.
        maxHeapSort(arr , arr.length - 1);

        // 정렬된 배열을 출력한다.
        for(int i = 1; i <= N; i++) System.out.print(arr[i] + " ");
    }
}
