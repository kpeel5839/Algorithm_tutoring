import java.util.*;

/*
if(p == r) return arr[p];
를 사용했을 때 ,

5
2 1 3 141 2
-1

이러한 입력이 들어오게 되면 , p = 0 , q = -1 이러한 상황이 발생해서 인덱스 에러가 나게 된다.
그렇기 때문에 , 더욱이 안전하게 하려면 if(p >= r) 로 진행하게 되면
절대로 에러가 날 일이 없다.

사실 근데 , -1 과 같은 값이 입력으로 들어온 것부터가 에러이긴 하지만 , 알아놓으면 좋다.
 */
public class Main {
    // p = 처음 , r = 마지막 , i = 찾는 수
    public static int select(int[] arr , int p , int r , int i){
        // 계속 탐색을 통해서 find 범위를 좁혀가면서 진행했기에 , p == r 인 경우 찾은 것임 (인덱스 에러를 피해주기 위해서는 해당 구문을 사용하여야 함)
        if(p >= r) return arr[p];

        // partition 을 통해서 왼쪽은 작은 애들 , 오른쪽은 큰 애들로 분류하게 된다.
        int q = partition(arr , p , r);

        // 기준 원소가 지금 p ~ r 에서 몇번째로 큰놈인지를 정의한다.
        int k = q - p + 1;

        // k 가 더 큰 경우는 , 즉 i 가 더 작은 경우는 q 의 왼쪽에 있다라는 것이다. 그렇기 때문에 , 왼쪽을 탐색해준다.
        if(k > i) return select(arr , p , q - 1 , i);
        // k == i 라는 것은 기준원소가 찾는 수라는 것이다 , 그렇기 때문에 q를 반환한다 , k 를 반환하지 않는 이유는 k 는 인덱스처럼 표현하지 않았기 때문이다. ex) 0번째 , 1번째 ...
        else if(k == i) return arr[q];
        // 위에 상황이 다 아니라면 k보다 i 가 더 큰 경우밖에 존재하지 않음 , 그렇기 때문에 오른쪽 부분을 재귀적으로 호출한다.
        else return select(arr , q + 1 , r , i - k);

        /*
        return 을 다 해준 이유는 말단에서 p == r 이 된 경우 혹은 k == i 인 경우에 값을 return 하게 되면 ,
        연쇄적으로 값을 전달해주어야 하기 때문이다 , 즉 해당 값을 찾기 위해서 재귀호출을 진행하였고 , 각 재귀호출들은 결과값을 반환받는다.
        그리고서 계속해서 이전에 본인을 호출한 애들에게 넘기다 보면 , 결국 처음에 호출한 최상위 호출에게 값이 전달될 것이다.
         */
    }

    // p = 처음 , r = 마지막
    public static int partition(int[] arr , int p , int r){
        // 기준원소 삽입
        int x = arr[r];
        int i = p - 1;
        for(int j = p; j < r; j++){
            if(arr[j] <= x) swap(arr , ++i , j); // 서로의 위치를 교환
        }

        // 마지막 적절한 위치와 기준원소를 swap
        swap(arr , ++i , r);

        // 기준 원소의 인덱스를 반환
        return i;
    }

    // 그냥 전형적인 swap
    public static void swap(int[] arr , int a , int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        // 배열 크기 입력 및 , arr 선언
        int N = input.nextInt();
        int[] arr = new int[N];

        // arr 원소 입력 받기
        for(int i = 0; i < N; i++){
            arr[i] = input.nextInt();
        }

        // 찾는 수의 번째수를 입력한다.
        int find = input.nextInt();

        // 찾는 수의 값을 반환한다.
        System.out.println(select(arr , 0 , arr.length - 1 , find));
    }
}
