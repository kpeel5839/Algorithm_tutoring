import java.util.*;

// Radix_Sort

// 원소들의 값이 모두 k 자릿수 이하의 자연수인 특수한 경우에 사용 가능한 정렬 방법

/*
- 서순
1) 가장 낮은 1의 자릿수만 가지고 모든 수를 정렬한다.
2) 그 다음으로 낮은 10의 자릿수만 가지고 모든 수를 정렬한다.
3) 그러면서 쭉쭉 k 자리들을 비교하면서 정렬하면 , 최종적으로 정렬된 결과를 얻는다.

각 자릿수마다 정렬을 진행할 때에는 counting sort 로 진행하면 된다.
 */
public class Main {
    public static void countingSort(int[] a , int digit){

        // 한자리는 0 ~ 9 까지이니까 10으로 진행하자.
        int[] c = new int[10];
        int[] b = new int[a.length];

        // 자릿수를 다 읽음
        for(int i = 0; i < a.length; i++){
            c[getDigit(a[i] , digit)]++;
        }

        // 각 수들의 위치를 정의해줌
        for(int i = 1; i < 10; i++){
            c[i] = c[i - 1] + c[i];
        }

        // 이전에 정의해둔 위치로 삽입 , 안전정렬을 위해서 끝에서부터 주입을 시작
        for(int i = a.length - 1; i != -1; i--){
            // 인덱스에 맞춰서 들어가야할 자리 - 1 을 하여서 주입
            b[c[getDigit(a[i] , digit)] - 1] = a[i];

            // 넣었으니까 c[getDigit(a[i] , digit)]-- 진행
            c[getDigit(a[i], digit)]--;
        }

        // 해당 자릿수로 정렬을 진행한 배열을 a 배열에 갱신
        for(int i = 0; i < a.length; i++){
            a[i] = b[i];
        }

        // 각 자리수 마다 정렬을 실행하고 난 상태를 출력
        System.out.println(Arrays.toString(a));
    }

    // 수와 , 자리가 주어지면 해당 자릿수를 뽑아내는 로직
    public static int getDigit(int value , int digit){
        // 나머지 연산에 사용할 mod 변수
        int mod = (int)Math.pow(10 , digit);

        // 나누기 연산에 사용할 div 변수
        int div = (int)Math.pow(10 , digit - 1);

        // value 를 mod 로 나눈 다음에 div 로 나누어서 각 자릿수를 도출
        return (value % mod) / div;

        // ex ) value = 123 , digit = 2 라고 가정하였을 때
        // mod = 100 , div = 10
        // 123 % 100 = 23 , 23 / 10 = 2
        // 결국 내가 원하고자 하는 두번째 자릿수를 얻을 수 있음
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        // 배열의 크기
        int N = input.nextInt();

        // 자릿수를 K 이하로 설정
        int K = input.nextInt();

        // a 배열 선언
        int[] a = new int[N];

        // a 배열 값 대입
        for(int i = 0; i < N; i++){
            a[i] = input.nextInt();
        }

        // 정렬되기 이전 배열 상태
        System.out.println(Arrays.toString(a));

        // 각 자릿수 마다 Counting Sort 를 이용해 sort를 진행한다.
        for(int i = 1; i <= K; i++){
            countingSort(a , i);
        }
    }
}
