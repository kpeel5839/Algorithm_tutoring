import java.util.*;

// Counting Sort (계수 정렬)
public class Main {
    public static void main(String[] args) {
        // 입력 받음
        Scanner input = new Scanner(System.in);

        // 배열 사이즈를 입력받는다.
        int N = input.nextInt();

        // 기존 배열
        int[] a = new int[N];

        // 정렬을 해서 넣을 배열
        int[] b = new int[N];

        // 기존 배열을 입력 받는다.
        for(int i = 0; i < N; i++) {
            a[i] = input.nextInt();
        }

        // 각 숫자들의 개수를 입력 받을 배열을 선언
        int[] c = new int[11];

        // a 배열의 숫자들을 세서 , c 배열에 갱신
        for(int i = 0; i < a.length; i++) {
            c[a[i]]++;
        }

        // 기존의 c[i] (a 배열 내에 i 의 개수) 를 -> c[i](a 배열 내의 i 보다 작거나 같은 숫자의 개수)
        for(int i = 2; i < c.length; i++) {
            c[i] = c[i] + c[i - 1];
        }

        // c 배열을 이용하여 정렬 , b에 집어넣고 나면 c[a[i]]-- 로 해당 i 가 b 배열의 몇번째에 들어가야 하는지 갱신
        for(int i = a.length - 1; i != -1; i--) {
            b[c[a[i]] - 1] = a[i];
            c[a[i]]--;
        }

        // 정렬된 배열을 출력
        System.out.println(Arrays.toString(b));
    }
}