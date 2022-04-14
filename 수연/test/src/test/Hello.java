import java.util.*;

// 기준 값을 제일 크거나 제일 작지 않은 , 즉 적절한 원소를 골라서 기준값으로 삼고 , 그 값으로 partition 을 나누는 linear select 알고리즘
public class Hello {
    public static int linearSelect(int[] arr , int p , int r , int find){

        // 사이즈가 5 이하일 때에는 select 를 이용해서 값을 찾아준다. , p == r 일 때에는 처리해주지 않는다 , 짜피 select 에서 해줄 것임
        if(r - p < 5) return select(arr , p , r , find);

        // size 를 구함
        int size = r - p + 1;

        // 나누어 준 수를 올림을 진행해준다(배열을 5개씩 나눌 때 몇번 반복해야하는지 구함)
        int loopCount = (int)Math.ceil((double)size / 5d);

        // 각 5개 이하의 배열에서 중앙 값들을 저장할 tmp 배열
        int[] tmp = new int[loopCount];

        // 이제 각 5개의 배열들의 중앙값을 받을 for 문을 시작
        for(int i = 0; i < loopCount; i++){

            // 5개 짜리 배열의 시작위치
            int pValue = p + 5 * i;

            // 5개 짜리 배열의 마지막 위치
            int rValue = pValue + 4;

            // 끝에 도달하였을 떄 , rValue 에 특별한 행동을 진행해주어야 한다.
            if(i == loopCount - 1){
                // 끝에 도달했을 때에는 rValue 에다가 그냥 마지막 인덱스 넣어주면 된다.
                rValue = r;
            }

            // 5개 짜리의 배열에서 가운데 값을 뽑아내기 위한 연산 , 크기가 5일 경우에는 find == 3 을 줘야 한다.
            int findNumber = (rValue - pValue) / 2 + 1;

            // 각 linearSelect 를 호출하면서 , 중앙값들을 얻어낸다 , Select 를 바로 호출해도 되지만 linearSelect 호출해도 , 바로 Select 를 호출하기 때문에 , 가독성을 위해 linearSelect 를 호출
            tmp[i] = linearSelect(arr , pValue , rValue , findNumber);
        }

        // 중앙값들에서 중앙 값을 구하기 위해서 ,linearSelect 를 재귀호출 하게 된다 (이것 역시 가운데 값을 구하기 위해서 (tmp.length - 1) / 2 + 1 을 찾는다고 명시)
        int pivotValue = linearSelect(tmp , 0 , tmp.length - 1 , (tmp.length - 1) / 2 + 1);

        // 찾은 값의 index 를 구하고 partition 에다가 그 index를 넘겨서 해당 pivotValue를 기준원소로 삼음
        int q = partition(arr , p , r , findIndex(arr , pivotValue , p , r));

        System.out.println("q : " + q);
        // 기준 원소가 몇번째로 큰 수인지 확인
        int k = q - p + 1;

        // Select 구문과 동일
        if(find < k) return linearSelect(arr , p , q - 1 , find);
        else if(find == k) return arr[q];
        else return linearSelect(arr , q + 1 , r , find - k);
    }

    // pivot value 값의 인덱스를 찾아준다 , linear select 가 호출할 때만 호출 시켜서 탐색 횟수를 줄여준다.
    public static int findIndex(int arr[] , int value , int p , int r){
        // value 의 index 를 저장할 res
        int res = 0;

        // value 의 index 를 찾는 구문 , 더욱더 빠르게 하기 위해서 , break; 을 이용했음
        for(int i = p; i <= r; i++){
            if(value == arr[i]) {
                res = i;
                break;
            } // 찾은 index를 돌려냄
        }

        // 찾은 index 반환
        return res;
    }

    // p = 처음 , r = 마지막 , i = 찾는 수
    public static int select(int[] arr , int p , int r , int i){
        // 계속 탐색을 통해서 find 범위를 좁혀가면서 진행했기에 , p == r 인 경우 찾은 것임 (인덱스 에러를 피해주기 위해서는 해당 구문을 사용하여야 함)
        if(p >= r) return arr[p];

        // partition 을 통해서 왼쪽은 작은 애들 , 오른쪽은 큰 애들로 분류하게 된다.
        int q = partition(arr , p , r , r);

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
    public static int partition(int[] arr , int p , int r , int pivot){

        // linear select 를 통해 찾은 적절한 기준원소를 맨 마지막에 위치시킴
        swap(arr , pivot , r);

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
        System.out.println(linearSelect(arr , 0 , arr.length - 1 , find));
    }
}